package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.CartDTO;
import service.CartInsertService;

@WebServlet("/Cartinsert")
public class CartInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartInsertController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int size = 10*1024*1024;
		String savePath = "C:/Users/2/Desktop/Development/source/servlet/Project200225/WebContent/PfileUpload";
		
		MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
		String id = multi.getParameter("id");
		int productno = Integer.parseInt(multi.getParameter("productno"));
		String productname = multi.getParameter("productname");
		int price = Integer.parseInt(multi.getParameter("price"));
		int amount = Integer.parseInt(multi.getParameter("amount"));
		String size1 = multi.getParameter("size");
		int totalprice = Integer.parseInt(multi.getParameter("sum"));
		System.out.println(id);
		CartDTO cart = new CartDTO();
		cart.setId(id);
		cart.setProductno(productno);
		cart.setProductname(productname);
		cart.setPrice(price);
		cart.setAmount(amount);
		cart.setSize(size1);
		cart.setTotalprice(totalprice);
		
		CartInsertService CartInsertService = new CartInsertService();
    	int result = CartInsertService.CartInsert(cart);
    	if(result==1) {
    		response.sendRedirect("ProductList");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
