package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		 //utilizando o try-with-resources, não mais é preciso explicitar os fechamentos (close())
		 //Criar conexão com o banco de dados
		 ConnectionFactory connectionFactory = new ConnectionFactory(); 
		 try(Connection connection = connectionFactory.recuperaConexao()){
			 
			 //setar o auto commit como falso para ter controle doq será inserido, e em qual momento será inserido
			 connection.setAutoCommit(false);
			 
			 //try vai tentar inserir os dados, caso algum dado não seja inserido corretamente, vai fazer a reversão/rollback e não inserir nada
			 try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (name, description) VALUES (?, ?)", 
					 Statement.RETURN_GENERATED_KEYS)) {
				 
				 adicionarVariavel("Smart tv", "Really smart", stm);
				 adicionarVariavel("Dumb tv", "Really dumb", stm);
				 
				 connection.commit();
				 
			 }catch(Exception e) {
				 e.printStackTrace();
				 System.out.println("ROLLBACK EXECUTADO");
				 connection.rollback();
			 }
		 }	 
	}

	private static void adicionarVariavel(String name, String description, PreparedStatement stm) throws SQLException {
		 stm.setString(1 , name);
		 stm.setString(2, description);
		 
		 if(name.equals("Radio")) {
			 throw new RuntimeException("Não foi possível adicionar o produto");
		 }
		 
		 stm.execute();
		 
		 try(ResultSet rst = stm.getGeneratedKeys()){
			 while(rst.next()) {
				 Integer id = rst.getInt(1);
				 System.out.println("O ID desse item é: " + id);
			 }
		 }

	}

}
