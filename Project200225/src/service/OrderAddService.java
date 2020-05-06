package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;
import dto.MemberDTO;
import dto.ProductDTO;

public class OrderAddService {
	
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

	public ProductDTO OrderAdd(int productno) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		ProductDTO product = dao.productView(productno);
		
		close(con);
		return product;
	}

	public MemberDTO memberView(String id) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		MemberDTO member = dao.memberView(id);
		
		close(con);
		return member;
	}
	
}
