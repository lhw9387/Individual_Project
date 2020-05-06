package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.ReviewDTO;
import service.ProductReviewMakeService;

@WebServlet("/ReviewWrite2")
public class ReviewWrite2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewWrite2Controller() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int size = 10*1024*1024;
    	String savePath = "C:/Users/2/Desktop/Development/source/servlet/Project200225/WebContent/RfileUpload";
		
    	MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
		
    	ReviewDTO review = new ReviewDTO();
		
    	review.setProductno(Integer.parseInt(multi.getParameter("productno")));
    	review.setId(multi.getParameter("id"));
    	review.setTitle(multi.getParameter("title"));
    	review.setContents(multi.getParameter("contents"));
    	review.setRfile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
    	ProductReviewMakeService ProductReviewMakeService = new ProductReviewMakeService();
    	int result = ProductReviewMakeService.ProductReview(review);
    	if(result==1) {
    		response.sendRedirect("ProductReviewSucess.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 호출");
		doProcess(request, response);
	}

}
