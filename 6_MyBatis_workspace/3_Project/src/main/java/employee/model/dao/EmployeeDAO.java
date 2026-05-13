package employee.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import employee.model.vo.Employee;

public class EmployeeDAO {
	
	

	public Employee login(SqlSession session, Employee e) {
		// 첫 번째 인자 String statement : 연결할 쿼리 명
		// 두 번째 인자 Object parameter : 쿼리에 전달할 데이터
		Employee loginUser = (Employee)session.selectOne("empMapper.login", e);
		System.out.println(loginUser);
		return loginUser;
	}

	public ArrayList<Employee> selectAll(SqlSession session) {
//		select * from v_selectemp
		ArrayList<Employee> list = (ArrayList)session.selectList("empMapper.selectAll");
		return list;
	}

	public int insertEmployee(SqlSession session, Employee e) {
//		insert into emp values(?, ?, ?, " + e.getMgrNo() + ", sysdate, ?, ?, ?, default, ?, default)
		int result = session.insert("empMapper.insertEmployee", e);
		return result;
	}

	public int updateEmployee(SqlSession session, Employee e) {
//		update emp set pwd=?, ename=?, job=?, sal=?, comm=?, deptno=?  where empno = ?
		int result = session.update("empMapper.updateEmployee", e);
		return result;
	}

	public int checkEmpNo(SqlSession session, int id) {
//		select count(*) from emp where empno = ?
		int result = (int)session.selectOne("empMapper.checkEmpNo", id);
		return result;
	}

	public int updateState(SqlSession session, HashMap<String, Object> datas) {
//		update emp set "+ col + " = ? where empno = ?
		int result = session.update("empMapper.updateState", datas);
		return result;
	}

}
