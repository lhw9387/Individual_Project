package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;

public class ProductDeletService {

	public int productDelete(int productno) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		int result = dao.productDelete(productno);
		if(result==1) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

}
