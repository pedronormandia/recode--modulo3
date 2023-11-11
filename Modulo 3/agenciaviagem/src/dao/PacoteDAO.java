package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.connectionFactory;
import model.Pacote;

public class PacoteDAO {
	public void save(Pacote pacote) {

		String sql = "INSERT INTO pacote(data,valor,tempo_estadia, destino) VALUES (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(pacote.getData().getTime()));
			pstm.setFloat(2, pacote.getValor());
			pstm.setInt(3, pacote.getTempoEstadia());
			pstm.setString(4, pacote.getDestino());
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
	
	public Pacote readById(int id) {
		String sql = "select * from pacote WHERE id = ?";

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Pacote pacote = new Pacote();

		try {
			con = connectionFactory.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				pacote.setId(rset.getInt("id"));
				pacote.setData(rset.getDate("data"));
				pacote.setValor(rset.getFloat("valor"));
				pacote.setTempoEstadia(rset.getInt("tempo_estadia"));
				pacote.setDestino(rset.getString("destino"));
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
		return pacote;
	}

	public List<Pacote> getPacotes() {

		String sql = "SELECT * FROM pacote";
		List<Pacote> pacotes = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Pacote pacote = new Pacote();

				pacote.setId(rset.getInt("id"));
				pacote.setData(rset.getDate("data"));
				pacote.setValor(rset.getFloat("valor"));
				pacote.setTempoEstadia(rset.getInt("tempo_estadia"));
				pacote.setDestino(rset.getString("destino"));
				pacotes.add(pacote);
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
		return pacotes;
	}

	public void update(Pacote pacote) {

		String sql = "UPDATE pacote SET data=?, valor=?, tempo_estadia=?, destino=? WHERE id=?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = connectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(pacote.getData().getTime()));
			pstm.setFloat(2, pacote.getValor());
			pstm.setInt(3, pacote.getTempoEstadia());
			pstm.setString(4, pacote.getDestino());
			pstm.setInt(5, pacote.getId());
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

		String sql = "DELETE FROM pacote WHERE id=?";

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
