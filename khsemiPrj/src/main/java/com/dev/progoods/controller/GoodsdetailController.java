package com.dev.progoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.paging.Paging;
import com.dev.progoods.model.ProgoodsService;
import com.dev.progoods.model.ProgoodsVo;
import com.dev.review.goods.controller.MdReviewService;
import com.dev.review.goods.modelVo.MdReviewVo;

@WebServlet("/gd")
public class GoodsdetailController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String pro_no1 = req.getParameter("pro_no");
		System.out.println("pro_no1 : "+pro_no1);
		int pro_no =0 ;
		if(pro_no1 != null) {
			pro_no = Integer.parseInt(pro_no1);
		}
		
		ProgoodsVo gvo = new ProgoodsService().mdDetail(pro_no);
		req.setAttribute("gvo", gvo);
		
      //=======================리뷰 조회 ================================
		
		String curpage = req.getParameter("currentPage");		
		if(curpage == null) {
			curpage = "1";
		}
		int curpage2 = Integer.parseInt(curpage);
		int total = new MdReviewService().totalMdReviewCount(pro_no);
		Paging page = new Paging(3, 3, total, curpage2);
		System.out.println("startNo : "+page.startNo());
		
		
		List<MdReviewVo> mdReviewList = new MdReviewService().mdReviewList(page, pro_no);
		req.setAttribute("curpage", curpage2);
		req.setAttribute("page", page);
		req.setAttribute("mdReviewList", mdReviewList);
		req.setAttribute("pro_no", pro_no);		
		req.getRequestDispatcher("/WEB-INF/views/Product_Goods/u_goods_detail.jsp").forward(req, resp);
	
	}
}
