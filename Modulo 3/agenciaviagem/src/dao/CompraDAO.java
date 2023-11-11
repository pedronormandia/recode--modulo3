package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.connectionFactory;
import model.Compra;

public class CompraDAO {
	ClienteDAO cdao = new ClienteDAO();
	PacoteDAO pdao = new PacoteDAO();
	
	public void save(Compra compra) {

		String sql = "INSERT INTO compra(id_cliente,id_pacote,forma_pagamento) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getCliente().getId());
			pstm.setDouble(2, compra.getPacote().getId());
			pstm.setString(3, compra.getFormaPagamento());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Compra readById(int id) {
		String sql = "select * from compra WHERE id = ?";

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Compra compra = new Compra();

		try {
			con = connectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				compra.setId(rset.getInt("id"));
				compra.setCliente(cdao.readById(rset.getInt("id_cliente")));
				compra.setPacote(pdao.readById(rset.getInt("id_pacote")));
				compra.setFormaPagamento(rset.getString("forma_pagamento"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return compra;
	}
	
	public List<Compra> getCompras() {

		String sql = "SELECT * FROM compra";
		List<Compra> compras = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Compra compra = new Compra();
				
				
				compra.setId(rset.getInt("id"));
				compra.setCliente(cdao.readById(rset.getInt("id_cliente")));
				compra.setPacote(pdao.readById(rset.getInt("id_pacote")));
				compra.setFormaPagamento(rset.getString("forma_pagamento"));
				compras.add(compra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compras;
	}
	
	
	public void update(Compra compra) {

		String sql = "UPDATE compra SET id_cliente= ? ,id_pacote = ?,forma_pagamento = ? WHERE id=?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getCliente().getId());
			pstm.setDouble(2, compra.getPacote().getId());
			pstm.setString(3, compra.getFormaPagamento());
			pstm.setInt(4, compra.getId());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			try {

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int id) {

		String sql = "DELETE FROM compra WHERE id=?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			try {

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
