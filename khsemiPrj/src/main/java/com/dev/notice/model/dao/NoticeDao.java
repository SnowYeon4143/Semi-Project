package com.dev.notice.model.dao;

import static com.dev.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dev.notice.model.vo.NoticeVo;

public class NoticeDao {
	public List<NoticeVo> noticeList(Connection conn, int rowStartNo, int rowEndNo) {
		System.out.println("noticelist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY N.N_NO DESC) AS RNUM, N.N_NO, N.N_TITLE,TRUNC(N.N_DATE) AS \"N_DATE\", N.N_VIEW FROM NOTICE N WHERE N_DEL_YN = 'N' ORDER BY N.N_NO DESC ) WHERE RNUM BETWEEN ? AND ?";
		List<NoticeVo> noticeList = new ArrayList<NoticeVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowStartNo);
			pstmt.setInt(2, rowEndNo);
			rs = pstmt.executeQuery();
			NoticeVo n = null;
			
			while(rs.next()) {
				int noticeNo = rs.getInt("N_NO");
				String nTitle = rs.getString("N_TITLE");
				Timestamp nDate = rs.getTimestamp("N_DATE");
				int nView = rs.getInt("N_VIEW");
				
				//모델에 넣어줌
				n = new NoticeVo(noticeNo, nTitle, nDate, nView);
				noticeList.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return noticeList;
	}

	public int totalCount(Connection conn) {
		System.out.println("noticelist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM NOTICE WHERE N_DEL_YN = 'N'";
		
		int total = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		
		return total;
	}

	public int insertNotice(Connection conn, NoticeVo n) {
		String sql = "INSERT INTO NOTICE(N_NO, N_TITLE, N_CONTENT) VALUES(SEQ_NOTICE.NEXTVAL, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public NoticeVo noticeSelect(Connection conn, int noticeNo) {
		String sql = "SELECT N.N_NO, N.N_TITLE, N.N_CONTENT, TRUNC(N.N_DATE) AS \"N_DATE\", N.N_VIEW FROM NOTICE N WHERE N_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo n = new NoticeVo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
				
			rs.next();
//			int noticeNo = rs.getInt("N_NO");
			String nTitle = rs.getString("N_TITLE");
			String nContent = rs.getString("N_CONTENT");
			Timestamp nDate = rs.getTimestamp("N_DATE");
			int nView = rs.getInt("N_VIEW");
					
			//모델에 넣어줌
			n = new NoticeVo(noticeNo, nTitle, nContent, nDate, nView);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return n;
	}
	
	//notice조회수 증가
	public void noticeViewPlus(Connection conn, int noticeNo) {
		String sql = "UPDATE NOTICE SET N_VIEW = N_VIEW +1 WHERE N_NO = ?";
		PreparedStatement pstmt = null;
		// 조회수 증가
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("조회수 추가 안됌");
		}
	}

	public int noticeDelete(Connection conn, int noticeNo) {
		String sql = "UPDATE NOTICE SET N_DEL_YN = 'Y' WHERE N_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int noticeUpdate(Connection conn, NoticeVo n) {
		String sql = "UPDATE NOTICE SET N_TITLE = ?, N_CONTENT = ? WHERE N_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
