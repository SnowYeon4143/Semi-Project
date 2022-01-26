package com.dev.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.member.model.dao.MemberDao;
import com.dev.member.model.service.MemberService;
import com.dev.member.model.vo.MemberVo;

@WebServlet("/changeInfo.do")
public class MemberInfoChangeController extends HttpServlet{

	// 아이디를 호출하여 vo 객체에 저장하여 정보 변경 페이지로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = dao.getUser(userId);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/Member/u_change_memberInfo.jsp").forward(req, resp);
	}
	
	// 정보 변경 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberVo vo = new MemberVo();
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		String userPhone = req.getParameter("userPhone");
		String addr = req.getParameter("addr");
		String addrDetail = req.getParameter("addrDetail");
		String yy = req.getParameter("yy");
		String mm = req.getParameter("mm");
		String dd = req.getParameter("dd");

		MemberDao dao = MemberDao.getInstance();

		vo.setUserId(userId);
		vo.setUserPwd(userPwd);
		vo.setUserName(userName);
		vo.setUserEmail(userEmail);
		vo.setUserPhone(userPhone);
		vo.setAddr(addr);
		vo.setAddrDetail(addrDetail);
		vo.setYy(yy);
		vo.setMm(mm);
		vo.setDd(dd);

		dao.updateMember(vo);
		
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().print("<script>alert('정보 변경이 완료되었습니다.');</script>");
		resp.getWriter().print("<script>location.href='home';</script>");
	}
}
