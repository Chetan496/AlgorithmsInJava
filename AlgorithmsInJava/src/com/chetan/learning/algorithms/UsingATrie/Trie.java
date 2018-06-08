package com.chetan.learning.algorithms.UsingATrie;


/*Operations on a Trie are:
 * 1. search for a string in the Trie.
 * 2. Find all the strings having a common prefix.
 * 3. Insert a New Trie Node  -- we are increasing the dictionary  
 * 4. Delete a Trie Node
 * 
 */
public class Trie {

	/*Should just point to the root Trie node */
	private TrieNode root;
	
	
	/* Trie will define the operations that can be operated on these.*/
	public Trie() {
		
		TrieNode trieNode = new TrieNode();
		root = trieNode;
	}	
	
	
	/*
	 * 1.Set a current node as a root node
	   2. Set the current letter as the first letter of the word
	   3. If the current node has already an existing reference to the current letter (through one of the elements in the “children” field), 
	then set current node to that referenced node.
	   4. Otherwise, create a new node, set the letter equal to the current letter, and also initialize the current node to this new node
	   5. Repeat step 3 until the key is traversed
	*/
	public void insert(String word) {
		
		TrieNode currentNode = this.root ;
		
		/*One or more currentNodes will be created. */
		/* Refer documentation for computeIfAbsent Java method from here: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html */
		for(int i=0; i < word.length(); i++ ) {
			
			/*we are inserting a new TrieNode with the key ch, if its not present already */
			currentNode = currentNode.getChildNodes().computeIfAbsent(word.charAt(i) ,   ch -> new TrieNode() ) ;
		}
		
		currentNode.setEndOfWord();
		
	}
	
	
	/*
	 * 
	 * 1. Get children of the root
       2. Iterate through each character of the String
       3. Check whether that character is already a part of a sub-trie. If it isn’t present anywhere in the trie, 
       then stop the search and return false
	   4. Repeat the second and the third step until there isn’t any character left in the String. If the end of the String is reached, return true
	 * 
	 */
	
	public boolean find(final String word) {
		
		TrieNode current = this.root;
		
		for(int i=0 ; i < word.length(); i++) {
			
			char ch = word.charAt(i);
			TrieNode node = current.getChildNodes().get(ch);
			if(node == null) {
				return false;
			}
			
			current = node;
		}
		
		return current.isEndOfWord();
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		trie.insert("Programming");
	    trie.insert("is");
	    trie.insert("a");
	    trie.insert("way");
	    trie.insert("of");
	    trie.insert("life");
	    
		
	}



	
}


