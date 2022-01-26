package com.dev.event.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dev.event.model.service.EventService;
import com.dev.event.model.vo.EventVo;
import com.dev.event.model.service.EventService;
import com.dev.event.model.vo.EventVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 50
)
@WebServlet("/eventupdate")
public class EventUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eventNo = Integer.parseInt(req.getParameter("eventNo"));
		System.out.println("수정전 eventNo : " + eventNo);
		String eventTitle = req.getParameter("eventTitle");
		System.out.println("수정전 eventNo : " + eventTitle);
		String eventContent = req.getParameter("eventContent");
		System.out.println("수정전 eventContent : " + eventContent);
		
		req.setAttribute("eventNo", eventNo);
		req.setAttribute("eventTitle", eventTitle);
		req.setAttribute("eventContent", eventContent);
		req.getRequestDispatcher("WEB-INF/views/QnA/a_event_update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("event업데이트의 dopost 문 안으로 들어옴");
		int eventNo = Integer.parseInt(req.getParameter("eventno"));
		System.out.println("이벤트 업데이트 컨트롤러에서 받은 eNo = "+eventNo);
		String title = req.getParameter("eventtitle");
		System.out.println(title);
		String content = req.getParameter("eventcontent");
		System.out.println(content);
		String sStartDate = req.getParameter("startdate") + " 00:00:00";
		Timestamp startDate = Timestamp.valueOf(sStartDate);
		System.out.println(startDate);
		String sEndDate = req.getParameter("enddate") + " 00:00:00";
		Timestamp endDate = Timestamp.valueOf(sEndDate);
		System.out.println(endDate);
		String eventImg = null;
		
		Part part = req.getPart("eventimg");
		System.out.println("파트 : " + part.getSubmittedFileName());
		if(part.getSubmittedFileName() != "") {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			//파일 저장 준비
			String changeName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			String realPath = req.getServletContext().getRealPath("Resources/img/Eventupload");
			String filePath = realPath + File.separator + changeName + ext;
			String fileEventName = changeName + ext;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			System.out.println("origin : " + originName);
			System.out.println("change : " + changeName);
			System.out.println("filePath : " + filePath);
			//파일 기록 (업로드 파일 read -> write)
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
			eventImg = fileEventName;
		}else {
			eventImg = "NoImage";
		}
		

		EventVo e = new EventVo();
		e.setEventNo(eventNo);
		e.setEventTitle(title);
		e.setEventContent(content);
		e.setEventStart(startDate);
		e.setEventEnd(endDate);
		e.setEventImgUrl(eventImg);
		System.out.println(e);

		int result = new EventService().eventUpdate(e);

		if (result > 0) {
			resp.sendRedirect("event");
		} else {
			req.getRequestDispatcher("WEB-INF/views/QnA/a_event_update.jsp").forward(req, resp);
		}
	}
}
