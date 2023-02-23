package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {

		
		ConnectionFactory connectionfactory = new ConnectionFactory();
		Connection connection = connectionfactory.recuperaConexao();
		
		System.out.println("Fechando conexão!");
		
		connection.close();
		
	}

}
