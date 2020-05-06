package service;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.DAO;
import dto.OrderDTO;

public class OrderBuyService {

	public int orderBuy(OrderDTO orderDTO) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);		
		
		int result = dao.OrderBuy(orderDTO);
		
		if(result==1) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

}
