package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.DAO;
import dto.ReviewDTO;

public class ProductReviewPagingService {

	public int listCount() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int listCount = dao.reviewlistCount();
		
		close(con);
		return listCount;
	}

	public List<ReviewDTO> productreviewList(int startRow, int endRow) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ReviewDTO> productreviewList = dao.productreviewList(startRow, endRow);
		
		close(con);
		return productreviewList;
	}

}