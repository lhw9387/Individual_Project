package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DAO;
import dto.ReviewDTO;

public class ProductReviewMakeService {

	public int ProductReview(ReviewDTO review) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		int result = dao.ProductReview(review);
		if(result==1) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
