package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B14725 { //개미굴
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PriorityQueue<HashMap<String, TrieNode>> childNode;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for(int i = 0; i < N; i++) trie.insert(br.readLine());
		
		trie.search();
		System.out.println(sb);
	}
	
	static class Trie {
		TrieNode Node = new TrieNode();
		
		void insert(String str) {
			TrieNode node = this.Node;
			
			StringTokenizer st = new StringTokenizer(str);
			int K = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < K; i++) node = node.childNode.computeIfAbsent(st.nextToken(), key -> new TrieNode());
		}
		
		void append_to_sb(String food, int count) {
			//-- 저장하는 StringBuilder
			StringBuilder temp = new StringBuilder();

			for(int i = 0; i < count; i++) temp.append("--");
			sb.append(temp).append(food).append("\n");
		}
		
		
		private void search(TrieNode node, int count) {
			for(String food : node.childNode.keySet()) {
				append_to_sb(food, count);
				
				TrieNode tempNode = node.childNode.get(food);
				search(tempNode, count + 1);
			}
		}
		
		void search() {
			search(Node, 0);
		}
	}
	
	static class TrieNode {
		TreeMap<String, TrieNode> childNode;

		TrieNode() {
			childNode = new TreeMap<>();
		}
	}
}