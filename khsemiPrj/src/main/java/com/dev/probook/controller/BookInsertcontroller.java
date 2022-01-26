package com.dev.probook.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dev.probook.model.ProbookVO;
import com.dev.probook.service.ProbookService;

@MultipartConfig
(
	maxFileSize = 1024 * 1024 * 50,
	maxRequestSize = 1024 * 1024 * 50 * 5
)

@WebServlet("/bookinsert")
public class BookInsertcontroller extends HttpServlet
{	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("./WEB-INF/views/Product_Books/a_book_insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("utf-8");
		
		String productName = req.getParameter("pro_name");
		String unitPrice = req.getParameter("unit_price");
		String stock = req.getParameter("stock");
		String writer = req.getParameter("writer");
		String publisher = req.getParameter("book_pub");
		String publicDate = req.getParameter("publ_date");
		String category = req.getParameter("category");
		String descipt = req.getParameter("descript");
		String bookindex = req.getParameter("bookindex");

		ProbookVO pro = new ProbookVO();
		
		pro.setProductName(productName);

		pro.setProductPrice(unitPrice);
		pro.setProductStock(stock);
		pro.setWriterName(writer);
		pro.setPublisher(publisher);
		pro.setEnrollDate(publicDate);
		pro.setCategoty(category);
		pro.setProductDescript(descipt);
		pro.setContentList(bookindex);
		
		Part file = req.getPart("upload");

		String originName = file.getSubmittedFileName();

		InputStream fis = file.getInputStream();
		
		String realPath = req.getServletContext().getRealPath("./Resources/img/Bookcover");
		
		String filePath = realPath + File.separator + originName;
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fis.read(buf)) != -1) 
		{
			fos.write(buf, 0, size);
		}
		
		fis.close();
		fos.close();
		
		String imgPath1 = filePath.substring(filePath.lastIndexOf("WebContent")+10);
		String imgPath2 = imgPath1.replace("\\", "/");
		String imgPath3 = imgPath2.replace("/Resources", "./Resources");
		
		pro.setImageLink(imgPath3);
		
		int result = new ProbookService().bookinsert(pro);
		
		if (result > 0) 
		{
			req.getRequestDispatcher("./WEB-INF/views/Product_Books/a_book_insert.jsp").forward(req, resp);
		}
		else 
		{	
			req.getRequestDispatcher("./WEB-INF/views/Product_Books/a_book_insert.jsp").forward(req, resp);
		}
		
	}
	
}
