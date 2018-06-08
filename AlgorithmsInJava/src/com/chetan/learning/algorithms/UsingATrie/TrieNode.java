package com.chetan.learning.algorithms.UsingATrie;

import java.util.HashMap;


/*Operations on a Trie are:
 * 1. search for a string in the Trie.
 * 2. Find all the strings having a common prefix.
 * 3. Insert a New Trie Node  -- we are increasing the dictionary  
 * 4. Delete a Trie Node
 * 
 */

public class TrieNode {
	
	private boolean isWord;
	private String nodeContent;
	private HashMap<Character, TrieNode> childNodes;
	
	
	public TrieNode() {
		this.isWord = false;
		childNodes = new HashMap<Character, TrieNode>(); 
	}
	
	public String getNodeContent() {
		return nodeContent;
	}
	
	public void setNodeContent(String nodeContent) {
		this.nodeContent = nodeContent;
	}
	
	public boolean isEndOfWord() {
		return isWord;
	}
	
	public void addChildNode(String nodeContent) {
		
		
		
	}
	
	
	public HashMap<Character, TrieNode> getChildNodes() {
		
		return childNodes;
		
	}
	
	public void setEndOfWord() {
		this.isWord = true;
	}
	
	
	
}
