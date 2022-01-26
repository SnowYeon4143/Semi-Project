package com.dev.event.model.dao;

import static com.dev.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dev.event.model.vo.EventApplicationVo;
import com.dev.event.model.vo.EventVo;

public class EventDao {
	public List<EventVo> eventList(Connection conn, int rowStartNo, int rowEndNo) {
		System.out.println("eventlist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ( SELECT ROW_NUMBER() OVER(ORDER BY E.E_NO DESC) AS RNUM, E.E_NO, E.E_TITLE,TRUNC(E.E_DATE) AS \"E_DATE\", E.E_VIEW FROM EVENT E WHERE E_DEL_YN = 'N' ORDER BY E.E_NO DESC)WHERE RNUM BETWEEN ? AND ?";
		List<EventVo> eventList = new ArrayList<EventVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowStartNo);
			pstmt.setInt(2, rowEndNo);
			rs = pstmt.executeQuery();
			EventVo e = null;
			
			while(rs.next()) {
				int eventNo = rs.getInt("E_NO");
				String eTitle = rs.getString("E_TITLE");
				Timestamp eDate = rs.getTimestamp("E_DATE");
				int eView = rs.getInt("E_VIEW");
				
				//모델에 넣어줌
				e = new EventVo();
				e.setEventNo(eventNo);
				e.setEventTitle(eTitle);
				e.setEventDate(eDate);
				e.setEventView(eView);
				eventList.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return eventList;
	}

	public int totalCount(Connection conn) {
		System.out.println("eventlist dao called...");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM EVENT WHERE E_DEL_YN = 'N'";
		
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

	public int insertEvent(Connection conn, EventVo e) {
		String sql = "INSERT INTO EVENT(E_NO, E_TITLE, E_CONTENT, E_DATE, E_START, E_END, E_IMGURL) VALUES (SEQ_EVENT.NEXTVAL, ?, ?, SYSDATE,?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEventTitle());
			pstmt.setString(2, e.getEventContent());
			pstmt.setTimestamp(3, e.getEventStart());
			pstmt.setTimestamp(4, e.getEventEnd());
			pstmt.setString(5, e.getEventImgUrl());
			
			result = pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public EventVo eventSelect(Connection conn, int eventNo) {
		String sql = "SELECT E.E_NO, E.E_TITLE, E.E_CONTENT, TRUNC(E.E_DATE) AS \"E_DATE\", E.E_START, E.E_END, E.E_VIEW, E.E_IMGURL FROM EVENT E WHERE E_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EventVo e = new EventVo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rs = pstmt.executeQuery();
				
			rs.next();
//			int eventNo = rs.getInt("E_NO");
			String eTitle = rs.getString("E_TITLE");
			String eContent = rs.getString("E_CONTENT");
			Timestamp eDate = rs.getTimestamp("E_DATE");
			Timestamp sStart = rs.getTimestamp("E_START");
			Timestamp sEnd = rs.getTimestamp("E_END");
			String sImg = rs.getString("E_IMGURL");
			int eView = rs.getInt("E_VIEW");
					
			//모델에 넣어줌
			e = new EventVo();
			e.setEventNo(eventNo);
			e.setEventTitle(eTitle);
			e.setEventContent(eContent);
			e.setEventDate(eDate);
			e.setEventStart(sStart);
			e.setEventEnd(sEnd);
			e.setEventImgUrl(sImg);
			e.setEventView(eView);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return e;
	}
	
	//event조회수 증가
	public void eventViewPlus(Connection conn, int eventNo) {
		String sql = "UPDATE EVENT SET E_VIEW = E_VIEW +1 WHERE E_NO = ?";
		PreparedStatement pstmt = null;
		// 조회수 증가
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("조회수 추가 안됌");
		}
	}

	public int eventDelete(Connection conn, int eventNo) {
		String sql = "UPDATE EVENT SET E_DEL_YN = 'Y' WHERE E_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int eventUpdate(Connection conn, EventVo e) {
		String sql = "UPDATE EVENT SET E_TITLE = ?, E_CONTENT = ?, E_START = ?, E_END = ?, E_IMGURL = ? WHERE E_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEventTitle());
			pstmt.setString(2, e.getEventContent());
			pstmt.setTimestamp(3, e.getEventStart());
			pstmt.setTimestamp(4, e.getEventEnd());
			pstmt.setString(5, e.getEventImgUrl());
			pstmt.setInt(6, e.getEventNo());
			result = pstmt.executeUpdate();
			System.out.println("이벤트dao에서 e 객체 : " + e);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertEventApplication(Connection conn, EventApplicationVo ea) {
		String sql = "INSERT INTO EVENT_APPLICATION(EA_NO, E_NO, M_NO, EA_ID, EA_EMAIL) VALUES(SEQ_EVENT_APP.NEXTVAL, ?, ?, ?, ?)";

		PreparedStatement pstmt = null;

		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ea.geteNo());
			pstmt.setInt(2, ea.getmNo());
			pstmt.setString(3, ea.getEaId());
			pstmt.setString(4, ea.getEaEmail());
			

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
}
