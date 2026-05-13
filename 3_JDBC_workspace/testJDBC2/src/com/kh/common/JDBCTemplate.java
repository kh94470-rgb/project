package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate { // 싱글톤 패턴(Single Tone Pattern) : 생성자 private, 필드와 메소드는 static
	private static Connection conn = null;
	
	private JDBCTemplate() {} // 기본 생성자를 접근 제한자 private로 쓰이면 객체 생성 불가능
								// 많이 쓰일거면 static 영역에 올려서 쓰이는 게 편함
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "JDBC", "JDBC");
				conn.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	// 4 : 40
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) { //같은 에러 갖고 있으면 if절에 있는 조건으로 트라이 캐치함
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) { // Statement의 후손인 PreparedStatement가 다형성 적용
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
