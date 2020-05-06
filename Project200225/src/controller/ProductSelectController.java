package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductViewService;

@WebServlet("/productSelect")
public class ProductSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductSelectController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int productno = Integer.parseInt(request.getParameter("productno"));
    	ProductViewService ProductViewService = new ProductViewService();
    	ProductDTO product = ProductViewService.productView(productno);
    	
    	request.setAttribute("product", product);
    	RequestDispatcher dispatch = request.getRequestDispatcher("ProductModify.jsp");
    	dispatch.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
