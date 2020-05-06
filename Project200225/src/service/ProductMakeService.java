package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import dao.DAO;
import dto.ProductDTO;

public class ProductMakeService {

	public int ProductMake(ProductDTO product) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		int result = dao.ProductMake(product);
		if(result==1) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
