package com.kh.example.chap01_String.controller;

import java.util.StringTokenizer;

public class StringController {
	public void method1() {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		
		System.out.println("str1과 str2의 주소는 같은가? : " + (str1 == str2));
		System.out.println("str1과 str3의 주소는 같은가? : " + (str1 == str3));
		
		System.out.println("str1의 hastCod : " + str1.hashCode());
		System.out.println("str2의 hastCod : " + str2.hashCode());
		System.out.println("str3의 hastCod : " + str3.hashCode());
		
		System.out.println("str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("str3의 실주소값 : " + System.identityHashCode(str3));
		
		str2 += "funny";
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		
		
		System.out.println("str1의 hastCod : " + str1.hashCode());
		System.out.println("str2의 hastCod : " + str2.hashCode());
		System.out.println("str3의 hastCod : " + str3.hashCode());
		
		System.out.println("str1의 실주소값 : " + System.identityHashCode(str1));
		System.out.println("str2의 실주소값 : " + System.identityHashCode(str2));
		System.out.println("str3의 실주소값 : " + System.identityHashCode(str3));		
	}
	
	public void mehtod2() {
		StringBuilder builder1 = new StringBuilder();
		System.out.println("초기 builder1의 수용량 : " + builder1.capacity());
		System.out.println("builder1에 들어있는 실제 값의 길이 : " + builder1.length());
		
		System.out.println();
		
		StringBuilder builder2 = new StringBuilder(100);
		System.out.println("초기 builder2의 수용량 : " + builder2.capacity());
		System.out.println("builder2에 들어있는 실제 값의 길이 : " + builder2.length());
		
		System.out.println();
		
		StringBuilder builder3 = new StringBuilder("abc");
		System.out.println("초기 builder3의 수용량 : " + builder3.capacity());
		System.out.println("builder3에 들어있는 실제 값의 길이 : " + builder3.length());
		
		System.out.println();
		
		System.out.println("builder3 실주소 값 : " + System.identityHashCode(builder3));
//		builder3.append("abc");
//		System.out.println("abc 추가 후의 builder3 : " + builder3);
//		System.out.println("abc 추가 후의 builder3 용량 : " + builder3.capacity());
//		System.out.println("abc 추가 후의 builder3 길이 : " + builder3.length());
//		
//		builder3.append("def");
//		System.out.println("def 추가 후의 builder3 : " + builder3);
//		System.out.println("def 추가 후의 builder3 용량 : " + builder3.capacity());
//		System.out.println("def 추가 후의 builder3 길이 : " + builder3.length());
		
		builder3.append("abc").append("def");
		System.out.println("abc, def 추가 후의 builder3 : " + builder3);
		System.out.println("abc, def 추가 후의 builder3 : " + builder3.capacity());
		System.out.println("abc, def 추가 후의 builder3 : " + builder3.length());
		System.out.println("builder3 실주소 값 : " + System.identityHashCode(builder3));
		
		System.out.println();
		
		// insert : Inserts the string representation of the boolean argument into this sequence.
		builder3.insert(2, "zzz");
		System.out.println(builder3);
		
		// delete : Removes the characters in a substring of this sequence.
		// 처음 포함 , 끝 안 포함
		builder3.delete(2, 5);
		System.out.println(builder3);
		
		// reverse : Causes this character sequence to be replaced by the reverse of the sequence.
		// 앞 뒤 뒤집는 것
		builder3.reverse();
		System.out.println(builder3);
		
	}
	
	public void method3() {
		String str = "Hello World";
		
		// charAt : 인덱스 값을 char로 변환
		char ch = str.charAt(4);
		System.out.println(ch);
		
		// concat : 특정 문자열 끝에 연결
		String concatStr = str.concat("!!!");
		System.out.println(concatStr);
		str += "!!!";
		System.out.println(str);
		
		// equals : 문자열끼리 내용비교
		System.out.println(concatStr.equals(str));
		
		// subString : 문자열의 일부를 반환
		System.out.println(str.substring(6));
		System.out.println(str.substring(0, 4));
		
		// replace 문자 : 문자를 다른 문자로 대체
		System.out.println(str.replace('l', 'e'));
		
		// toUpperCase/toLowerCase : 문자열이 대문자나 소문자로 바뀜
		String up = str.toUpperCase();
		String lower = str.toLowerCase();
		System.out.println(up + " / " + lower);
		
		System.out.println(up.equals(lower));
		
		// equalsIgnoreCase : 문자열 대문자나 소문자 상관없이 문자열 비교
		System.out.println(up.equalsIgnoreCase(lower));
		
		// trim : 앞 뒤에 붙은 공백을 제거함 (사이는 안됨)
		String str2 = "    Java";
		String str3 = "Java    ";
		String str4 = "    Ja  va   ";
		System.out.println(str2.trim());
		System.out.println(str3.trim());
		System.out.println(str4.trim());
		
		// split : 주어진 형식을 문자열을 분리
		String splitStr = "Java, Oracle, JDBC, Front, Server, Framework";
		String[] arr = splitStr.split(", ");
		System.out.println(arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// StringTokenizer : 문자열 분리
		StringTokenizer st = new StringTokenizer(splitStr, ", ");
		System.out.println("분리된 문자열 개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("분리된 문자열 개수 : " + st.countTokens());
		
		String splitStr2 = "Apple,Banana-Cream*Dessert#Egg Fruit";
//		String[] arr2 = splitStr2.split(",-*# ");
		String[] arr2 = splitStr2.split(",|-|\\*|#| ");
		System.out.println("arr2.length : " + arr2.length);
		for(int i = 0; i < arr2.length; i ++) {
			System.out.println(arr2[i]);
		}
		
		StringTokenizer st2 = new StringTokenizer(splitStr2, ",-*# ");
		System.out.println("분리된 문자열 개수 : " + st2.countTokens());
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
