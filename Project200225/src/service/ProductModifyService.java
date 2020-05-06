package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;
import dto.ProductDTO;

public class ProductModifyService {

	public int productModify(ProductDTO product) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		int result = dao.productModify(product);
		if(result==1) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
