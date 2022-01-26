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

@WebServlet("/bookupdate")
public class BookUpdateController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String type = req.getParameter("searchtype");
		String value = req.getParameter("searchvalue");
		String currentPage = req.getParameter("currentPage");
		
		if(currentPage == null)
		{
			currentPage = "1";
		}

		int maxPage = 10;
		req.setAttribute("maxPage", maxPage);
		
		int startPage = Integer.parseInt(currentPage) - 2;
		int endPage = startPage + 5;
		if (startPage <= 0)
		{
			startPage = 1;
		}
		
		req.setAttribute("startPage", startPage);
		req.setAttribute("endpage", endPage);
		
		List<ProbookVO> ProductList = new ProbookService().productslistcall(type, value, currentPage);
		
		req.setAttribute("data", ProductList);
		
		req.getRequestDispatcher("./WEB-INF/views/Product_Books/a_book_update.jsp").forward(req, resp);
	}
}