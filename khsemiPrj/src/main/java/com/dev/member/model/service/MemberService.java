package com.dev.member.model.service;

import java.sql.Connection;

import java.sql.SQLException;

import static com.dev.common.JDBCTemplate.*;
import static com.dev.common.JDBCTemplate.close;
import static com.dev.common.JDBCTemplate.getConnection;

import com.dev.member.model.dao.MemberDao;
import com.dev.member.model.vo.MemberVo;

public class MemberService {

	private MemberDao dao = new MemberDao();
	
	public int join(MemberVo m) {
		
		
		// DB Connection 가져오기
		Connection conn = getConnection();
		
		// 쿼리 날리기 // insert
		int result = 0;
		try {
			result = insertMember(conn, m);
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		// 결과 반환
		return result;
	}

	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		
		// dao 불러서 쿼리 실행
		// dao 한테 쿼리 실행 결과 받아서, 비즈니스 로직 처리
		return new MemberDao().insertMember(conn, m);
		
	}

	public int dupCheck(String userId) {
		Connection conn = getConnection();
		int result = selectMemberById(conn, userId);
		close(conn);
		return result;
	}

	private int selectMemberById(Connection conn, String userId) {
		return new MemberDao().selectMemberId(conn, userId);
	}

	public MemberVo login(MemberVo m) {
		// 커넥션 가져오기
		Connection conn = getConnection();
				
		// id로 그 아이디의 비번 조회
		MemberVo selectedMember = selectMember(conn, m);
				
		close(conn);
				
		if (selectedMember.getUserPwd().equals(m.getUserPwd())) {
				return selectedMember;
		} else {
				return null;
		}
	}

	private MemberVo selectMember(Connection conn, MemberVo m) {
		return new MemberDao().selectMember(conn ,m);
	}

	public String searchId(String userName, String userPhone) {
		Connection conn = getConnection();
		String userId = dao.findId(conn, userName, userPhone);
		close(conn);
		return userId;
	}

	public String searchPwd(String userId, String userName) {
		Connection conn = getConnection();
		String userPwd = dao.findPwd(conn, userId, userName);
		close(conn);
		return userPwd;
	}

}
