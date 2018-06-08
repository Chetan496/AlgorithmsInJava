package com.chetan.learning.algorithms.Hashing;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestCustomHashmap {

	
	
	
	public static void main(String[] args) {
		
		
		CustomHashMap myhashMap = new CustomHashMap() ;
		myhashMap.put("apple", "fruit");
		myhashMap.put("spinach", "vegetable");
		myhashMap.put("chicken", "animal");
		myhashMap.put("nekcihc", "animal");
		
		System.out.println("Just added some data in the hashmap");
		
		
		String value =  myhashMap.get("spinach");
		
		System.out.println("Value for key spinach is  "+value);
		
		System.out.println("Printing all keys");
		
		List<String> keys = myhashMap.getAllKeys() ;
		for (String string : keys) {
			System.out.println(string);
		}
		
		System.out.println("Printing all values");
		
		List<String> values = myhashMap.getAllValues() ;
		for (String string : values) {
			System.out.println(string);
		}
		
		
		System.out.println("Printing all key value pairs");
		List<Map.Entry<String, String>> keyValues = myhashMap.getKeyValuePairs();
		for (Entry<String, String> entry : keyValues) {
			
			System.out.println("Key: "+entry.getKey() + "  Value: "+entry.getValue());
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
