package com.dev.progoods.model;

import java.sql.Connection;
import static com.dev.common.JDBCTemplate.*;

public class ProService {

	public boolean insertCart(AddCartVo c) {
		
		Connection conn = getConnection();
		
		boolean result = new ProDao().insertCart(conn, c);
		close(conn);
		return false;
	}

}
