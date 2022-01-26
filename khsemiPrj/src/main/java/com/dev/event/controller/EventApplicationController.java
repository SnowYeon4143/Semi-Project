package com.dev.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.event.model.vo.EventApplicationVo;
import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaAnswersVo;

@WebServlet("/application")
public class EventApplicationController extends HttpServlet{
	//답변작성 기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/QnA/m_event_detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eventNo = Integer.parseInt(req.getParameter("eventno"));
		int memberNo = Integer.parseInt(req.getParameter("memberno"));
		String appId = req.getParameter("appid");
		String appEmail = req.getParameter("appemail");

		EventApplicationVo ea = new EventApplicationVo();
		ea.seteNo(eventNo);
		ea.setmNo(memberNo);
		ea.setEaId(appId);
		ea.setEaEmail(appEmail);
		
		System.out.println("ea객체 : " + ea);
		
		int result = new QnaService().writeEventApplication(ea);

		if (result > 0) {
			resp.sendRedirect("eventdt?eventNo=" + ea.geteNo());
		}
	}
}
