package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;

@WebServlet("/MemberLogin")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberLoginService MemberLoginService = new MemberLoginService();
		HttpSession session = request.getSession();
		boolean result = MemberLoginService.memberLogin(id, password);
				
		if(result) {
			session.setAttribute("id", id);
			response.sendRedirect("ProductList");
		} else {
			response.sendRedirect("LoginFail.jsp");
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
