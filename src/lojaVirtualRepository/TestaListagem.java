package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		
		//Criar conexão com o banco de dados
		ConnectionFactory connectionfactory = new ConnectionFactory();
		Connection connection = connectionfactory.recuperaConexao();
		
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NAME, DESCRIPTION FROM PRODUTO");
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String name = rst.getString("name");
			String description = rst.getString("description");
			
			System.out.println(id);
			System.out.println(name);
			System.out.println(description);
		}

		connection.close();
		
	}

}
