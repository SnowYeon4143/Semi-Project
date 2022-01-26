 package com.dev.member.find.controller;

import static com.dev.common.JDBCTemplate.close;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.JDBCTemplate;
import com.dev.member.model.dao.MemberDao;
import com.dev.member.model.service.MemberService;
import com.dev.member.model.vo.MemberVo;

@WebServlet("/pwdsearch")
public class MemberFindPwdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/Member/u_find_pwd.jsp").forward(req, resp);
	}
	
	// 아이디 찾기 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		
		MemberVo m = new MemberVo();
		m.setUserId(userId);
		m.setUserName(userName);
		
		System.out.println("아이디 : " + userId);
		System.out.println("이름 : " + userName);

		
		String userPwd = new MemberService().searchPwd(userId, userName);
		
		if(userPwd != null) {
			// success
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("<script>");
			resp.getWriter().print("alert('회원님의 비밀번호는 ");
			resp.getWriter().print(userPwd);
			resp.getWriter().print(" 입니다. \\n로그인 화면으로 이동합니다.');");
			resp.getWriter().print("</script>");
			resp.getWriter().print("<script>location.href='login';</script>");
						
		} else {
			// error
			resp.setContentType("text/html; charset=UTF-8");
			resp.getWriter().print("<script>alert('조회되는 정보가 없습니다.\\n비밀번호 조회 페이지로 다시 이동합니다.');</script>");
			resp.getWriter().print("<script>location.href='pwdsearch';</script>");
		}
	}
}
