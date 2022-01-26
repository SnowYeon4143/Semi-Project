package com.dev.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.notice.model.service.NoticeService;
import com.dev.notice.model.vo.NoticeVo;
import com.dev.notice.model.service.NoticeService;
import com.dev.notice.model.vo.NoticeVo;

@WebServlet("/noticeupdate")
public class NoticeUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
		System.out.println("수정전 noticeNo : " + noticeNo);
		String noticeTitle = req.getParameter("noticeTitle");
		System.out.println("수정전 noticeNo : " + noticeTitle);
		String noticeContent = req.getParameter("noticeContent");
		System.out.println("수정전 noticeContent : " + noticeContent);
		
		req.setAttribute("noticeNo", noticeNo);
		req.setAttribute("noticeTitle", noticeTitle);
		req.setAttribute("noticeContent", noticeContent);
		req.getRequestDispatcher("WEB-INF/views/QnA/a_notice_update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("notice업데이트의 dopost 문 안으로 들어옴");
		int noticeNo = Integer.parseInt(req.getParameter("noticeno"));
		System.out.println(noticeNo);
		String title = req.getParameter("noticetitle");
		System.out.println(title);
		String content = req.getParameter("noticecontent");
		System.out.println(content);

		NoticeVo q = new NoticeVo();
		q.setNoticeNo(noticeNo);
		q.setNoticeTitle(title);
		q.setNoticeContent(content);

		int result = new NoticeService().noticeUpdate(q);

		if (result > 0) {
			resp.sendRedirect("notice");
		} else {
			req.getRequestDispatcher("WEB-INF/views/QnA/a_notice_update.jsp").forward(req, resp);
		}
	}
}
