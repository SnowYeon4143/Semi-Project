package com.dev.review.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.review.book.Service.ProBookReviewService;
import com.dev.review.book.model.vo.ReviewVO;

@WebServlet("/bookdetailinsertreview")
public class BookDetailReviewInsertController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("servlet");
		req.setCharacterEncoding("utf-8");
		
		String rvtext = req.getParameter("reviewinsert");
		
		ReviewVO rv = new ReviewVO();
		rv.setBookReviewContext(rvtext);
		
		int result = new ProBookReviewService().reviewInsert(rv);
		
		System.out.println("servlet end");
		
		if (result > 0) 
		{
			System.out.println("ss");
			req.getRequestDispatcher("./WEB-INF/views/Product_Books/u_book_detail_review_page.jsp").forward(req, resp);
		}
		else 
		{	
			System.out.println("ff");
			req.getRequestDispatcher("./WEB-INF/views/Product_Books/u_book_detail_review_page.jsp").forward(req, resp);
		}
		
	}

}
