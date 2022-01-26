package com.dev.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.notice.model.vo.NoticeVo;
import com.dev.qna.model.service.QnaService;

@WebServlet("/noticewrite")
public class NoticeWriteController extends HttpServlet{
	//공지사항 작성 페이지로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/QnA/a_notice_write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("noticetitle");
		String content = req.getParameter("noticecontent");
		
		// 세션 처리 되면 사용할 생성자
		NoticeVo n = new NoticeVo(title, content);

		int result = new QnaService().writeNotice(n);

		if (result > 0) {
			resp.sendRedirect("notice");
		} else {
			req.getRequestDispatcher("WEB-INF/views/QnA/a_notice_write.jsp").forward(req, resp);
		}
	}
}
