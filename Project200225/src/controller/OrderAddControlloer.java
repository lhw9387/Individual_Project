package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import dto.ProductDTO;
import service.OrderAddService;

@WebServlet("/OrderAdd")
public class OrderAddControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderAddControlloer() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int productno = Integer.parseInt(request.getParameter("productno"));
    	String id = request.getParameter("id");
    	
    	OrderAddService OrderAddService = new OrderAddService();
    	OrderAddService.setHit(productno);
    	ProductDTO order = OrderAddService.OrderAdd(productno);
    	MemberDTO member = OrderAddService.memberView(id);
    	
    	request.setAttribute("order", order);  	
    	request.setAttribute("member", member);
    	
    	RequestDispatcher dispatch = request.getRequestDispatcher("OrderPage.jsp");
    	dispatch.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
