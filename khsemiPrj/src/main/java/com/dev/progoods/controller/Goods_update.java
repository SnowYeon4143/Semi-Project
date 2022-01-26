package com.dev.progoods.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dev.progoods.model.ProgoodsService;

@MultipartConfig( 
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet("/goods_update")
public class Goods_update extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String search = req.getParameter("search");
		if(search == null || search.trim().equals("")){
			search = "0";
		}
		String curPage1 = req.getParameter("currentPage");
		
		int curPage=0;
		if(curPage1 !=null) {
			curPage = Integer.parseInt(curPage1);
		}
		
		
		String pro_no1 = req.getParameter("pro_no");
		System.out.println("pro_no : "+ pro_no1);
		int pro_no = 0;
		if(pro_no1 == null) {
			req.setAttribute("search", search);
			req.setAttribute("currentPage", curPage);
			req.getRequestDispatcher("/gcon2").forward(req, resp);
	
		
			
		}else if(pro_no1 !=null) {
		 pro_no = Integer.parseInt(req.getParameter("pro_no"));
		
		
		String pro_name = req.getParameter("pro_name");
	
		String unit_price1 = req.getParameter("unit_price");
		int unit_price =0;
		if(unit_price1 !=null) {
		unit_price = Integer.parseInt(req.getParameter("unit_price"));
		}
		
		String stock1= req.getParameter("stock");
		int stock = 0;
		if(stock1 !=null) {
		stock = Integer.parseInt(req.getParameter("stock"));
		}
		
		
		String category = req.getParameter("category");
		String maker = req.getParameter("maker");
		String country = req.getParameter("country");
		
		
//		Part part = req.getPart("goodsimg");		
//		String filePath = null;
//		if(part != null) {
//			String originName = part.getSubmittedFileName();
//			InputStream fis = part.getInputStream();
//			
//			String changeName = "" + UUID.randomUUID();
//			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
//			
//			String realPath = req.getServletContext().getRealPath("/Resources/img/Goodscover");
//			filePath = realPath + File.separator + changeName + ext; 
//			FileOutputStream fos = new FileOutputStream(filePath);
//			
//			byte[] buf = new byte[1024];
//			int size =0;
//			while((size = fis.read(buf))!= -1){
//				fos.write(buf, 0, size);
//			}
//			fis.close();
//			fos.close();
//		}
//		
//		
//		Part part2 = req.getPart("goodsinf");
//		String filePath2 = null;
//		if(part != null) {
//			String originName = part.getSubmittedFileName();
//			InputStream fis = part.getInputStream();
//			
//			String changeName = "" + UUID.randomUUID();
//			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
//			
//			String realPath = req.getServletContext().getRealPath("/Resources/img/Goodscover");
//			filePath2 = realPath + File.separator + changeName + ext; 
//			FileOutputStream fos = new FileOutputStream(filePath2);
//			
//			byte[] buf = new byte[1024];
//			int size =0;
//			while((size = fis.read(buf))!= -1){
//				fos.write(buf, 0, size);
//			}
//			fis.close();
//			fos.close();
//		}
		
		
		String num1 = "_"; //pro_name
		String num2 = "_"; //img
		String num3 = "_"; //unit_price
		String num4 = "_"; //stock
		String num5 = "_"; //inf
		String num6 = "_"; //category
		String num7 = "_"; //maker
		String num8 = "_"; //country
		
		
		if(pro_name != null) {
			int updatePname = new ProgoodsService().updateProName(pro_no, pro_name);
			if(updatePname != 0 ) {
				num1 = "상품 이름 ";
			}
		}
		
		if(unit_price1 != null) {
			int updatePprice = new ProgoodsService().updateUnitPrice(pro_no, unit_price);
			if(updatePprice != 0 ) {
				num3 = "단가 ";
			}
		}
		
		if(stock1 != null) {
			int updateStock = new ProgoodsService().updateStock(pro_no, stock);
			if(updateStock != 0 ) {
				num4 = "재고 ";
			}
		}
		if(category != null) {
			int updateCategory = new ProgoodsService().updatemdCate(pro_no, category);
			if(updateCategory != 0 ) {
				num6 = "카테고리 ";
			}
		}
		if(maker != null) {
			int updateMaker = new ProgoodsService().updateMaker(pro_no, maker);
			if(updateMaker != 0 ) {
				num7 = "제조사 ";
			}
		}
		if(country != null) {
			int updateCountry = new ProgoodsService().updateCountry(pro_no, country);
			if(updateCountry != 0 ) {
				num8 = "원산지 ";
			}
		}
//			else if(filePath != null) {
//			int updateImg = new ProgoodsService().updateProImg(pro_no, filePath);
//			if(updateImg != 0 ) {
//				num2 = "이미지 ";
//			}
//		}else if(filePath2 != null) {
//			int updateInf = new ProgoodsService().updateProInf(pro_no, filePath2);
//				if(updateInf != 0 ) {
//					num8 = "상품설명 ";
//				}
//		}
		
//		String updateResult = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 +"(이)가 수정되었습니다.";
//		req.setAttribute("updateResult", updateResult);
//		req.setAttribute("search", search);
//		req.setAttribute("currentPage", curPage);
		resp.sendRedirect("/devbooks/gcon2");
//		req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_product_goods_update.jsp").forward(req, resp);
		
//		resp.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		out.println("<script>alert('${updateResult}');</script>");
//		out.flush();
//		
		}//pro_no 가 null이 아닐때
		
		
	}
}
