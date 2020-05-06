package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;
import dto.ProductDTO;

public class ProductViewService {

	public int setHit(int productno) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		int result = dao.setHit(productno);
		if(result == 1) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public ProductDTO productView(int productno) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		ProductDTO product = dao.productView(productno);
		
		close(con);
		return product;
	}

}
