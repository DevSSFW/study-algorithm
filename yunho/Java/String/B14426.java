package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14426 { //접두사 찾기
	static int count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < N; i++) trie.insert(br.readLine());
		for(int i = 0; i < M; i++) trie.contain(br.readLine());
		
		System.out.println(count);
	}

	static class Trie {
		TrieNode Node = new TrieNode();
		
		void insert(String str) {
			TrieNode node = this.Node;
			
			for(int i = 0; i < str.length(); i++) {
				int alpha = str.charAt(i) - 'a';
				
				if(node.childNode[alpha] == null) node.childNode[alpha] = new TrieNode();
				node = node.childNode[alpha];
			}
		}
		
		void contain(String str) {
			TrieNode node = this.Node;
			
			for(int i = 0; i < str.length(); i++) {
				int alpha = str.charAt(i) - 'a';
				
				if(node.childNode[alpha] == null) return;
				node = node.childNode[alpha];
			}
			
			count++;
		}
	}
	
	static class TrieNode {
		TrieNode[] childNode = new TrieNode[26];
	}
}