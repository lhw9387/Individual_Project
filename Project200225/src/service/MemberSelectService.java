package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;
import dto.MemberDTO;

public class MemberSelectService {

	public static MemberDTO MemberSelect(String id) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		MemberDTO member = dao.memberSelect(id);
		
		close(con);
		return member;
	}

}
