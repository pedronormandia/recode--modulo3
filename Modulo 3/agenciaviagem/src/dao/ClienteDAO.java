package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.connectionFactory;
import model.Cliente;

public class ClienteDAO {

	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente(nome,telefone,cpf) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getCpf());
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

	public Cliente readById(int id) {
		String sql = "select * from cliente WHERE id = ?";

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Cliente cliente = new Cliente();

		try {
			con = connectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setCpf(rset.getString("cpf"));
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
		return cliente;
	}

	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Cliente cliente = new Cliente();

				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setCpf(rset.getString("cpf"));
				clientes.add(cliente);
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
		return clientes;
	}

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET nome=?,telefone=?,cpf=? WHERE id=?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getCpf());
			pstm.setInt(4, cliente.getId());
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

		String sql = "DELETE FROM cliente WHERE id=?";

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
