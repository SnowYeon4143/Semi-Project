package com.dev.review.goods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.paging.Paging;
import com.dev.review.goods.modelVo.MdReviewVo;

@WebServlet ("/mrReport")
public class MRreportController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
//		String curpage = req.getParameter("currentPage");		
//		if(curpage == null) {
//			curpage = "1";
//		}
//		int curpage2 = Integer.parseInt(curpage);
//		int total = new MdReviewService().totalMdReviewCount(pro_no);
//		Paging page = new Paging(3, 3, total, curpage2);
//		System.out.println("startNo : "+page.startNo());
		
		
		List<MdReviewVo> mdReportList = new MdReviewService().mdReportList();
		req.setAttribute("mdReportList", mdReportList);
		System.out.println(mdReportList);
//		req.setAttribute("curpage", curpage2);
//		req.setAttribute("page", page);
//		req.setAttribute("pro_no", pro_no);		
	
		
		req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_goods_review_report.jsp").forward(req, resp);
	}
}
