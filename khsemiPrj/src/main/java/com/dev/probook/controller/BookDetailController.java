package com.dev.probook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.probook.model.ProbookVO;
import com.dev.probook.service.ProbookService;

@WebServlet("/bookdetail")
public class BookDetailController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("BookDetailController active");
		
		String type = req.getParameter("searchtype");
		String value = req.getParameter("searchvalue");
		
		List<ProbookVO> bookdetailList = new ProbookService().bookdetailListcall(type, value);
		
		req.setAttribute("data", bookdetailList);
		
		req.getRequestDispatcher("/WEB-INF/views/Product_Books/u_book_detail.jsp").forward(req, resp);
	}
}
