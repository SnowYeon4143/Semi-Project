package com.dev.probook.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.JDBCTemplate;
import com.dev.probook.model.ProbookVO;
import com.dev.probook.service.ProbookService;

@WebServlet("/programinglang")
public class Category_ProgramingLang extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//검색 변수, 검색 타입과 검색 값
		String type = req.getParameter("searchtype");
		String value = req.getParameter("searchvalue");
		
		//페이징 변수, 현재 페이지 번호
		String currentPage = req.getParameter("currentPage");
		
		//오류 방지용 방어코드, 없으면 500 에러 발생 위험 있음.
		if(currentPage == null)
		{
			currentPage = "1";
		}

		int maxPage = 5;
		req.setAttribute("maxPage", maxPage);
		
		int startPage = Integer.parseInt(currentPage) - 2;
		int endPage = startPage + 5;
		if (startPage <= 0)
		{
			startPage = 1;
		}
		
		req.setAttribute("startPage", startPage);
		req.setAttribute("endpage", endPage);
		
		List<ProbookVO> newProductList = new ProbookService().programinglangListcall(type, value, currentPage);
		
		req.setAttribute("data", newProductList);
		req.getRequestDispatcher("./WEB-INF/views/Product_Books/u_category_ProgramingLang.jsp").forward(req, resp);
	}
	
}




























