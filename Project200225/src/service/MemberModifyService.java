package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DAO;
import dto.MemberDTO;

public class MemberModifyService {

	public int memberModify(MemberDTO memberDTO) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.memberModify(memberDTO);
		if(result ==1) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
