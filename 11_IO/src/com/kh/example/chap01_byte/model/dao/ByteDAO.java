package com.kh.example.chap01_byte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		FileInputStream fis = null;
		try {
			// 파일로부터 byte단위로 데이터를 읽어올 수 있는 스트림
			fis = new FileInputStream("a_byte.txt");
			
			// 1. byte배열에 저장한 후 출력
			// 1-1. byte배열 직접 생성
//			File f = new File("a_byte.txt");
//			long size = f.length();
//			byte[] bArr = new byte[(int)size];
//			byte[] bArr = new byte[(int)new File("a_byte.txt").length()];
//			fis.read(bArr);
//			for(int i = 0; i < bArr.length; i++) {
//				System.out.print((char)bArr[i] + " ");
//			}
			// 1-2. byte배열 반환 받기
//			byte[] bArr = fis.readAllBytes();
//			for(int i = 0; i < bArr.length; i++) {
//				System.out.print((char)bArr[i] + " ");
//			}
			// 2. byte배열 사용하지 않고 바로 하나씩 읽어 출력
//			while(fis.read() != -1) {
//				System.out.print((char)fis.read() + " ");
//			}
//			값이 다 안 나오는 이유 : fis.read에서 조건이 만족하면 시스템 안에 있는
//			fis.read는 다음 문자가 읽히면서 -1이 나올 때까지 계속 반복된다
			int value;
			while((value=fis.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileOpen2() {
		try(FileInputStream fis = new FileInputStream("a_byte.txt");) {
			
			int value;
			while((value=fis.read()) != -1) {
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void filesave2() {
		try(FileOutputStream fos = new FileOutputStream("a_byte.txt");) {
			
			fos.write(97);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileSave() {
		FileOutputStream fos = null;
		try {
			// 파일에 byte단위로 데이터를 작성하는 스트림
//			FileOutputStream fos = new FileOutputStream("a_byte.txt", true);
			fos = new FileOutputStream("a_byte.txt");
			fos.write(97);
			
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			fos.write(bArr);
			
			fos.write(bArr, 1, 3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
