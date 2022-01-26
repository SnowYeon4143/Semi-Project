package com.dev.review.goods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.member.model.vo.MemberVo;
import com.dev.paging.Paging;
import com.dev.review.goods.modelVo.MdReviewVo;


@WebServlet("/mdreview")
public class MRinsert extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		String pro_no1 = req.getParameter("pro_no");
		int pro_no=0;
		if(pro_no1!=null) {
			pro_no = Integer.parseInt(pro_no1);
		}
		String mr_cont = req.getParameter("mr_cont");
				
		System.out.println("컨트롤러 pro_no1 :"+pro_no);
		System.out.println("컨트롤러 mr_cont :"+mr_cont);

		
		//=====================등록=======================

//		
//		HttpSession session = req.getSession();
//		MemberVo loginUser = (MemberVo)(session.getAttribute("loginUser"));
//		
//		if(loginUser == null) {
//			resp.setContentType("text/html; charset=UTF-8");
//			resp.getWriter().print("<script>alert('로그인 후 등록하세요');</script>");
//			resp.getWriter().print("<script>location.href='login';</script>");
//		}else {
//			int m_no = loginUser.getMemberNo();
			int m_no = 3;
			boolean result = new MdReviewService().insertR(m_no, pro_no, mr_cont);
			
			req.setAttribute("pro_no", pro_no);
			resp.sendRedirect("/devbooks/gd?pro_no=" + pro_no);
	//		req.getRequestDispatcher("/gd").forward(req, resp);
			
	//	}//if
		
		
		
	}

}
