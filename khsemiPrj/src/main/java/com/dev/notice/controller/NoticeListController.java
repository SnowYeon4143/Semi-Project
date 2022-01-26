package com.dev.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.notice.model.service.NoticeService;
import com.dev.notice.model.vo.NoticeVo;
import com.dev.paging.Paging;
import com.dev.qna.model.service.QnaService;
import com.dev.qna.model.vo.QnaVo;

@WebServlet("/notice")
public class NoticeListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("noticeList controller called...");
		//현재 페이지를 가져옴
		String curpage = req.getParameter("currentPage");
		
		//페이지를 선택하지 않고 들어왔을 경우 1페이지로
		if(curpage == null) {
			curpage = "1";
		}
		int curpage2 = Integer.parseInt(curpage);
		
		req.setAttribute("curpage", curpage2);
		
		//QnA 게시판에 있는 모든 글의 수
		int total = new NoticeService().totalNoticeCount();
		
		//한 페이지에 보일 글의 수, 하나의 페이징 바에 보일 페이징 버튼의 개수, 전체 글 수, 현재 페이지
		Paging page = new Paging(10, 5, total, curpage2);
		
		List<NoticeVo> noticeList = new NoticeService().noticeList(page);
		
		req.setAttribute("page", page);
		
		req.setAttribute("noticeList", noticeList);
		req.getRequestDispatcher("/WEB-INF/views/QnA/m_notice_list.jsp").forward(req, resp);
	}
}
