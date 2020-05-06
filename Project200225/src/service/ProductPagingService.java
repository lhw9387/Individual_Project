package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import dao.DAO;
import dto.ProductDTO;

public class ProductPagingService {

	public int listCount() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.listCount();
		
		close(con);
		return listCount;
	}

	public List<ProductDTO> productList(int startRow, int endRow) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.productList(startRow, endRow);
		
		close(con);
		return productList;
	}

	public List<ProductDTO> productNameList(int startRow, int endRow) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.productNameList(startRow, endRow);
		
		close(con);
		return productList;
	}

	public List<ProductDTO> productPriceAscList(int startRow, int endRow) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.productPriceAscList(startRow, endRow);
		
		close(con);
		return productList;
	}

	public List<ProductDTO> productPriceDescList(int startRow, int endRow) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ProductDTO> productList = dao.productPriceDescList(startRow, endRow);
		
		close(con);
		return productList;
	}

}
