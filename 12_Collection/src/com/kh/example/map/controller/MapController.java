package com.kh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.list.model.compare.ListComparator;
import com.kh.example.map.model.vo.Snack;

public class MapController {
	public void doMap() {
		HashMap<String, Snack> map = new HashMap<>(); // 타입 추론
		
		Snack swk = map.put("새우깡", new Snack("짠맛", 1500));
		Snack dij = map.put("다이제", new Snack("단맛", 2500));
		Snack potato = map.put("포테이토칩", new Snack("짠맛", 1500));
		Snack gsm = map.put("고소미", new Snack("고소한맛", 1000));
		
		System.out.println("map : " + map);
		System.out.println(swk + ", " + dij + ", " + potato + ", " + gsm);
	
		Snack swk2 = map.put("새우깡", new Snack("매운맛", 1500));
		System.out.println("map : " + map);
		System.out.println(swk2);
	
		System.out.println(map.containsKey("새우깡"));
		System.out.println(map.containsKey("홈런볼"));
		System.out.println(map.containsValue(new Snack("단맛", 2500)));
		
		System.out.println(map.get("새우깡"));
		System.out.println(map.get("홈런볼"));
		
		System.out.println(map.values());
		
		System.out.println();
		
		System.out.println("=== Map element에 접근하기 ===");
		System.out.println("1. keySet()");
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			Snack snack = map.get(key);
			System.out.println(key + " = " + snack);
		}
		
		for(String key : set1) {
			System.out.printf("%s, %s\n", key, map.get(key));
		}
		
		System.out.println("2. entrySet()");
		Set<Entry<String, Snack>> set2 = map.entrySet();
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) {
			Entry<String, Snack> entry = it2.next();
			String key = entry.getKey();
			Snack value = entry.getValue();
			System.out.println(key + "&" + value);
		}
		
		System.out.println();
		
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>(map);
		System.out.println("map2 : " + map2);
		
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new ListComparator());
		map3.putAll(map);
		System.out.println("map3 : " + map3);
		
		System.out.println(map3.size());
		
		Snack remove1 = map3.remove("다이제");
		System.out.println("map3 : " + map3);
		System.out.println(remove1);
		Snack remove2 = map3.remove("홈런볼");
		System.out.println("map3 : " + map3);
		System.out.println(remove2);
		
		System.out.println(map3.remove("고소미", new Snack("고소한맛", 1000)));
		System.out.println("mp3 : " + map3);
		System.out.println(map3.remove("홈런볼", new Snack("단맛", 3000)));
		System.out.println("map3 : " + map3);
		
		System.out.println(map3.isEmpty());
		map3.clear();
		System.out.println("map3 : " + map3);
		System.out.println(map3.isEmpty());
	}
	
	public void doProperties() {
		Properties prop = new Properties();
		System.out.println(prop.setProperty("채소", "오이"));
		System.out.println(prop.setProperty("과일", "사과"));
		System.out.println(prop.setProperty("간식", "젤리"));
		System.out.println(prop.setProperty("채소", "피망"));
		System.out.println(prop.setProperty("육류", "삼겹살"));
		System.out.println(prop.setProperty("어류", "고등어"));
		System.out.println(prop);

		System.out.println(prop.getProperty("채소"));
		System.out.println(prop.getProperty("견과"));
		System.out.println(prop.getProperty("채소", "땅콩"));
		System.out.println(prop.getProperty("견과", "땅콩"));
		
		Enumeration<?> en = prop.propertyNames();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			String value = prop.getProperty(key);
		}
	}
	
	public void filesave() {
//		try(FileOutputStream fos = new FileOutputStream("test.properties");) {
		try(FileOutputStream fos = new FileOutputStream("test.xml");){
			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("author", "Mr. HONG");
			prop.setProperty("publisher", "KH Academy");
			prop.setProperty("price", "15000");
			
//			prop.store(fos, "20260212, Properties File Test");
			prop.storeToXML(fos, "20260212, XML File Test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileOpen() {
//		try(FileInputStream fis = new FileInputStream("test.properties");) {
		try(FileInputStream fis = new FileInputStream("test.xml");) {
			Properties prop = new Properties();
			System.out.println(prop);
			
//			prop.load(fis);
			prop.loadFromXML(fis);
			System.out.println(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
