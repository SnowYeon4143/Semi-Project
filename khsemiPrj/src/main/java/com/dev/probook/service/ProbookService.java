package com.dev.probook.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Part;

import com.dev.common.JDBCTemplate;
import com.dev.probook.model.ProbookDAO;
import com.dev.probook.model.ProbookVO;

public class ProbookService 
{
	public List<ProbookVO> newproductslistcall(String type, String value, String currentPage)
	{
		Connection conn = JDBCTemplate.getConnection();
		List<ProbookVO> newProductList;
		
		int totalListCount = countAllProductMethod(conn);
		
		int pageLimit = 5;
		int boardLimit = 6;
		int maxPage = 0;
		
		maxPage = totalListCount / boardLimit;
		if((totalListCount % boardLimit) != 0)
		{
			maxPage++;
		}
		
		int p = Integer.parseInt(currentPage);
		
		int lastNum = p * boardLimit;
		int startNum = lastNum - boardLimit + 1; 
		
		if (value == null) 
		{
			newProductList = newproductslistcall(conn, currentPage, startNum, lastNum);
		} 
		else 
		{
			newProductList = newproductslistcallsearchcall(conn, type, value);
		}
		
		JDBCTemplate.close(conn);
			
		return newProductList;
	}
	
	public int bookinsert(ProbookVO pro)
	{
		Connection conn = JDBCTemplate.getConnection();
		
		int result = 0;
		
		try 
		{
			result = insertBookProduct(conn, pro);
			
			if(result > 0)
			{
				JDBCTemplate.commit(conn);
			}
			else
			{
				JDBCTemplate.rollback(conn);
			}
		} 
		finally 
		{
			JDBCTemplate.close(conn);
		}

		return result;
	}	
	
	
	private int insertBookProduct(Connection conn, ProbookVO pro) 
	{
		return new ProbookDAO().insertBookProduct(conn, pro);
	}

	private int countAllProductMethod(Connection conn) 
	{
		return new ProbookDAO().countAllProductMethod(conn);
	}

	public List<ProbookVO> newproductslistcall(Connection conn, String currentPage, int startNum, int lastNum) 
	{
		return new ProbookDAO().newproductslistcall(conn, startNum, lastNum);
	}
	
	public List<ProbookVO> newproductslistcallsearchcall(Connection conn, String type, String value) 
	{
		return new ProbookDAO().newproductslistcallsearch(conn, type, value);
	}


	public List<ProbookVO> productslistcall(String type, String value, String currentPage) 
	{
		Connection conn = JDBCTemplate.getConnection();
		List<ProbookVO> ProductList;
		
		int totalListCount = countAllProductMethod(conn);
		
		int pageLimit = 5;
		int boardLimit = 5;
		int maxPage = 0;
		
		maxPage = totalListCount / boardLimit;
		if((totalListCount % boardLimit) != 0)
		{
			maxPage++;
		}
		
		int p = Integer.parseInt(currentPage);
		
		int lastNum = p * boardLimit;
		int startNum = lastNum - boardLimit + 1; 
		
		if (value == null) 
		{
			ProductList = productlistcall(conn, currentPage, startNum, lastNum);
		} 
		else 
		{
			ProductList = productlistcallsearchcall(conn, type, value);
		}

		JDBCTemplate.close(conn);
			
		return ProductList;
	}

	private List<ProbookVO> productlistcallsearchcall(Connection conn, String type, String value) 
	{
		return new ProbookDAO().productlistcallsearchcall(conn, type, value);
	}

	private List<ProbookVO> productlistcall(Connection conn, String currentPage, int startNum, int lastNum) 
	{
		return new ProbookDAO().productlistcall(conn, startNum, lastNum);
	}

	public int bookupdate(ProbookVO pro, String type, String value, String type2, String value2) 
	{
		Connection conn = JDBCTemplate.getConnection();
		
		int result = 0;
		
		try 
		{
			result = updateBookINF(conn, pro, type2, value2);
			result = updateProINF(conn, pro, type, value);
			
			if(result > 0)
			{
				JDBCTemplate.commit(conn);
			}
			else
			{
				JDBCTemplate.rollback(conn);
			}
		} 
		finally 
		{
			JDBCTemplate.close(conn);
		}

		return result;
	}

	private int updateProINF(Connection conn, ProbookVO pro, String type, String value) 
	{
		return new ProbookDAO().updateProINF(conn, pro, type, value);
	}

	private int updateBookINF(Connection conn, ProbookVO pro, String type2, String value2) 
	{
		return new ProbookDAO().updateBookINF(conn, pro, type2, value2);
	}

	public List<ProbookVO> bestSellerlistcall() 
	{
		Connection conn = JDBCTemplate.getConnection();
		List<ProbookVO> bestSellerList;

		bestSellerList = bestSellerListcall(conn);

		JDBCTemplate.close(conn);
			
		return bestSellerList;
	}

	private List<ProbookVO> bestSellerListcall(Connection conn) 
	{
		return new ProbookDAO().bestSellerListcall(conn);
	}

	public List<ProbookVO> programinglangListcall(String type, String value, String currentPage) 
	{
		Connection conn = JDBCTemplate.getConnection();
		List<ProbookVO> programinglangList;
		
		int totalListCount = countAllProductMethod(conn);
		
		int pageLimit = 5;
		int boardLimit = 6;
		int maxPage = 0;
		
		maxPage = totalListCount / boardLimit;
		if((totalListCount % boardLimit) != 0)
		{
			maxPage++;
		}
		
		int p = Integer.parseInt(currentPage);
		
		int lastNum = p * boardLimit;
		int startNum = lastNum - boardLimit + 1; 
		
		if (value == null) 
		{
			programinglangList = programinglangListcall(conn, currentPage, startNum, lastNum);
		} 
		else 
		{
			programinglangList = programinglangListcallsearchcall(conn, type, value);
		}
		
		JDBCTemplate.close(conn);
			
		return programinglangList;
	}

	private List<ProbookVO> programinglangListcall(Connection conn, String currentPage, int startNum, int lastNum)  
	{
		return new ProbookDAO().programinglangListcall(conn, startNum, lastNum);
	}

	private List<ProbookVO> programinglangListcallsearchcall(Connection conn, String type, String value) 
	{
		return new ProbookDAO().programinglangListcallsearchcall(conn, type, value);
	}

	public List<ProbookVO> bookdetailListcall(String type, String value)
	{
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProbookVO> bookdetailList;
		
		bookdetailList = bookdetailListcall(conn, type, value);
		JDBCTemplate.close(conn);
			
		return bookdetailList;
	}

	private List<ProbookVO> bookdetailListcall(Connection conn, String type, String value)
	{
		return new ProbookDAO().bookdetailListcallsearch(conn, type, value);
	}
}























