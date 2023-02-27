package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import connection.ConnectionFactory;
import lojaVirtualRepository.modelo.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = CategoriaDAO.listar();
			
		}
		
		

		
		
		
	}

}
