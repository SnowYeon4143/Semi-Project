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

@WebServlet("/gcon2")
public class Goodscontrol_2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String search = req.getParameter("search");
		if(search == null || search.trim().equals("")){
			search = "0";
		}
		
		String curpage = req.getParameter("currentPage");
		if(curpage == null) {
			curpage = "1";
		}
		int curpage2 = Integer.parseInt(curpage);
		int total = new ProgoodsService().totalGoodsCountAll();
		Paging page = new Paging(5, 3, total, curpage2);
		
		
		List<ProgoodsVo> goodsList = new ProgoodsService().goodsAll(page);
		req.setAttribute("search", search);
		req.setAttribute("curpage", curpage2);
		req.setAttribute("page", page);
		req.setAttribute("goodsList", goodsList);
		req.setAttribute("total", total);
		req.setAttribute("desc", "none");
		req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_product_goods_update.jsp").forward(req, resp);
		
	}
}
