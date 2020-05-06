package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ReviewDTO;
import service.ReviewListService;


@WebServlet("/ReviewList")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewListController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ReviewListService ReviewListService = new ReviewListService();
		List<ReviewDTO> ReviewList = new ArrayList<ReviewDTO>();
		
		ReviewList = ReviewListService.ReviewList();
		request.setAttribute("ReviewList", ReviewList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("ProductList");
		dispatch.forward(request, response);
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}