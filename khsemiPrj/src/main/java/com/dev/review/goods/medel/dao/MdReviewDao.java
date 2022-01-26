package com.dev.review.goods.medel.dao;

import static com.dev.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.progoods.model.ProgoodsVo;
import com.dev.review.goods.modelVo.MdReviewVo;

public class MdReviewDao {

	public int totalReviewCount(Connection conn, int pro_no) {
		String sql ="SELECT count(*) FROM MD_REVIEW WHERE MD_NO = ?";
		
		PreparedStatement pstmt = null;
		int total =0;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pro_no);
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

	
	public List<MdReviewVo> mdReList(Connection conn, int pro_no, int startNo, int endNo) {
		
		String sql = "SELECT R.*, M.ID FROM MD_REVIEW R JOIN MEMBER M ON R.M_NO = M.M_NO  WHERE MD_NO = ? AND MR_DEL_YN = 'N' AND MR_REPT_YN ='N'";
		
		PreparedStatement pstmt = null;
		
		List<MdReviewVo> mdReList = new ArrayList<MdReviewVo>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pro_no);
			
			rs = pstmt.executeQuery();
			MdReviewVo r = null;
			while(rs.next()) {
				int mr_no =rs.getInt("MR_NO");
				int md_no =rs.getInt("MD_NO");
//				String mr_title =rs.getInt("MR_TITLE");
				String mr_cont =rs.getString("MR_CONT");
//				String mr_rept_yn =rs.getInt("MR_REPT_YN");
				int mr_like =rs.getInt("MR_LIKE");
				String mr_date =rs.getString("MR_DATE");
//				String mr_del_yn =rs.getInt("MR_DEL_YN");
				String id =rs.getString("ID");
				
				r = new MdReviewVo();
				r.setMr_no(mr_no);
				r.setMd_no(md_no);
				r.setMr_cont(mr_cont);
				r.setMr_like(mr_like);
				r.setMr_date(mr_date);
				r.setId(id);
				
				mdReList.add(r);
			}
			
			
		} catch (SQLException e) {
			System.out.println("sql error");
			e.printStackTrace();
		}finally {
				close(pstmt);
				close(rs);
		}
		
		System.out.println("dao called");
		return mdReList;
		
		
	}


	public boolean insertR(Connection conn, int m_no, int pro_no, String mr_cont) {
		boolean result =false;
		String sql ="INSERT INTO MD_REVIEW(MR_NO, MD_NO, MR_CONT, MR_DEL_YN, M_NO) VALUES(SEQ_MD_REVIEW.NEXTVAL, ? , ? , 'N', ? )";
		
		PreparedStatement pstmt = null;
		int insert =0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pro_no);
			pstmt.setString(2, mr_cont);
			pstmt.setInt(3, m_no);
			
			insert = pstmt.executeUpdate();
			if(insert != 0) {
				commit(conn);
				result=true;
			}
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);

		}
		return result;
	}


	public List<MdReviewVo> mdReportList(Connection conn) {
		
		
		String sql = "SELECT R.*, M.ID, P.PRO_IMG FROM MD_REVIEW R JOIN MEMBER M ON R.M_NO = M.M_NO JOIN PRO_INF P ON P.PRO_NO = R.MD_NO  AND MR_DEL_YN = 'N' AND MR_REPT_YN ='Y'";
		
		PreparedStatement pstmt = null;
		
		List<MdReviewVo> mdReportList = new ArrayList<MdReviewVo>();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			MdReviewVo r = null;
			while(rs.next()) {
				int mr_no =rs.getInt("MR_NO");
				int md_no =rs.getInt("MD_NO");
				String mr_cont =rs.getString("MR_CONT");
				int mr_like =rs.getInt("MR_LIKE");
				String mr_date =rs.getString("MR_DATE");
				String id =rs.getString("ID");
				String pro_img =rs.getString("PRO_IMG");
				
//				String mr_title =rs.getInt("MR_TITLE");
//				String mr_rept_yn =rs.getInt("MR_REPT_YN");
//				String mr_del_yn =rs.getInt("MR_DEL_YN");

				r = new MdReviewVo();
				r.setMr_no(mr_no);
				r.setMd_no(md_no);
				r.setMr_cont(mr_cont);
				r.setMr_like(mr_like);
				r.setMr_date(mr_date);
				r.setId(id);
				r.setPro_img(pro_img);
				
				mdReportList.add(r);
			}
			
			
		} catch (SQLException e) {
			System.out.println("sql error");
			e.printStackTrace();
		}finally {
				close(pstmt);
				close(rs);
		}
		
		System.out.println("dao called : "+ mdReportList);
		return mdReportList;

	}

}
