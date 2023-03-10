package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class TestaRemocao {

		public static void main(String[] args) throws SQLException {
			
			//criar conexao com o banco de dados
			ConnectionFactory con = new ConnectionFactory();
			Connection connection = con.recuperaConexao();
			
			
			PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
			stm.setInt(1, 2);
			stm.execute();
			
			Integer linhasModificadas = stm.getUpdateCount();
			System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
			
		}
	
}
