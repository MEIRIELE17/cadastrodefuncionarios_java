package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexao1 {

	public static Connection conecta_cadastro() throws SQLException {
		               
	
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");	
		
		return DriverManager.getConnection("jdbc:mysql://localhost/bancodedados", "root","");
		
		
		
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
		
			
		}
			
	}}
