package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.OrderDTO;
import service.OrderBuyService;

@WebServlet("/OrderBuy")
public class OrderBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderBuyController() {
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
		String name = multi.getParameter("name");
		String address= multi.getParameter("postcode")+"."+multi.getParameter("address2")+"."+multi.getParameter("detailAddress")+"."
				+multi.getParameter("extraAddress");
		String phone = multi.getParameter("phone");
		String email = multi.getParameter("email");
		
		OrderDTO OrderDTO = new OrderDTO();
		OrderDTO.setId(id);
		OrderDTO.setProductno(productno);
		OrderDTO.setProductname(productname);
		OrderDTO.setPrice(price);
		OrderDTO.setName(name);
		OrderDTO.setAddress(address);
		OrderDTO.setPhone(phone);
		OrderDTO.setEmail(email);
		
		OrderBuyService OrderBuyService = new OrderBuyService();
		int result = OrderBuyService.orderBuy(OrderDTO);
		if(result==1) {
			response.sendRedirect("OrderBuySucess.jsp");
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
