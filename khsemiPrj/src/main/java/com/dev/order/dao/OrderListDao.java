package com.dev.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.JDBCTemplate;
import com.dev.order.vo.OrderListVo;

public class OrderListDao 
{
	public List<OrderListVo> selectOrderList(Connection conn)
	{
		//쿼리 날릴 준비
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "SELECT  A.DELIVERY_STATUS"
				   + "       ,A.ORD_DATE"
				   + "       ,D.ADDR_NAME"
				   + "       ,C.PRO_IMG"
				   + "       ,C.PRO_NAME"
				   + "       ,B.QUANTITY"
				   + "       ,C.UNIT_PRICE"
				   + "       ,B.QUANTITY * C.UNIT_PRICE AS AMT"
				   + "  FROM  ORDER_INF A"
				   + "  LEFT  OUTER  JOIN ORDER_DT B"
				   + "    ON (    A.ORD_NO = B.ORD_NO )"
				   + "  LEFT  OUTER  JOIN PRO_INF  C"
				   + "    ON (    B.PRO_NO = C.PRO_NO )"
				   + "  LEFT  OUTER  JOIN DELIVERY  D"
				   + "    ON (    A.DELIVERY_NO = D.DELIVERY_NO"
				   + "        AND A.M_NO        = D.M_NO"
				   + "       )"
				   + " WHERE  A.M_NO = '2022001' \r\n"
				   + " ORDER  BY  DECODE(A.DELIVERY_STATUS, '입금확인', '1',"
				   + "                                      '출고준비', '2',"
				   + "                                      '배송중' ,  '3',"
				   + "                                      '배송완료', '4',"
				   + "                                      '주문취소', '5' "
				   + "                   )"
				   + "           ,A.ORD_DATE DESC"
				   + "           ,A.ORD_NO"
				   + "           ,B.ORD_D_NO"
				   ;
		List<OrderListVo> orderlistList = new ArrayList<OrderListVo>();
		
		//이제 쿼리 날림
		try 
		{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next())
			{
				//rs에서 현재 커서가 가리키는 행의 데이터를 가져옴
				String delivery_status = rs.getString("DELIVERY_STATUS");
				//String ord_date = rs.getString("ORD_DATE");
				String addr_name = rs.getString("ADDR_NAME");
				String pro_img = rs.getString("PRO_IMG");
				String pro_name = rs.getString("PRO_NAME");
				int quantity = rs.getInt("QUANTITY");
				int unit_price = rs.getInt("UNIT_PRICE");
				int amt = rs.getInt("AMT");
				
				//여러 변수에 흩어져 있는 데이터를 하나로 뭉침
				OrderListVo l = new OrderListVo();
				l.setDelivery_status(delivery_status);
				//l.setOrd_date(ord_date);
				l.setAddr_name(addr_name);
				l.setPro_img(pro_img);
				l.setPro_name(pro_name);
				l.setQuantity(quantity);
				l.setUnit_price(unit_price);
				l.setAmt(amt);
				
				orderlistList.add(l);
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
		
		return orderlistList;
	}
}
