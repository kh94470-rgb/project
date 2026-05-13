package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Employee;

public class EmployeeDAO {

	public ArrayList<Employee> selectAll() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Employee> list = new ArrayList<Employee>(); 
		
		// 0. Class.forName()을 통한 Driver 등록 (필수 x, 권장)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//1. DriverManager.getConnection()을 통한 계정 연결(어떤 컴퓨터에 무슨 계정인지)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SCOTT", "SCOTT");
			//System.out.println(conn);
			
			//2. 쿼리 작성
			String query = "select * from emp";
			
			//3. Connection을 통한 Statement객체 생성
			stmt = conn.createStatement();
			
			//4. 메소드를 통한 쿼리 전달 및 반환 값 받아오기
			rset = stmt.executeQuery(query);
			
			//행의 개수가 여러 개일 때 while문,  행의 개수가 0 또는 1이면 if문 쓰는 게 낫다? 
			while(rset.next()) {
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ename");// 앞에 있는 변수명은 머든 상관없는데 뒤에는 resultset에 컬럼명을 따라야 함
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				Employee emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public Employee selectEmployee(int empNo) {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Employee emp = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "SCOTT");
			
			//String query = "select * from emp where empno = " + empNo; //완성형 커리(Statement)
			//stmt = conn.createStatement();
			//rset = stmt.executeQuery(query); // 행의 개수는 0개 또는 1개여서 if도 가능 // 완성형이어서(검수 안 해도 돼서) 보낼 때 쿼리를 담아서 보냄
			
			// 3 : 00
			String query = "select * from emp where empno = ?"; // 미완성형 커리(PreparedStatement)
			pstmt = conn.prepareStatement(query); // 미완성형은(검수 해야되니깐) 객체 생성할 때 쿼리를 담음
			pstmt.setInt(1, empNo); // 1번째 인자 : 몇 번째부터 시작할까(1부터 시작) , 2번째 인자 : 그 위치 홀더에 무슨 값을 집어넣을까
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				//int eno = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				//stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	public int insertEmployee(Employee emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SCOTT", "SCOTT");
			conn.setAutoCommit(false); // 자동 Commit 끔
			
			//insert into emp values(9999, 'rose', 'teacher', 7788, sysdate, 5000, 100, 10)
//			String query = "insert into emp values("+ emp.getEmpNo() +", '"+  emp.getEmpName() +"', '"+ emp.getJob() +"'," + emp.getMgr() +", sysdate, " + emp.getSal() +", "+ emp.getComm() + ", " + emp.getDeptNo() + ")";
//			System.out.println(query); //값이 많으면 PreparedStatement 쓰자
			
			String query = "insert into emp values(?, ?, ?, ?, sysdate, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updateEmployee(Employee emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
//			String query = "update emp set job ='" + emp.getJob() + "', sal =" + emp.getSal() + ", comm =" + emp.getComm() + "where empno= " + emp.getEmpNo(); 
			String query = "update emp set job = ?, sal = ?, comm = ? where empNo = ?";
			
			pstmt = conn.prepareStatement(query); 
			pstmt.setString(1, emp.getJob());
			pstmt.setInt(2, emp.getSal());
			pstmt.setInt(3, emp.getComm());
			pstmt.setInt(4, emp.getEmpNo());
			
					
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteEmployee(int empNo) {
		Connection conn = null;
		Statement stmt = null;
		
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query = "delete from emp where empno = " + empNo;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
