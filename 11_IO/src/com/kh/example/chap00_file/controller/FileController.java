package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {
		try {
			File f1 = new File("test.txt");
			f1.createNewFile();
			
			File f2 = new File("c:/test/test.txt");
			f2.createNewFile();
			
			File f3 = new File("c:\\temp1\\temp2");
			f3.mkdirs();
//			File f4 = new File("c:\\temp1\\temp2\\test.txt");
			File f4 = new File(f3, "test.txt");
			f4.createNewFile();
			f4.delete();
			
			System.out.println(f2.exists());
			System.out.println(f3.exists());
			System.out.println(f4.exists());
			System.out.println(f3.isFile());
			
			System.out.println("파일 명 : " + f1.getName());
			System.out.println("저장절대경로 : " + f1.getAbsolutePath());
			System.out.println("저장상대경로 : " + f1.getPath());
			System.out.println("파일용량 : " + f1.length());
			System.out.println("f4 상위 폴더 : " + f4.getParent());
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
