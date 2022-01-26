package com.dev.progoods.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.dev.common.JDBCTemplate.*;

public class ProDao {

	public boolean insertCart(Connection conn, AddCartVo c) {
		boolean result = false;
		
		String sql="INSERT INTO CART VALUES(?,?,?)";
		
		PreparedStatement pstmt = null;

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c.getM_no());
			pstmt.setInt(2, c.getPro_no());
			pstmt.setInt(3, c.getQuantity());
			
			int rs = pstmt.executeUpdate();
			
			if(rs != 0) {
				commit(conn);
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(pstmt);
		}
		return result;
	}

}
