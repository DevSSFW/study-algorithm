package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B5670 { //ÈÞ´ëÆù ÀÚÆÇ
	static double count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String T;
		while((T = br.readLine()) != null) {
			count = 0;
			
			int N = Integer.parseInt(T);
			
			Trie trie = new Trie();
			for(int i = 0; i < N; i++) trie.insert(br.readLine());
			trie.search();
			
			count /= N;
			sb.append(String.format("%.2f", count)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static class Trie {
		private TrieNode Node = new TrieNode();
		
		void insert(String str) {
			TrieNode node = this.Node;
	
			for(int i = 0; i < str.length(); i++) {
				node = node.childNode.computeIfAbsent(str.charAt(i), key -> new TrieNode());
				node.count++;
			}
			node.lastNode = true;
		}
		
		private void search(TrieNode node) {
			if(node.lastNode) {
				for(Character word : node.childNode.keySet()) {
					TrieNode tempNode = node.childNode.get(word);
					search(tempNode);
					count += tempNode.count;
				}
				
				return;
			}
			
			if(node.childNode.size() == 1) {
				for(Character word : node.childNode.keySet()) {
					TrieNode tempNode = node.childNode.get(word);
					search(tempNode);
				}
			}
			else {
				for(Character word : node.childNode.keySet()) {
					TrieNode tempNode = node.childNode.get(word);
					search(tempNode);
					count += tempNode.count;
				}
			}
		}
		
		void search() {
			for(Character word : Node.childNode.keySet()) {
				TrieNode tempNode = Node.childNode.get(word);
				search(tempNode);
				count += tempNode.count;
			}
		}
	}
	
	static class TrieNode {
		private HashMap<Character, TrieNode> childNode;
		boolean lastNode;
		int count;
		
		TrieNode() {
			childNode = new HashMap<>();
		}
	}
}