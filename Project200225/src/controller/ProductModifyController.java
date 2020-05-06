package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.ProductDTO;
import service.ProductModifyService;

@WebServlet("/ProductModify")
public class ProductModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int size = 10*1024*1024;
    	String savePath = "C:/Users/2/Desktop/Development/source/servlet/Project200225/WebContent/PfileUpload";
		
		MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
		ProductDTO product = new ProductDTO();
		product.setProductno(Integer.parseInt(multi.getParameter("productno")));
		product.setProductname(multi.getParameter("productname"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setCategory(multi.getParameter("category"));
		product.setPfile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		 	
    	
		ProductModifyService ProductModifyService = new ProductModifyService();
    	int result = ProductModifyService.productModify(product);
    	if(result ==1) {
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
