package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dto.ReviewDTO;

public class ReviewListService {

	public List<ReviewDTO> ReviewList() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<ReviewDTO> ReviewList = new ArrayList<ReviewDTO>();
		
		ReviewList = dao.ReviewList();
		
		close(con);
		return ReviewList;
	}

}
