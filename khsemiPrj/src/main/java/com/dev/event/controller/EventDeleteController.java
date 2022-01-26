package com.dev.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.event.model.service.EventService;
import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/eventdelete")
public class EventDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eventNo = req.getParameter("eventNo");
		System.out.println("삭제시 eventNo : " + eventNo);
		
		int result = new EventService().eventDelete(Integer.parseInt(eventNo));
		
		req.setAttribute("result", result);
		resp.sendRedirect("event");
	}
}
