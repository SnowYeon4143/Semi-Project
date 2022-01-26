package com.dev.order.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.JDBCTemplate;
import com.dev.order.service.CartService;
import com.dev.order.vo.CartVo;

@WebServlet("/cart")
public class Cart extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<CartVo> cartList = new CartService().selectCartList();
		
		//조회한 데이터를 JSP한테 넘겨줌		
		req.setAttribute("data", cartList);
		req.getRequestDispatcher("/WEB-INF/views/Order/u_cart.jsp").forward(req, resp);
	}
	
}
