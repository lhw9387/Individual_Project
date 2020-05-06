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
import service.ProductMakeService;

@WebServlet("/ProductMake")
public class ProductMakeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductMakeController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int size = 10*1024*1024;
		String savePath = "C:/Users/2/Desktop/Development/source/servlet/Project200225/WebContent/PfileUpload";
		
		MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
		ProductDTO product = new ProductDTO();
		
		
		product.setProductname(multi.getParameter("productname"));
		product.setCategory(multi.getParameter("category"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setPfile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		product.setSize(multi.getParameter("size"));
		
		ProductMakeService ProductMakeService = new ProductMakeService();
    	int result = ProductMakeService.ProductMake(product);
    	if(result==1) {
    		response.sendRedirect("ProductMakeSucess.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
