package com.dev.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.JDBCTemplate;
import com.dev.order.vo.CartVo;

public class CartDao 
{
	public List<CartVo> selectCartList(Connection conn)
	{
		//쿼리 날릴 준비
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "SELECT  A.PRO_NO "
				   + "       ,B.PRO_IMG "
				   + "       ,B.PRO_NAME "
				   + "       ,B.UNIT_PRICE "
				   + "       ,A.QUANTITY "
				   + "       ,A.QUANTITY * B.UNIT_PRICE  AS AMT "
				   + "  FROM  CART  A "
				   + "  LEFT  OUTER  JOIN  PRO_INF  B "
				   + "    ON (    A.PRO_NO = B.PRO_NO"
				   + "       ) "
				   ;
		List<CartVo> cartList = new ArrayList<CartVo>();
		
		//이제 쿼리 날림
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next())
			{
				//rs에서 현재 커서가 가리키는 행의 데이터를 가져옴
				int pro_no = rs.getInt("PRO_NO");
				String pro_img = rs.getString("PRO_IMG");
				String pro_name = rs.getString("PRO_NAME");
				int unit_price = rs.getInt("UNIT_PRICE");
				int quantity = rs.getInt("QUANTITY");
				int amt = rs.getInt("AMT");
				
				//여러 변수에 흩어져 있는 데이터를 하나로 뭉침
				CartVo c = new CartVo();
				c.setPro_no(pro_no);
				c.setPro_img(pro_img);
				c.setPro_name(pro_name);
				c.setUnit_price(unit_price);
				c.setQuantity(quantity);
				c.setAmt(amt);
				
				cartList.add(c);
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
		
		return cartList;
	}
}
