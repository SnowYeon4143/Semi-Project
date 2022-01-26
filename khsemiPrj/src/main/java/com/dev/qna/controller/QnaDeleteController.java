package com.dev.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/qnadelete")
public class QnaDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaNo = req.getParameter("qnaNo");
		System.out.println("삭제시 qnaNo : " + qnaNo);
		
		int result = new QnaService().qnaDelete(Integer.parseInt(qnaNo));
		
		req.setAttribute("result", result);
		resp.sendRedirect("qna");
	}
}
