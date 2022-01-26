package com.dev.review.book.Service;

import java.sql.Connection;
import java.util.List;

import com.dev.common.JDBCTemplate;
import com.dev.probook.model.ProbookDAO;
import com.dev.probook.model.ProbookVO;
import com.dev.review.book.model.DAO.ReviewDAO;
import com.dev.review.book.model.vo.ReviewVO;

public class ProBookReviewService {

	public int reviewInsert(ReviewVO rv) 
	{
		System.out.println("service");
		Connection conn = JDBCTemplate.getConnection();
		
		int result = 0;
		
		try 
		{
			result = insertReview(conn, rv);
			
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
		
		System.out.println("service end");

		return result;
	}

	private int insertReview(Connection conn, ReviewVO rv) 
	{
		return new ReviewDAO().insertReview(conn, rv);
	}

	public List<ReviewVO> reviewListcall() 
	{
		Connection conn = JDBCTemplate.getConnection();
		List<ReviewVO> reviewList;
		
		reviewList = reviewListcalled(conn);
		
		JDBCTemplate.close(conn);
			
		return reviewList;
	}

	private List<ReviewVO> reviewListcalled(Connection conn) 
	{
		return new ReviewDAO().reviewListcalled(conn);
	}

}
