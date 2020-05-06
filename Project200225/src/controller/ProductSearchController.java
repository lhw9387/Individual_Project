package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductSearchService;

@WebServlet("/productSearch")
public class ProductSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductSearchController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String search = "%"+request.getParameter("search")+"%";
    	ProductSearchService ProductSearchService = new ProductSearchService();
    	List<ProductDTO> productList = ProductSearchService.ProductSearch(search);
    	request.setAttribute("productList", productList);
    	RequestDispatcher dispatch = request.getRequestDispatcher("SearchResult.jsp");
    	dispatch.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
