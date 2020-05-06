package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.MemberDTO;
import service.MemberModifyService;

@WebServlet("/MemberModify")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberModifyController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int size = 10*1024*1024;
		
    	String savePath = "C:/Users/2/Desktop/Development/source/servlet/Project200225/WebContent/PfileUpload";
    	
    	MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
    	String id = multi.getParameter("id");
		String password = multi.getParameter("password");
		String name = multi.getParameter("name");
		String phone = multi.getParameter("phone");
		String address= multi.getParameter("postcode")+"."+multi.getParameter("address2")+"."+multi.getParameter("detailAddress")+"."
				+multi.getParameter("extraAddress");
		String email = multi.getParameter("email");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPassword(password);
		memberDTO.setName(name);
		memberDTO.setAddress(address);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		
		MemberModifyService memberModifyService = new MemberModifyService();
		int result = memberModifyService.memberModify(memberDTO);
		
		if(result==1) {
			response.sendRedirect("MemberModifySuccess.jsp");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
