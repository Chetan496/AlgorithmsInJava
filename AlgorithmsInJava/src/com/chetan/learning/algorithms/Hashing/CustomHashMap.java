package com.chetan.learning.algorithms.Hashing;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author Chetan
 *
 *The below is an elementary but functional implementation of HashMap from first principles.
 *Only String key, value pairs are supported.
 *Also - it uses a rudimentary hash function and hash collision mechanism.
 */


//The Hashmap allows adding a (key, value) pair.
//We need to support following methods:
//get(KeyName),  put(keyName, value).. using keyName 
//lets have both key and value as String

//lets allocate an array. for every key our hashmap will have an internal hashcode generation mechanism
//a hash function. Based on hashfunction the index is calculated..
//let us also have an internal ArrayList

public class CustomHashMap {

	private class HashMapNode {

		private String key;
		private String value;

		public HashMapNode(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	private class HashMapValueStore {

		private LinkedList<HashMapNode> linkListOfHashMapModes;

		public HashMapValueStore() {
			linkListOfHashMapModes = new LinkedList<HashMapNode>();
		}

		public LinkedList<HashMapNode> getLinkListOfHashMapModes() {
			return linkListOfHashMapModes;
		}

		public void appendNewValue(final HashMapNode hashNode) {

			this.linkListOfHashMapModes.add(hashNode);

		}

	}

	private ArrayList<HashMapValueStore> valueStore;

	public CustomHashMap() {

		valueStore = new ArrayList<HashMapValueStore>(Collections.nCopies(31, null));

	}

	private int computeHashCode(final String key) {

		int stringHashCode = 0;

		for (int i = 0; i < key.length(); i++) {

			char c = key.charAt(i);
			stringHashCode += c;

		}

		return stringHashCode % 31;
	}

	public void put(final String key, final String value) {

		/* TODO: validate if the key is empty */
		int hashCode = computeHashCode(key);

		/* lets detect a collision.. also need to handle collision */
		HashMapValueStore existingHashMapValueStore = valueStore.get(hashCode);
		if (existingHashMapValueStore != null) {
			System.out.println("detected a hash collision");
			existingHashMapValueStore.appendNewValue(new HashMapNode(key, value));
		} else {

			System.out.println("No Hash collision");
			HashMapValueStore newMapValueStore = new HashMapValueStore();
			newMapValueStore.appendNewValue(new HashMapNode(key, value));
			valueStore.set(hashCode, newMapValueStore);

		}

	}

	public String get(final String key) {
		/* TODO: validate if the key is empty */
		int hashCode = computeHashCode(key);
		LinkedList<HashMapNode> linkListOfHashMapModes = valueStore.get(hashCode).getLinkListOfHashMapModes();

		// now you loop through this link list and return the value matching the key.
		for (HashMapNode hashMapNode : linkListOfHashMapModes) {

			if (hashMapNode.getKey().equals(key)) {
				return hashMapNode.getValue();
			}
		}

		return null;

	}

	/* Implement a way to get all keys */
	public List<String> getAllKeys() {

		List<String> keys = new ArrayList<String>();

		for (HashMapValueStore hashMapValueStore : valueStore) {

			if (hashMapValueStore != null) {

				LinkedList<HashMapNode> nodes = hashMapValueStore.getLinkListOfHashMapModes();
				for (HashMapNode hashMapNode : nodes) {
					keys.add(hashMapNode.getKey());
				}
			}
		}

		return keys;
	}

	/* IMplement a way to get all values */
	public List<String> getAllValues() {

		List<String> values = new ArrayList<String>();

		for (HashMapValueStore hashMapValueStore : valueStore) {

			if (hashMapValueStore != null) {

				LinkedList<HashMapNode> nodes = hashMapValueStore.getLinkListOfHashMapModes();
				for (HashMapNode hashMapNode : nodes) {
					values.add(hashMapNode.getValue());
				}
			}
		}

		return values;
	}

	public List<Map.Entry<String, String>> getKeyValuePairs() {

		List<Map.Entry<String, String>> keyValues = new ArrayList<Map.Entry<String, String>>();
		for (HashMapValueStore hashMapValueStore : valueStore) {

			if (hashMapValueStore != null) {

				LinkedList<HashMapNode> nodes = hashMapValueStore.getLinkListOfHashMapModes();
				for (HashMapNode hashMapNode : nodes) {
					
					keyValues.add(new AbstractMap.SimpleEntry<>(hashMapNode.getKey(), hashMapNode.getValue()));
					
				}
			}
		}

		return keyValues;
	}
	
	
	
	

}
