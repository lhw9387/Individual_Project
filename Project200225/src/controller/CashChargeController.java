package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CashChargeService;

@WebServlet("/CashCharge")
public class CashChargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CashChargeController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		int cash = Integer.parseInt(request.getParameter("cash"));
		System.out.println("cash" + cash);
		
		CashChargeService CashChargeService = new CashChargeService();
		int result = CashChargeService.CashCharge(id, cash);
		if(result==1) {
			response.sendRedirect("CashChargeSucess.jsp");
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
