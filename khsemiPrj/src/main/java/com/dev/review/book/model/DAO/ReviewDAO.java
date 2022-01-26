package com.dev.review.book.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.JDBCTemplate;
import com.dev.probook.model.ProbookVO;
import com.dev.review.book.model.vo.ReviewVO;

public class ReviewDAO 
{

	public int insertReview(Connection conn, ReviewVO rv) 
	{
		System.out.println("DAO");
		String sql = "INSERT ALL INTO BOOK_REVIEW VALUES (SEQ_BOOK_REVIEW.NEXTVAL, 1, '작성한 리뷰', ?, 'N', 0, SYSDATE, 'N') SELECT * FROM DUAL";

		PreparedStatement pstmt = null;
		
		int result = 0;
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rv.getBookReviewContext());
			
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
		
		System.out.println("DAO end");
		
		return result;
	}

	public List<ReviewVO> reviewListcalled(Connection conn) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVO rv = null;
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		
		String sql = "SELECT BR_TITLE, BR_CONT, BR_LIKE, BR_DATE FROM BOOK_REVIEW";
	
		try 
		{
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
				
			while (rs.next()) 
			{
				String reviewTitle = rs.getString("BR_TITLE");
				String reviewContext = rs.getString("BR_CONT");
				String reviewLike = rs.getString("BR_LIKE");
				String reviewDate = rs.getString("BR_DATE");
					
				rv = new ReviewVO();
				rv.setBookReviewTitle(reviewTitle);
				rv.setBookReviewContext(reviewContext);
				rv.setBookReviewLikeCount(reviewLike);
				rv.setBookReviewDate(reviewDate);
				
				reviewList.add(rv);
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
		
		System.out.println(rv.getBookReviewTitle());
		System.out.println(rv.getBookReviewContext());
		
		return reviewList;
	}

}
