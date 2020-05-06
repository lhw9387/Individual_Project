package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.OrderDTO;
import service.OrderBuyListService;

@WebServlet("/OrderBuyList")
public class OrderBuyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderBuyListController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		OrderBuyListService OrderBuyListService = new OrderBuyListService();
		List<OrderDTO> OrderBuyList = new ArrayList<OrderDTO>();
		
		OrderBuyList = OrderBuyListService.OrderBuyList();
		request.setAttribute("OrderBuyList", OrderBuyList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("OrderBuyList.jsp");
		dispatch.forward(request, response);
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
