package com.dev.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.event.model.service.EventService;
import com.dev.event.model.vo.EventVo;

@WebServlet("/eventdt")
public class EventDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eventNo = req.getParameter("eventNo");
		System.out.println(eventNo);
		
		EventVo e = new EventService().eventSelect(Integer.parseInt(eventNo));
		
		req.setAttribute("e", e);
		
		req.getRequestDispatcher("WEB-INF/views/QnA/m_event_detail.jsp").forward(req, resp);
	}
}
