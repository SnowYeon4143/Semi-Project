package com.dev.probook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.JDBCTemplate;

public class ProbookDAO 
{
	public List<ProbookVO> newproductslistcall(Connection conn, int startNum, int lastNum)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProbookVO pvo = null;
		List<ProbookVO> newProductList = new ArrayList<ProbookVO>();
		
		String sql = "SELECT * FROM ( SELECT ROWNUM as RNUM, P.PRO_NO, P.PRO_NAME, P.PRO_IMG, P.UNIT_PRICE, P.SALES, P.DESCRIPTION, B.BOOK_AUTH, B.PUBL_DATE, B.CATEGORY FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) WHERE ROWNUM <= 30 ) WHERE RNUM BETWEEN ? AND ?";
	
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, lastNum);
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productNumber = rs.getString("PRO_NO");
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String enrollDate = rs.getString("PUBL_DATE");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
					
				pvo = new ProbookVO();
				pvo.setProductNumber(productNumber);
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				newProductList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return newProductList;
	}

	public List<ProbookVO> newproductslistcallsearch(Connection conn, String type, String value) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) WHERE P.%s LIKE ?";
		sql = String.format(sql, type);
		System.out.println("SQL ::: " + sql);
		
		List<ProbookVO> searchresultList = new ArrayList<ProbookVO>();
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + value + "%");
			
			ProbookVO pvo = null;
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productNumber = rs.getString("PRO_NO");
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String enrollDate = rs.getString("PUBL_DATE");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
				
				pvo = new ProbookVO();	
				pvo.setProductNumber(productNumber);
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				searchresultList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return searchresultList;
	}

	public int countAllProductMethod(Connection conn) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "SELECT COUNT(P.PRO_NO) FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO)";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				result = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return result;
	}
		
	public int insertBookProduct(Connection conn, ProbookVO pro) 
	{
		String sql = "INSERT ALL INTO PRO_INF VALUES (SEQ_PRO_INF.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, '도서')"
				+ 				"INTO BOOK_INF VALUES (SEQ_BOOK_INF.NEXTVAL, SEQ_PRO_INF.NEXTVAL, ?, ?, ?, ?, ?)"
				+ 				"SELECT *"
				+ 				"FROM DUAL";

		PreparedStatement pstmt = null;
		int result = 0;
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro.getProductName());
			
			pstmt.setString(2, pro.getImageLink());
			
			pstmt.setString(3, pro.getProductPrice());
			pstmt.setString(4, pro.getProductStock());
			pstmt.setString(5, pro.getProductSaleCount());
			pstmt.setString(6, pro.getProductLikeCount());
			pstmt.setString(7, pro.getProductDescript());
			
			pstmt.setString(8, pro.getWriterName());
			pstmt.setString(9, pro.getPublisher());
			
			pstmt.setString(10, pro.getEnrollDate());
			
			pstmt.setString(11, pro.getCategoty());
			pstmt.setString(12, pro.getContentList());

			result = pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<ProbookVO> productlistcall(Connection conn, int startNum, int lastNum) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProbookVO pvo = null;
		List<ProbookVO> newProductList = new ArrayList<ProbookVO>();
		
		String sql = "SELECT * FROM ( SELECT ROWNUM as RNUM, P.PRO_NO, P.PRO_NAME, P.PRO_IMG, P.UNIT_PRICE, P.STOCK, P.SALES, P.PRO_LIKE, P.DESCRIPTION, P.PRO_TYPE, B.BOOK_NO, B.BOOK_AUTH, B.BOOK_PUB, B.PUBL_DATE, B.CATEGORY, B.CONT_LIST FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) ) WHERE RNUM BETWEEN ? AND ?";
	
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, lastNum);
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productNumber = rs.getString("PRO_NO");
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String productStock = rs.getString("STOCK");
				String productSales = rs.getString("SALES");
				String productlike = rs.getString("PRO_LIKE");
				String productDescript = rs.getString("DESCRIPTION");
				String productType = rs.getString("PRO_TYPE");
				
				String bookNumber = rs.getString("BOOK_NO");
				String writerName = rs.getString("BOOK_AUTH");
				
				String publisher = rs.getString("BOOK_PUB");
				
				String enrollDate = rs.getString("PUBL_DATE");
				String category = rs.getString("CATEGORY");
				String contentList = rs.getString("CONT_LIST");
					
				pvo = new ProbookVO();
				pvo.setProductNumber(productNumber);
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setProductStock(productStock);
				pvo.setProductSaleCount(productSales);
				pvo.setProductLikeCount(productlike);
				pvo.setProductType(productType);
				
				pvo.setBookNumber(bookNumber);
				pvo.setCategoty(category);
				pvo.setContentList(contentList);
				pvo.setPublisher(publisher);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				newProductList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return newProductList;
	}

	public List<ProbookVO> productlistcallsearchcall(Connection conn, String type, String value) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * "
				+ "FROM ("
				+ "SELECT ROWNUM as RNUM, P.PRO_NO, P.PRO_NAME, P.PRO_IMG, P.UNIT_PRICE, P.STOCK, P.SALES, P.PRO_LIKE, P.DESCRIPTION, P.PRO_TYPE, B.BOOK_NO, B.BOOK_AUTH, B.BOOK_PUB, B.PUBL_DATE, B.CATEGORY, B.CONT_LIST "
				+ "FROM PRO_INF P "
				+ "INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) ) "
				+ "WHERE %s LIKE ?";
				
		sql = String.format(sql, type);
		
		List<ProbookVO> newProductList = new ArrayList<ProbookVO>();
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + value + "%");
			
			ProbookVO pvo = null;
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productNumber = rs.getString("PRO_NO");
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String productStock = rs.getString("STOCK");
				String productSales = rs.getString("SALES");
				String productlike = rs.getString("PRO_LIKE");
				String productDescript = rs.getString("DESCRIPTION");
				String productType = rs.getString("PRO_TYPE");
				
				String bookNumber = rs.getString("BOOK_NO");
				String writerName = rs.getString("BOOK_AUTH");
				String publisher = rs.getString("BOOK_PUB");
				String enrollDate = rs.getString("PUBL_DATE");
				String category = rs.getString("CATEGORY");
				String contentList = rs.getString("CONT_LIST");
					
				pvo = new ProbookVO();
				pvo.setProductNumber(productNumber);
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setProductStock(productStock);
				pvo.setProductSaleCount(productSales);
				pvo.setProductLikeCount(productlike);
				pvo.setProductType(productType);
				
				pvo.setBookNumber(bookNumber);
				pvo.setCategoty(category);
				pvo.setContentList(contentList);
				pvo.setPublisher(publisher);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				newProductList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return newProductList;
	}

	public int updateBookINF(Connection conn, ProbookVO pro, String type2, String value2) 
	{
		String sql = "UPDATE BOOK_INF "
				   + "SET BOOK_AUTH = ?, BOOK_PUB = ?, PUBL_DATE = ?, CATEGORY = ?, CONT_LIST = ? "
				   + "WHERE BOOK_NO = ?";

		sql = String.format(sql, type2);
		
		PreparedStatement pstmt = null;
		int result = 0;
		try 
		{
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pro.getWriterName());
			pstmt.setString(2, pro.getPublisher());
			pstmt.setString(3, pro.getEnrollDate());
			pstmt.setString(4, pro.getCategoty());
			pstmt.setString(5, pro.getContentList());

			pstmt.setString(6, value2);
			
			result = pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateProINF(Connection conn, ProbookVO pro, String type, String value) 
	{
		String sql = "UPDATE PRO_INF "
				   + "SET PRO_NAME = ?, PRO_IMG = ?, UNIT_PRICE = ?, STOCK = ?, SALES = ?, PRO_LIKE = ?, DESCRIPTION = ?, PRO_TYPE = ? "
				   + "WHERE PRO_NAME = ?";
		
		sql = String.format(sql, type);

		PreparedStatement pstmt = null;
		int result = 0;
		try 
		{
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pro.getProductName());
			pstmt.setString(2, pro.getImageLink());
			pstmt.setString(3, pro.getProductPrice());
			pstmt.setString(4, pro.getProductStock());
			pstmt.setString(5, pro.getProductSaleCount());
			pstmt.setString(6, pro.getProductLikeCount());
			pstmt.setString(7, pro.getProductDescript());
			pstmt.setString(8, pro.getProductType());
			
			pstmt.setString(9, value);
			
			result = pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public List<ProbookVO> bestSellerListcall(Connection conn) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProbookVO pvo = null;
		List<ProbookVO> bestSellerList = new ArrayList<ProbookVO>();
		
		String sql = "SELECT P.PRO_NAME, P.PRO_IMG, P.UNIT_PRICE, P.SALES, P.DESCRIPTION, B.BOOK_AUTH FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) WHERE ROWNUM <= 10 ORDER BY SALES DESC";
	
		try 
		{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String sales = rs.getString("SALES");
				String productPrice = rs.getString("UNIT_PRICE");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
					
				pvo = new ProbookVO();
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductSaleCount(sales);
				pvo.setProductPrice(productPrice);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				bestSellerList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return bestSellerList;
		
	}

	public List<ProbookVO> programinglangListcall(Connection conn, int startNum, int lastNum) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProbookVO pvo = null;
		List<ProbookVO> programinglangList = new ArrayList<ProbookVO>();
		
		String sql = "SELECT * FROM ( SELECT ROWNUM as RNUM, P.PRO_NO, P.PRO_NAME, P.PRO_IMG, P.UNIT_PRICE, P.SALES, P.DESCRIPTION, B.BOOK_AUTH, B.PUBL_DATE, B.CATEGORY FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) WHERE B.CATEGORY = '프로그래밍언어') WHERE RNUM BETWEEN ? AND ?";
	
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, lastNum);
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productNumber = rs.getString("PRO_NO");
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String enrollDate = rs.getString("PUBL_DATE");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
					
				pvo = new ProbookVO();
				pvo.setProductNumber(productNumber);
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				programinglangList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return programinglangList;
	}

	public List<ProbookVO> programinglangListcallsearchcall(Connection conn, String type, String value) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM PRO_INF P INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) WHERE B.CATEGORY = '프로그래밍언어' AND P.%s LIKE ?";
		sql = String.format(sql, type);
		System.out.println("SQL ::: " + sql);
		
		List<ProbookVO> programinglangList = new ArrayList<ProbookVO>();
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + value + "%");
			
			ProbookVO pvo = null;
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productNumber = rs.getString("PRO_NO");
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String enrollDate = rs.getString("PUBL_DATE");
				String productDescript = rs.getString("DESCRIPTION");
				String writerName = rs.getString("BOOK_AUTH");
				
				pvo = new ProbookVO();	
				pvo.setProductNumber(productNumber);
				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				programinglangList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return programinglangList;
	}

	public List<ProbookVO> bookdetailListcallsearch(Connection conn, String type, String value) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * "
				   + "FROM ( SELECT P.PRO_NO, P.PRO_NAME, P.PRO_IMG, P.UNIT_PRICE, P.STOCK, P.SALES, P.PRO_LIKE, P.DESCRIPTION, P.PRO_TYPE, B.BOOK_NO, B.BOOK_AUTH, B.BOOK_PUB, B.PUBL_DATE, B.CATEGORY, B.CONT_LIST "
				   + "FROM PRO_INF P "
				   + "INNER JOIN BOOK_INF B ON(P.PRO_NO = B.PRO_NO) "
				   + ") "
				   + "WHERE %s LIKE ?";
	
		System.out.println(sql);
		
		sql = String.format(sql, type);
		
		List<ProbookVO> bookdetailList = new ArrayList<ProbookVO>();
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			
			ProbookVO pvo = null;
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String productName = rs.getString("PRO_NAME");
				String imageLink = rs.getString("PRO_IMG");
				String productPrice = rs.getString("UNIT_PRICE");
				String productlike = rs.getString("PRO_LIKE");
				String productDescript = rs.getString("DESCRIPTION");
				
				String writerName = rs.getString("BOOK_AUTH");
				String publisher = rs.getString("BOOK_PUB");
				String enrollDate = rs.getString("PUBL_DATE");
				String category = rs.getString("CATEGORY");
				String contentList = rs.getString("CONT_LIST");
				
				System.out.println("DB에서 뽑아온 책 이름 : " + productName);
					
				pvo = new ProbookVO();

				pvo.setProductName(productName);
				pvo.setImageLink(imageLink);
				pvo.setProductPrice(productPrice);
				pvo.setProductLikeCount(productlike);

				pvo.setCategoty(category);
				pvo.setContentList(contentList);
				pvo.setPublisher(publisher);
				pvo.setEnrollDate(enrollDate);
				pvo.setProductDescript(productDescript);
				pvo.setWriterName(writerName);
				
				bookdetailList.add(pvo);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return bookdetailList;
	}


}
