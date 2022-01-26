package com.dev.progoods.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dev.progoods.model.ProgoodsService;
import com.dev.progoods.model.ProgoodsVo;

@MultipartConfig( 
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet("/gcon1")
public class Goodscontrol_1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_product_goods_insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String pro_name = req.getParameter("pro_name");
		int unit_price = Integer.parseInt(req.getParameter("unit_price"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		String category = req.getParameter("category");
		String maker = req.getParameter("maker");
		String country = req.getParameter("country");
		
		System.out.println(pro_name);
		System.out.println(unit_price);
		System.out.println(stock);
		System.out.println(category);
		System.out.println(maker);
		System.out.println(country);
		
		Part part = req.getPart("goodsimg");		
		String filePath = null;
		if(part != null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			String changeName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			
			String realPath = req.getServletContext().getRealPath("/Resources/img/Goodscover");
			filePath = realPath + File.separator + changeName + ext; 
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size =0;
			while((size = fis.read(buf))!= -1){
				fos.write(buf, 0, size);
			}
			fis.close();
			fos.close();
		}
		
		
		Part part2 = req.getPart("goodsinf");
		String filePath2 = null;
		if(part != null) {
			String originName = part.getSubmittedFileName();
			InputStream fis = part.getInputStream();
			
			String changeName = "" + UUID.randomUUID();
			String ext = originName.substring(originName.lastIndexOf("."), originName.length());
			
			String realPath = req.getServletContext().getRealPath("/Resources/img/Goodscover");
			filePath2 = realPath + File.separator + changeName + ext; 
			FileOutputStream fos = new FileOutputStream(filePath2);
			
			byte[] buf = new byte[1024];
			int size =0;
			while((size = fis.read(buf))!= -1){
				fos.write(buf, 0, size);
			}
			fis.close();
			fos.close();
		}
		
		System.out.println(filePath);
		System.out.println(filePath2);
		
		String filePath3 = "Resources/img/Goodscover/" + filePath.substring(filePath.lastIndexOf("\\")+1, filePath.length());
		String filePath4 = "Resources/img/Goodscover/" + filePath2.substring(filePath2.lastIndexOf("\\")+1, filePath2.length());
		
		ProgoodsVo g = new ProgoodsVo();
		g.setPro_name(pro_name);
		g.setCountry(country);
		g.setPro_img(filePath3);
		g.setDescription(filePath4);
		g.setMaker(maker);
		g.setMd_cate(category);
		g.setStock(stock);
		g.setUnit_price(unit_price);
		
		int result = new ProgoodsService().insert(g);
		
		req.getRequestDispatcher("/WEB-INF/views/Product_Goods/a_product_goods_insert.jsp").forward(req, resp);	
	}
	
}
