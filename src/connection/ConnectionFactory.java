package connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	//Construtor
	public ConnectionFactory() {
		
		//Configurar o pool
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Guiposit@@123#");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		//ligar o pool com o data source
		this.dataSource = comboPooledDataSource;
	}
	

	public Connection recuperaConexao() throws SQLException{
		return this.dataSource.getConnection();
	}

}
