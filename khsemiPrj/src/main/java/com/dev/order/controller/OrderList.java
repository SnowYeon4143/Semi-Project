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
import com.dev.order.service.OrderListService;
import com.dev.order.vo.OrderListVo;

@WebServlet("/orderlist")
public class OrderList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<OrderListVo> orderlistList = new OrderListService().selectOrderList();
		
		//조회한 데이터를 JSP한테 넘겨줌		
		req.setAttribute("data", orderlistList);
		req.getRequestDispatcher("/WEB-INF/views/Order/u_order_list.jsp").forward(req, resp);
	}

}
