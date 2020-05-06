package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import dao.DAO;
import dto.ProductDTO;

public class ProductSearchService {

	public List<ProductDTO> ProductSearch(String search) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.ProductSearch(search);
		
		close(con);
		return productList;
	}

}
