package com.dev.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaAnswersVo;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/answers")
public class QnaAnswersController extends HttpServlet{
	//답변작성 기능
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/QnA/m_qna_detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		String ansComent = req.getParameter("coment");
		
		QnaAnswersVo a = new QnaAnswersVo(qnaNo, ansComent);
		
		int result = new QnaService().writeQnaAnswers(a);
		
		if(result > 0) {
			resp.sendRedirect("qnadt?qnaNo=" + a.getQnaNo());
		}
	}
}
