package com.dev.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.qna.model.service.QnaService;

@WebServlet("/qnalike")
public class QnaLikeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("에이잭스로 qnalike 도착");
		int qnaNo = Integer.parseInt(req.getParameter("qnaNo"));
		System.out.println("에이잭스의 qnaNo : " + qnaNo);
		
		//좋아요 증가
		int result = new QnaService().qnaLikePlus(qnaNo);
		System.out.println("좋아요 추가 1이면 성공 0이면 에러 : " + result);
		//좋아요 조회
		int like = new QnaService().qnaLikeSelect(qnaNo);
		System.out.println("게시글의 좋아요 수 : " + like);
		
		//응답을 보내줄 수 있음
		resp.setContentType("text/hrml; charset=UTF-8");
		
		if(result > 0) {
			resp.getWriter().print(like);
		}else {
			resp.getWriter().print("에러");
		}
		
	}
}
