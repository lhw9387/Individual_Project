package service;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.DAO;

public class MemberDeleteService {

	public int memberDelete(String id) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);	
		
		int result = dao.memberDelete(id);
		
		if(result==1) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

}
