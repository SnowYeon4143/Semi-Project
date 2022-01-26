package com.dev.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.member.model.service.MemberService;
import com.dev.member.model.vo.MemberVo;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/Member/u_login.jsp").forward(req, resp);
	}
	
	// 로그인 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		MemberVo m = new MemberVo();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		MemberVo loginUser = new MemberService().login(m);
		
		if(loginUser != null) {
			// success
			req.getSession().setAttribute("loginUser", loginUser);
			if(loginUser.getUserId().equals("admin")) {
				resp.setContentType("text/html; charset=UTF-8");
				resp.getWriter().print("<script>alert('관리자 로그인 완료');</script>");
				resp.getWriter().print("<script>location.href='adminHome';</script>");
			} else {
				resp.setContentType("text/html; charset=UTF-8");
				resp.getWriter().print("<script>alert('로그인 완료');</script>");
				resp.getWriter().print("<script>location.href='home';</script>");
			}
			
		} else {
			// error
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("<script>alert('로그인 실패, 정보가 일치하지 않습니다.');</script>");
			resp.getWriter().print("<script>location.href='login';</script>");
		}
	}

}
