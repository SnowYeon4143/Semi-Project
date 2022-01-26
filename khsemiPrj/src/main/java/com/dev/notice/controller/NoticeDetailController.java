package com.dev.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.notice.model.service.NoticeService;
import com.dev.notice.model.vo.NoticeVo;
import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaAnswersVo;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/noticedt")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		System.out.println(noticeNo);
		
		NoticeVo n = new NoticeService().noticeSelect(Integer.parseInt(noticeNo));
		
		req.setAttribute("n", n);
		
		req.getRequestDispatcher("WEB-INF/views/QnA/m_notice_detail.jsp").forward(req, resp);
	}
}
