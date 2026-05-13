package com.kh.example.chap03_user.controller;

import com.kh.example.chap03_user.model.exception.MyException;

public class UserExceptionController {
	public void method() throws MyException {
		throw new MyException();
	}

}
