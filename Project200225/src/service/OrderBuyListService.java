package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dto.OrderDTO;

public class OrderBuyListService {

	public List<OrderDTO> OrderBuyList() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		List<OrderDTO> OrderBuyList = new ArrayList<OrderDTO>();
		
		OrderBuyList = dao.OrderBuyList();
		
		close(con);
		return OrderBuyList;
	}

}
