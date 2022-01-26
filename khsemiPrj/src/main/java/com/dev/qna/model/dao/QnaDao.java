package com.dev.qna.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.dev.common.JDBCTemplate.*;

import com.dev.qna.model.vo.QnaAnswersVo;
import com.dev.qna.model.vo.QnaVo;

public class QnaDao {
	public List<QnaVo> qnaList(Connection conn, int rowStartNo, int rowEndNo) {
		System.out.println("qnalist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY Q.Q_NO DESC) AS RNUM, Q.Q_NO, Q.Q_TITLE, Q.Q_CONTENT, TRUNC(Q.Q_DATE) AS \"Q_DATE\", M.ID, Q.Q_VIEW FROM QNA Q JOIN MEMBER M ON Q.M_NO = M.M_NO WHERE Q_DEL_YN = 'N' ORDER BY Q.Q_NO DESC ) WHERE RNUM BETWEEN ? AND ?";
		List<QnaVo> qnaList = new ArrayList<QnaVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowStartNo);
			pstmt.setInt(2, rowEndNo);
			rs = pstmt.executeQuery();
			QnaVo q = null;
			
			while(rs.next()) {
				int qnaNo = rs.getInt("Q_NO");
				String qTitle = rs.getString("Q_TITLE");
				String qContent = rs.getString("Q_CONTENT");
				Timestamp qDate = rs.getTimestamp("Q_DATE");
				String qId = rs.getString("ID");
				int qView = rs.getInt("Q_VIEW");
				
				//모델에 넣어줌
				q = new QnaVo(qnaNo, qTitle, qContent, qDate, qId, qView);
				qnaList.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return qnaList;
	}
	
	public List<QnaVo> qnaReportList(Connection conn, int rowStartNo, int rowEndNo) {
		System.out.println("qnareportlist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY Q.Q_NO DESC) AS RNUM, Q.Q_NO, Q.Q_TITLE, Q.Q_CONTENT, TRUNC(Q.Q_DATE) AS \"Q_DATE\", M.ID, Q.Q_VIEW FROM QNA Q JOIN MEMBER M ON Q.M_NO = M.M_NO WHERE Q_REPT_YN = 'Y' AND Q_DEL_YN = 'N' ORDER BY Q.Q_NO DESC ) WHERE RNUM BETWEEN ? AND ?";
		List<QnaVo> qnaList = new ArrayList<QnaVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowStartNo);
			pstmt.setInt(2, rowEndNo);
			rs = pstmt.executeQuery();
			QnaVo q = null;
			
			while(rs.next()) {
				int qnaNo = rs.getInt("Q_NO");
				String qTitle = rs.getString("Q_TITLE");
				String qContent = rs.getString("Q_CONTENT");
				Timestamp qDate = rs.getTimestamp("Q_DATE");
				String qId = rs.getString("ID");
				int qView = rs.getInt("Q_VIEW");
				
				//모델에 넣어줌
				q = new QnaVo(qnaNo, qTitle, qContent, qDate, qId, qView);
				qnaList.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return qnaList;
	}

	public int totalCount(Connection conn) {
		System.out.println("qnalist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM QNA WHERE Q_DEL_YN = 'N'";
		
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
	
	public int totalReptCount(Connection conn) {
		System.out.println("qnareptlist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM QNA WHERE Q_REPT_YN = 'Y'";
		
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

	public int insertQna(Connection conn, QnaVo q) {
		String sql = "INSERT INTO QNA(Q_NO, M_NO, Q_TITLE, Q_CONTENT ) VALUES(SEQ_QNA.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q.getQnaNo());
//			pstmt.setInt(1, 3);
			pstmt.setString(2, q.getQnaTitle());
			pstmt.setString(3, q.getQnaContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public QnaVo qnaSelect(Connection conn, int qnaNo) {
		String sql = "SELECT Q.Q_NO, Q.Q_TITLE, Q.Q_CONTENT, TRUNC(Q.Q_DATE) AS \"Q_DATE\", M.ID, Q.Q_VIEW FROM QNA Q JOIN MEMBER M ON Q.M_NO = M.M_NO WHERE Q_NO = ?";
//		String sql2 = "UPDATE QNA SET Q_VIEW = Q_VIEW +1 WHERE Q_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaVo q = new QnaVo();
		try {
			//조회수 증가
//			pstmt = conn.prepareStatement(sql2);
//			pstmt.setInt(1, qnaNo);
//			pstmt.execute();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
				
			rs.next();
//			int qnaNo = rs.getInt("Q_NO");
			String qTitle = rs.getString("Q_TITLE");
			String qContent = rs.getString("Q_CONTENT");
			Timestamp qDate = rs.getTimestamp("Q_DATE");
			String qId = rs.getString("ID");
			int qView = rs.getInt("Q_VIEW");
					
			//모델에 넣어줌
			q = new QnaVo(qnaNo, qTitle, qContent, qDate, qId, qView);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return q;
	}
	
	//qna조회수 증가
	public void qnaViewPlus(Connection conn, int qnaNo) {
		String sql = "UPDATE QNA SET Q_VIEW = Q_VIEW +1 WHERE Q_NO = ?";
		PreparedStatement pstmt = null;
		//조회수 증가
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("조회수 추가 안댐");
		}
	}

	//qna 삭제
	public int qnaDelete(Connection conn, int qnaNo) {
		String sql = "UPDATE QNA SET Q_DEL_YN = 'Y' WHERE Q_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//qna수정
	public int qnaUpdate(Connection conn, QnaVo q) {
		String sql = "UPDATE QNA SET Q_TITLE = ?, Q_CONTENT = ? WHERE Q_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getQnaTitle());
			pstmt.setString(2, q.getQnaContent());
			pstmt.setInt(3, q.getQnaNo());
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//답변 작성
	public int insertQnaAnswers(Connection conn, QnaAnswersVo a) {
		String sql = "INSERT INTO ANSWERS(A_NO, Q_NO, A_CONTENT) VALUES(SEQ_ANSWERS.NEXTVAL, ?, ?)";

		PreparedStatement pstmt = null;

		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a.getQnaNo());
			pstmt.setString(2, a.getAnsContent());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	//답변 조회
	public QnaAnswersVo ansSelect(Connection conn, int qnaNo) {
		String sql = "SELECT * FROM ANSWERS WHERE Q_NO = ? AND A_DEL_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaAnswersVo a = new QnaAnswersVo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
				
			rs.next();
//			int qnaNo = rs.getInt("Q_NO");
			String aContent = rs.getString("A_CONTENT");
			int aLike = rs.getInt("A_LIKE");
			Timestamp aDate = rs.getTimestamp("A_DATE");
			
					
			//모델에 넣어줌
			a = new QnaAnswersVo();
			a.setQnaNo(qnaNo);
			a.setAnsContent(aContent);
			a.setAnswersLike(aLike);
			a.setAnsDate(aDate);
			
		} catch (SQLException e) {
			System.out.println("답변이 없어요");
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return a;
	}
	
	//신고
	public int reportQnaDt(Connection conn, int qnaNo) {
		String sql = "UPDATE QNA SET Q_REPT_YN = 'Y' WHERE Q_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//신고취소
	public int qnaReportCancel(Connection conn, int qnaNo) {
		String sql = "UPDATE QNA SET Q_REPT_YN = 'N' WHERE Q_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int qnaAnswersDelete(Connection conn, int qnaNo) {
		String sql = "DELETE FROM ANSWERS WHERE Q_NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int qnaLikePlus(Connection conn, int qnaNo) {
		String sql = "UPDATE ANSWERS SET A_LIKE = A_LIKE +1 WHERE Q_NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		//조회수 증가
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("좋아요 추가 안댐");
		}
		return result;
	}

	public int qnaLikeSelect(Connection conn, int qnaNo) {
		String sql = "SELECT A_LIKE FROM ANSWERS WHERE Q_NO = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
				
			rs.next();
			int aLike = rs.getInt("A_LIKE");
					
			//모델에 넣어줌
			result = aLike;
			
		} catch (SQLException e) {
			System.out.println("좋아요가 없어요");
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;

	}

}
