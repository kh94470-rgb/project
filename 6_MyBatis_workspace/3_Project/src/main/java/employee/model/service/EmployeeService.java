package employee.model.service;

import static common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import employee.model.dao.EmployeeDAO;
import employee.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDAO empDAO = new EmployeeDAO();

	public Employee login(Employee e) {
		SqlSession session = getSqlSession();
		Employee login = empDAO.login(session, e);
		session.close();
		return login;
	}

	public ArrayList<Employee> selectAll() {
		SqlSession session = getSqlSession();
		ArrayList<Employee> list = empDAO.selectAll(session);
		session.close();
		return list;
	}

	public int insertEmployee(Employee e) {
		SqlSession session = getSqlSession();
		int result = empDAO.insertEmployee(session, e);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

	public int updateEmployee(Employee e) {
		SqlSession session = getSqlSession();
		int result = empDAO.updateEmployee(session, e);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

	public int checkEmpNo(int id) {
		SqlSession session = getSqlSession();
		int result = empDAO.checkEmpNo(session, id);
		return result;
	}

	public int updateState(HashMap<String, Object> datas) {
		SqlSession session = getSqlSession();
		int result = empDAO.updateState(session, datas);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

}
