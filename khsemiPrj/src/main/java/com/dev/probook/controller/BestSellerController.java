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

@WebServlet("/bestseller")
public class BestSellerController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<ProbookVO> bestSellerList = new ProbookService().bestSellerlistcall();
				
		req.setAttribute("data", bestSellerList);
		req.getRequestDispatcher("./WEB-INF/views/Product_Books/u_bestseller_list.jsp").forward(req, resp);
	}
}
