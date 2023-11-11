package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionFactory {
	
	private static final String USERNAME ="root";
	private static final String PASSWORD ="123456";
	
	private static final String DATABASE_URL  ="jdbc:mysql://localhost:3306/agenciaviagem";
	
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception{
		
		Connection con= createConnectionToMySQL();
		
		if (con !=null) {
			System.out.println("conexão obtida com sucesso "+ con);
		}
	}
	
	
	
	

}



