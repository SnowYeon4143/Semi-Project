package com.dev.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.qna.model.service.QnaService;

@WebServlet("/answersdelete")
public class QnaAnswersDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		
		System.out.println("삭제할 답변이 있는 qnaNo : " + qnaNo);

		int result = new QnaService().qnaAnswersDelete(qnaNo);

		req.setAttribute("result", result);
		resp.sendRedirect("qnadt?qnaNo=" + qnaNo);
	}
}
