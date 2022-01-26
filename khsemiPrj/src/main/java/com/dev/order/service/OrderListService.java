package com.dev.order.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.JDBCTemplate;
import com.dev.order.dao.OrderListDao;
import com.dev.order.vo.OrderListVo;

public class OrderListService 
{
	public List<OrderListVo> selectOrderList()
	{
		//디비가서 데이터 조회

		//커넥션 가져옴
		Connection conn = JDBCTemplate.getConnection();
		
		List<OrderListVo> orderlistList = new OrderListDao().selectOrderList(conn);
		
		JDBCTemplate.close(conn);
		
		return orderlistList;
	}
}

