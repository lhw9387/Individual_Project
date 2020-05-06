package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.*;

import dao.DAO;
import dto.MemberDTO;

public class MemberListService {

	public List<MemberDTO> MemberList() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<MemberDTO> MemberList = new ArrayList<MemberDTO>();
		
		MemberList = dao.memberList();
		
		close(con);
		return MemberList;
	}

}
