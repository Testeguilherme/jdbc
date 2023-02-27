package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class TestaInsercao {
	
	 public static void main(String[] args) throws SQLException {
		
		 ConnectionFactory connectionFactory = new ConnectionFactory(); 
		 Connection connection = connectionFactory.recuperaConexao();
		 Statement stm = connection.createStatement();
		 
		 //aspas simples para estabelecer os valores
		 stm.execute("INSERT INTO PRODUTO (name, description) VALUES ('Mouse', 'Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);
	
		 ResultSet rst = stm.getGeneratedKeys();
		 
		 while(rst.next()) {
			 Integer id = rst.getInt(1);
			 System.out.println("O ID desse item é: " + id);
			 
		 }
	}
}
