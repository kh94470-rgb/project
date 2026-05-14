package kh.springboot.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import kh.springboot.member.model.mapper.MemberMapper;
import kh.springboot.member.model.vo.Member;
import kh.springboot.member.model.vo.TodoList;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper mapper;
	
	public Member login(Member m) {
		return mapper.login(m);
	}

	public int insertMember(Member m) {
		return mapper.insertMember(m);
	}

	public ArrayList<HashMap<String, Object>> selectMyList(String id) {
		return mapper.selectMyList(id);
	}

	public int updateMember(Member m) {
		return mapper.updateMember(m);
	}

	public int updatePassword(Member m) {
		// TODO Auto-generated method stub
		return mapper.updatePassword(m);
	}



	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return mapper.deleteMember(id);
	}

//	public int checkId(String id) {
//		return mapper.checkId(id);
//	}
//
//	public int checkNickName(String nickName) {
//		return mapper.checkNickName(nickName);
//	}

	public int checkValue(HashMap<String, String> map) {
		return mapper.checkValue(map);
	}

	public int updateProfile(Member m) {
		return mapper.updateProfile(m);
	}

	public ArrayList<TodoList> selectTodoList(String id) {
		return mapper.selectTodoList(id);
	}

	public int insertTodo(TodoList tdl) {
		return mapper.insertTodo(tdl);
	}

	public int updateTodo(TodoList tdl) {
		return mapper.updateTodo(tdl);
	}

	public int deleteTodo(int num) {
		return mapper.deleteTodo(num);
	}






}
