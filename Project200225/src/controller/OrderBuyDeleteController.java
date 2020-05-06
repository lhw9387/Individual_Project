package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderBuyDeleteService;

@WebServlet("/OrderBuyDelete")
public class OrderBuyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderBuyDeleteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int orderno = Integer.parseInt(request.getParameter("orderno"));
		
		OrderBuyDeleteService OrderBuyDeleteService = new OrderBuyDeleteService();
		int result = OrderBuyDeleteService.OrderBuyDelete(orderno);
		
		if(result == 1) {
			response.sendRedirect("OrderBuyList");
		}
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
