package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PagingDTO;
import dto.ProductDTO;
import service.ProductPagingShoesService;

@WebServlet("/ProductListShoes")
public class ProductListShoesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListShoesController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ProductPagingShoesService ProductPagingShoesService = new ProductPagingShoesService();
		int page=1;
		int limit=3;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listCount = ProductPagingShoesService.listCount();
		
		int startRow = (page-1)*limit+1;
		int endRow = page*limit;
		
		List<ProductDTO> productList = ProductPagingShoesService.productList(startRow, endRow);
			
		
		int maxPage = (int)((double)listCount / limit+0.9);
		int startPage = (((int)((double)page/10+0.9))-1)*10+1;
		int endPage = startPage +10-1;
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PagingDTO paging = new PagingDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);
		
		request.setAttribute("paging", paging);
		request.setAttribute("productList", productList);
		RequestDispatcher dispatch = request.getRequestDispatcher("ShoesList.jsp");
		dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}