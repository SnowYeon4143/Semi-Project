package com.dev.recommend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.paging.Paging;
import com.dev.probook.model.ProbookVO;
import com.dev.review.goods.controller.MdReviewService;
import com.dev.review.goods.modelVo.MdReviewVo;

@WebServlet("/mdRecommend")
public class MdRecommendController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String curpage = req.getParameter("currentPage");		
		if(curpage == null) {
			curpage = "1";
		}
		int curpage2 = Integer.parseInt(curpage);
		
			
		String search =req.getParameter("search");
		if(search == null) {
			
			int total = new MdRecommendService().totalCount();
			Paging page = new Paging(5, 3, total, curpage2);
			List<ProbookVO> bookList = new MdRecommendService().bookList();
			req.setAttribute("bookList", bookList);
			req.setAttribute("search", search);
			req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_md_recommend.jsp").forward(req, resp);
			
		}else{
			
			int total = new MdRecommendService().totalsearchCount(search);
			Paging page = new Paging(5, 3, total, curpage2);
			List<ProbookVO> bookList = new MdRecommendService().booksearchList(search);
			req.setAttribute("bookList", bookList);
			req.setAttribute("search", search);
			req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_md_recommend.jsp").forward(req, resp);
			
		}
		
		
		
		
		
		
		
		
	}

}
