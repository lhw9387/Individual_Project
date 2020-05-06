package service;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.DAO;

public class MemberLoginService {

		public boolean memberLogin(String id, String password) {
			DAO dao = DAO.getInstance();
			Connection con = getConnection();
			dao.setConnection(con);
			
			boolean result = dao.memberLogin(id, password);
			
			return result;
		}

}
