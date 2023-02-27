package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		
	}

}
