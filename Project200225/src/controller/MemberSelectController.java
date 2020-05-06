package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberSelectService;


@WebServlet("/memberSelect")
public class MemberSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelectController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		MemberSelectService memberSelectService = new MemberSelectService();
		MemberDTO member = MemberSelectService.MemberSelect(id);
	
		request.setAttribute("member", member);		
		RequestDispatcher dispatch = request.getRequestDispatcher("MemberModify.jsp");
		dispatch.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
