package lojaVirtualRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDAO;
import connection.ConnectionFactory;
import lojaVirtualRepository.modelo.Produto;

public class TestaInsercaoEListagemComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaProduto = produtoDao.listar();
			listaProduto.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
