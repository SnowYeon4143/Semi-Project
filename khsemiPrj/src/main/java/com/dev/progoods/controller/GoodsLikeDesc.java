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

@WebServlet("/gca_likedesc")
public class GoodsLikeDesc extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String desc = req.getParameter("desc");
		String curpage = req.getParameter("currentPage");
//		String category = req.getParameter("category");
		String category = "생활용품";
		
		String likedesc = req.getParameter("likedesc");
		String salesdesc = req.getParameter("salesdesc");
		
		if(curpage == null) {
			curpage = "1";
		}
		int curpage2 = Integer.parseInt(curpage);
		int total = new ProgoodsService().totalGoodsCount(category);
		Paging page = new Paging(6, 3, total, curpage2);
		
			List<ProgoodsVo> goodsList = new ProgoodsService().likedesc(page, category);
			req.setAttribute("curpage", curpage2);
			req.setAttribute("page", page);
			req.setAttribute("goodsList", goodsList);
			req.setAttribute("total", total);
			req.setAttribute("desc", "likedesc");
			req.getRequestDispatcher("/WEB-INF/views/Product_Goods/u_category_goods_list.jsp").forward(req, resp);	
					
		
	}

}
