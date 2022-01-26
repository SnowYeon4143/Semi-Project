package com.dev.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/qnaupdate")
public class QnaUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		System.out.println("수정전 qnaNo : " + qnaNo);
		String qnaTitle = req.getParameter("qnaTitle");
		System.out.println("수정전 qnaNo : " + qnaTitle);
		String qnaContent = req.getParameter("qnaContent");
		System.out.println("수정전 qnaContent : " + qnaContent);
		
		req.setAttribute("qnaNo", qnaNo);
		req.setAttribute("qnaTitle", qnaTitle);
		req.setAttribute("qnaContent", qnaContent);
		req.getRequestDispatcher("WEB-INF/views/QnA/u_qna_update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("qna업데이트의 dopost 문 안으로 들어옴");
		int qnaNo = Integer.parseInt(req.getParameter("qnano"));
		System.out.println(qnaNo);
		String title = req.getParameter("qnatitle");
		System.out.println(title);
		String content = req.getParameter("qnacontent");
		System.out.println(content);

		QnaVo q = new QnaVo();
		q.setQnaNo(qnaNo);
		q.setQnaTitle(title);
		q.setQnaContent(content);

		int result = new QnaService().qnaUpdate(q);

		if (result > 0) {
			resp.sendRedirect("qna");
		} else {
			req.getRequestDispatcher("WEB-INF/views/QnA/u_qna_update.jsp").forward(req, resp);
		}
	}
}
