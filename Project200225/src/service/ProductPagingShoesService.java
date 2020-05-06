package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.DAO;
import dto.ProductDTO;

public class ProductPagingShoesService {

	public int listCount() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.listCountShoes();
		
		close(con);
		return listCount;
	}

	public List<ProductDTO> productList(int startRow, int endRow) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.productListShoes(startRow, endRow);
		
		close(con);
		return productList;
	}

}
