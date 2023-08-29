package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B19585 { //Àü¼³
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < C; i++) trie.insert(br.readLine());
		
		HashSet<String> nickname = new HashSet<>();
		for(int i = 0; i < N; i++) nickname.add(br.readLine());
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			boolean isYes = false;
			
			String team = br.readLine();
			ArrayList<Integer> list_color = trie.contain(team);
		
			for(int index : list_color) {
				if(nickname.contains(team.substring(index))) {
					isYes = true;
					break;
				}
			}
				
			if(isYes) sb.append("Yes\n");
			else sb.append("No\n");
		}
		
		System.out.println(sb);
	}

	static class Trie {
		TrieNode Node = new TrieNode();
		
		void insert(String str) {
			TrieNode node = this.Node;
			
			for(int i = 0; i < str.length(); i++) {
				int index = str.charAt(i) - 'a';
				if(node.childNode[index] == null) node.childNode[index] = new TrieNode();
				node = node.childNode[index];
			}
			node.lastNode = true;
		}
		
		ArrayList<Integer> contain(String str) {
			ArrayList<Integer> res = new ArrayList<>();
			TrieNode node = this.Node;
			
			for(int i = 0; i < str.length(); i++) {
				int index = str.charAt(i) - 'a';
				node = node.childNode[index];
				
				if(node == null) return res;
				if(node.lastNode) res.add(i + 1);
			}
				
			return res;
		}
	}
	
	static class TrieNode {
		TrieNode[] childNode = new TrieNode[26];
		boolean lastNode;
	}
}