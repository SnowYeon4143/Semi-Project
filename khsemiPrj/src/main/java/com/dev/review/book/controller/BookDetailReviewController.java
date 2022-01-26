package com.dev.review.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.probook.model.ProbookVO;
import com.dev.probook.service.ProbookService;
import com.dev.review.book.Service.ProBookReviewService;
import com.dev.review.book.model.vo.ReviewVO;

@WebServlet("/bookdetailreview")
public class BookDetailReviewController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<ReviewVO> reviewList = new ProBookReviewService().reviewListcall();
		
		req.setAttribute("data", reviewList);

		req.getRequestDispatcher("./WEB-INF/views/Product_Books/u_book_detail_review_page.jsp").forward(req, resp);
	}

}
