package com.dev.progoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.progoods.model.ProgoodsService;

@WebServlet("/goods_delete")
public class GoodsDelete extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pro_no1 = req.getParameter("pro_no");
		System.out.println(pro_no1);
		
		int pro_no = 0;
		if(pro_no1 !=null) {
			pro_no = Integer.parseInt(pro_no1);
		}
		
		int delmd = new ProgoodsService().deleteMd(pro_no);
		int delpro = new ProgoodsService().deletePro(pro_no);
		
		String st = null;
		if(delmd !=0 && delpro !=0) {
			st = "상품이 삭제되었습니다.";
		}
		
		
		req.setAttribute("st", st);
		req.getRequestDispatcher("//WEB-INF/views/Product_Goods/a_product_goods_updste").forward(req, resp);
		
		
	}

}
