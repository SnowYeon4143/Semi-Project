package com.dev.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
   
   //Ŀ�ؼ� ��������
   public static Connection getConnection() {
      String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
      String id = "DEVBOOKS";
      String pwd = "DEV";
      
      Connection conn = null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection(url, id, pwd);
         conn.setAutoCommit(false);
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return conn;
   }
   
   //Ŀ��
   public static void commit(Connection conn) {
      
      try {
         //null, isClosed
         if(conn != null && !conn.isClosed())
            conn.commit();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   //�ѹ�
   public static void rollback(Connection conn) {
      
      try {
         //null, isClosed
         if(conn != null && !conn.isClosed())
            conn.rollback();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   //close �� (Connection, statement, ResultSet)
   public static void close(Connection conn) {
      
      try {
         //null, isClosed
         if(conn != null && !conn.isClosed())
            conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Statement stmt) {
      
      try {
         //null, isClosed
         if(stmt != null && !stmt.isClosed())
            stmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void close(PreparedStatement pstmt) {
	      
	      try {
	         //null, isClosed
	         if(pstmt != null && !pstmt.isClosed())
	            pstmt.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
   
   public static void close(ResultSet rs) {
      
      try {
         //null, isClosed
         if(rs != null && !rs.isClosed())
            rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
}