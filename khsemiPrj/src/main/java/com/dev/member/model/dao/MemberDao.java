package com.dev.member.model.dao;

import static com.dev.common.JDBCTemplate.close;

import static com.dev.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;

import com.dev.common.JDBCTemplate;
import com.dev.member.model.vo.MemberVo;

public class MemberDao {

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}
	
	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		
		// 쿼리 날리기
		String sql = "INSERT INTO MEMBER (M_NO, ID, PWD, NAME, EMAIL, PHONE, ADDR, ADDR_DETAIL, YY, MM, DD) "
				+ 	 "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String userEmail = m.getUserEmail() + '@' + m.getUserEmail2();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, userEmail);
			pstmt.setString(5, m.getUserPhone());
			pstmt.setString(6, m.getAddr());
			pstmt.setString(7, m.getAddrDetail());
			pstmt.setString(8, m.getYy());
			pstmt.setString(9, m.getMm());
			pstmt.setString(10, m.getDd());
			
			
			result = pstmt.executeUpdate();

		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	public int selectMemberId(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
			
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}

	public MemberVo selectMember(Connection conn, MemberVo m) {
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND ENT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo selectedMember = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberNo = rs.getInt("M_NO");
				String userId = rs.getString("ID");
				String userPwd = rs.getString("PWD");
				String userName = rs.getString("NAME");
				String userEmail = rs.getString("EMAIL");
				String userPhone = rs.getString("PHONE");
				String entYn = rs.getString("ENT_YN");
				int point = rs.getInt("POINT");
				Timestamp hireDate = rs.getTimestamp("HIRE_DATE");
				int reportCount = rs.getInt("REPORT_COUNT");
				int reviewtCount = rs.getInt("REVIEW_COUNT");
				int qnaCount = rs.getInt("QNA_COUNT");
				Timestamp updateDate = rs.getTimestamp("UPDATE_DATE");
				String addr = rs.getString("ADDR");
				String addrDetail = rs.getString("ADDR_DETAIL");
				String yy = rs.getString("YY");
				String mm = rs.getString("MM");
				String dd = rs.getString("DD");
				
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setUserId(userId);
				selectedMember.setUserPwd(userPwd);
				selectedMember.setUserName(userName);
				selectedMember.setUserEmail(userEmail);
				selectedMember.setUserPhone(userPhone);
				selectedMember.setEntYn(entYn);
				selectedMember.setPoint(point);
				selectedMember.setHireDate(hireDate);
				selectedMember.setReportCount(reportCount);
				selectedMember.setReviewtCount(reviewtCount);
				selectedMember.setQnaCount(qnaCount);
				selectedMember.setUpdateDate(updateDate);
				selectedMember.setAddr(addr);
				selectedMember.setAddrDetail(addrDetail);
				selectedMember.setYy(yy);
				selectedMember.setMm(mm);
				selectedMember.setDd(dd);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			
		}		
		
		return selectedMember;
	}

	public String findId(Connection conn, String userName, String userPhone) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userId = null;
		String sql = "SELECT ID FROM MEMBER WHERE NAME = ? AND PHONE = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userId = rs.getString("ID");
			}
			
			System.out.println(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return userId;
	}

	public String findPwd(Connection conn, String userId, String userName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userPwd = null;
		String sql = "SELECT PWD FROM MEMBER WHERE ID = ? AND NAME = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userPwd = rs.getString("PWD");
			}
			
			System.out.println(userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return userPwd;
	}
	
	public int updateMember(MemberVo vo) {
		// 회원 정보 업데이트
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		String sql = "UPDATE MEMBER SET PWD = ?, NAME = ?, EMAIL = ?, PHONE = ?, ADDR = ?, ADDR_DETAIL = ? WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserPwd());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getUserEmail());
			pstmt.setString(4, vo.getUserPhone());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getAddrDetail());
			pstmt.setString(7, vo.getUserId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public MemberVo getUser(String userId) {
		// 가입된 회원의 ID를 가져와 입력 정보를 불러온다.
		MemberVo vo = null; // 데이터가 없을 경우 null 값을 반환.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ID, NAME , EMAIL , PHONE , ADDR , ADDR_DETAIL , YY , MM , DD FROM MEMBER WHERE ID = ?";

		try {
			conn = getConnection(); // DB 연결 시도
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new MemberVo();
				vo.setUserId(rs.getString("ID"));
				vo.setUserName(rs.getString("NAME"));
				vo.setUserEmail(rs.getString("EMAIL"));
				vo.setUserPhone(rs.getString("PHONE"));
				vo.setAddr(rs.getString("ADDR"));
				vo.setAddrDetail(rs.getString("ADDR_DETAIL"));
				vo.setYy(rs.getString("YY"));
				vo.setMm(rs.getString("MM"));
				vo.setDd(rs.getString("DD"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}
	
	 @SuppressWarnings("resource")
	public int deleteMember(String userId, String userPwd) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	 
	        String dbpw = ""; // DB상의 비밀번호를 담아둘 변수
	        int result = -1;
	 
	        try {
	            // 비밀번호 조회
	            StringBuffer query1 = new StringBuffer();
	            query1.append("SELECT PWD FROM MEMBER WHERE ID = ?");
	 
	            // 회원 삭제
	            StringBuffer query2 = new StringBuffer();
	            query2.append("DELETE FROM MEMBER WHERE ID=?");
	 
	            conn = getConnection();
	            
	            // 1. 아이디에 해당하는 비밀번호를 조회한다.
	            pstmt = conn.prepareStatement(query1.toString());
	            pstmt.setString(1, userId);
	            System.out.println(userId);
	            rs = pstmt.executeQuery();
	 
	            if (rs.next()) 
	            {
	                dbpw = rs.getString("PWD");
	                System.out.println(userPwd);
	                if (dbpw.equals(userPwd)) // 입력된 비밀번호와 DB비번 비교
	                {
	                    // 같을경우 회원삭제 진행
	                    pstmt = conn.prepareStatement(query2.toString());
	                    pstmt.setString(1, userId);
	                    System.out.println(userId);
	                    pstmt.executeUpdate();
	                    conn.commit(); 
	                    result = 1; // 삭제 성공
	                } else {
	                    result = 0; // 비밀번호 비교결과 - 다름
	                }
	            }
	 
	            return result;
	 
	        } catch (Exception sqle) {
	            try {
	                conn.rollback(); // 오류시 롤백
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            throw new RuntimeException(sqle.getMessage());
	        } finally {
	            try{
	                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
	                if ( conn != null ){ conn.close(); conn=null;    }
	            }catch(Exception e){
	                throw new RuntimeException(e.getMessage());
	            }
	        }
	    } // end deleteMember
}