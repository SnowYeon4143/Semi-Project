package com.dev.recommend.model.dao;

import static com.dev.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.probook.model.ProbookVO;
import com.dev.progoods.model.ProgoodsVo;

public class MdRecommendDao {

	public int totalCount(Connection conn) {
		String sql ="SELECT count(*) FROM BOOK_INF";
		
		PreparedStatement pstmt = null;
		int total =0;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		    rs.next();
		    
		    total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return total;
	} //method1

	public List<ProbookVO> bookList(Connection conn) {
		
		String sql = "SELECT * FROM PRO_INF P JOIN BOOK_INF B ON P.PRO_NO = B.PRO_NO";
		
		PreparedStatement pstmt = null;
		ProbookVO b = null;
		List<ProbookVO> bookListAll = new ArrayList<ProbookVO>();
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String productNumber = rs.getString(1);
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String productStock = rs.getString("STOCK");
				String enrollDate = rs.getString("PUBL_DATE");
				String bookNumber = rs.getString("BOOK_NO");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
				String publisher = rs.getString("BOOK_PUB");
				String categoty = rs.getString("CATEGORY");

					
				b = new ProbookVO();
				b.setProductNumber(productNumber);
				b.setProductName(productName);
				b.setImageLink(imageLink);
				b.setProductPrice(productPrice);
				b.setProductStock(productStock);
				b.setEnrollDate(enrollDate);
				b.setBookNumber(bookNumber);
				b.setProductDescript(productDescript);
				b.setWriterName(writerName);
				b.setPublisher(publisher);
				b.setCategoty(categoty);
				
				bookListAll.add(b);
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}		
		return bookListAll;
	}

	public int totalsearchCount(Connection conn, String search) {
		
		String sql ="SELECT count(*) FROM PRO_INF P JOIN BOOK_INF B ON P.PRO_NO = B.PRO_NO WHERE P.PRO_NAME LIKE ? ";
		
		
		PreparedStatement pstmt = null;
		int total =0;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			
			rs = pstmt.executeQuery();
		    rs.next();
		    
		    total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return total;
		
		
		
		
	}

	public List<ProbookVO> booksearchList(Connection conn, String search) {
		
		String sql = "SELECT * FROM PRO_INF P JOIN BOOK_INF B ON P.PRO_NO = B.PRO_NO WHERE P.PRO_NAME LIKE ?";
		
		PreparedStatement pstmt = null;
		ProbookVO b = null;
		List<ProbookVO> bookListAll = new ArrayList<ProbookVO>();
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String productNumber = rs.getString(1);
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String productStock = rs.getString("STOCK");
				String enrollDate = rs.getString("PUBL_DATE");
				String bookNumber = rs.getString("BOOK_NO");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
				String publisher = rs.getString("BOOK_PUB");
				String categoty = rs.getString("CATEGORY");

					
				b = new ProbookVO();
				b.setProductNumber(productNumber);
				b.setProductName(productName);
				b.setImageLink(imageLink);
				b.setProductPrice(productPrice);
				b.setProductStock(productStock);
				b.setEnrollDate(enrollDate);
				b.setBookNumber(bookNumber);
				b.setProductDescript(productDescript);
				b.setWriterName(writerName);
				b.setPublisher(publisher);
				b.setCategoty(categoty);
				
				bookListAll.add(b);
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}		
		return bookListAll;
		
		
	}
		}//class
