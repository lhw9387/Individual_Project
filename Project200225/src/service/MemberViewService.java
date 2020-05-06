package service;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.DAO;
import dto.MemberDTO;

public class MemberViewService {

	public MemberDTO memberView(String id) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		MemberDTO member = dao.memberView(id);
		
		close(con);
		return member;
	}

}
