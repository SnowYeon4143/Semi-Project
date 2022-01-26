package com.dev.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.notice.model.service.NoticeService;
import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/noticedelete")
public class NoticeDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		System.out.println("삭제시 noticeNo : " + noticeNo);
		
		int result = new NoticeService().noticeDelete(Integer.parseInt(noticeNo));
		
		req.setAttribute("result", result);
		resp.sendRedirect("notice");
	}
}
