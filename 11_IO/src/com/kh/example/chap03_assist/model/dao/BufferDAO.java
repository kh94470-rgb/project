package com.kh.example.chap03_assist.model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;

public class BufferDAO {
	public void inputByte() {
		// 파일에 있는 데이터를 바이트 기반으로 빠르게 읽어오고 싶다
		// File				Stream				Input
		//								Buffered(InputStream)
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream("c_buffer.txt");
			bis = new BufferedInputStream(fis);
			
			byte[] bArr = bis.readAllBytes();
			System.out.println(Arrays.toString(bArr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void outputByte() {
		// 파일에 바이트 기반으로 데이터를 빠르게 쓰고 싶다
		// File		Stream					Output
		//							Buffered(OutputStream)
		try(FileOutputStream fos = new FileOutputStream("c_buffer.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			bos.write(65);
			byte[] bArr = {66, 67, 68, 69};
			bos.write(bArr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	BufferedWriter bw = null;
	public void outputChar() {
		// 파일에 문자 기반으로 데이터를 빠르게 쓰고 싶다
		// File 						Writer
		//							Buffered(Writer)
		try {
//			FileWriter fw = new FileWriter("c_buffer.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
			bw = new BufferedWriter(new FileWriter("c_buffer.txt", true));
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("건강하세요\n");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void inputchar() {
		// 파일에 문자 기반으로 데이터를 빠르게 읽고 싶다
		// File							Reader
		//							Buffered(Reader)
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));) {
			// while문 한 줄씩 읽어오기(readLine())
			String value;
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void scanner() {
		// System.in / System.out = 표준입출력(바이트 기반)
		// 바이트 기반 -> 문자 기반 보조스트림 사용 : InputStreamReader
		
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("문자열 입력 : ");
			String value =br.readLine();
			System.out.println("문자열 길이 : " + value.length());
			
			System.out.print("정수 하나 입력 : ");
			String strNum = br.readLine();
			int num = Integer.parseInt(strNum);
			System.out.println("이 숫자는 홀수입니까? : " + (num % 2 != 0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
