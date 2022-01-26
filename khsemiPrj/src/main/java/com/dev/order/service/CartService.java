package com.dev.order.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.common.JDBCTemplate;
import com.dev.order.dao.CartDao;
import com.dev.order.vo.CartVo;

public class CartService 
{
	public List<CartVo> selectCartList()
	{
		//디비가서 데이터 조회

		//커넥션 가져옴
		Connection conn = JDBCTemplate.getConnection();
		
		List<CartVo> cartList = new CartDao().selectCartList(conn);
		
		JDBCTemplate.close(conn);
		
		return cartList;
	}
}
