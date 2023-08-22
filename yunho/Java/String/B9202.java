package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B9202 { //Boggle
	static int W, score, found_count;
	static String longest_word;
	static char[][] board;
	static boolean[][] vis;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		W = Integer.parseInt(br.readLine());
		String[] words = new String[W];
		for(int i = 0; i < W; i++) words[i] = br.readLine();
		br.readLine();
		
		int B = -1;
		while(B != 0) {
			if(B == -1) B = Integer.parseInt(br.readLine());
			else br.readLine();
			B--;
			
			score = 0;
			longest_word = "";
			found_count = 0;
			
			Trie trie = new Trie();
			for(int i = 0; i < W; i++) trie.insert(words[i]);

			vis = new boolean[4][4];
			board = new char[4][4];
			for(int i = 0; i < 4; i++) {
				String str = br.readLine();
				
				for(int j = 0; j < 4; j++) board[i][j] = str.charAt(j);
			}

			trie.search();
			sb.append(score).append(' ').append(longest_word).append(' ').append(found_count).append('\n');
		}
		
		System.out.println(sb);
	}

	static class Trie {
		private TrieNode Node = new TrieNode();
		private int[] dx = {1, -1, 0, 0, 1, 1, -1, -1}, dy = {0, 0, 1, -1, 1, -1, 1, -1};
		
		void insert(String str) {
			TrieNode node = this.Node;
			
			for(int i = 0; i < str.length(); i++) node = node.childNode.computeIfAbsent(str.charAt(i), key -> new TrieNode());
			node.lastNode = true;
		}
		
		private void search(TrieNode node, int row, int col, String str) {
			node = node.childNode.get(board[row][col]);
			if(node == null) return;
			
			if(node.lastNode) {
				update(str);
				delete(Node, str, 0);
			}
			
			for(int i = 0; i < 8; i++) {
				int r = row + dx[i];
				int c = col + dy[i];
				
				if(r < 0 || c < 0 || r >= 4 || c >= 4 || vis[r][c]) continue;
				
				vis[r][c] = true;
				search(node, r, c, str + board[r][c]);
				vis[r][c] = false;
			}
		}
		
		void search() {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					vis[i][j] = true;
					search(Node, i, j, "" + board[i][j]);
					vis[i][j] = false;
				}
			}
		}
		
		private void update(String str) {
			found_count++;
			
			if(longest_word.length() < str.length()) longest_word = str;
			else if(longest_word.length() == str.length() && longest_word.compareTo(str) > 0) longest_word = str;
			
			if(str.length() == 8) score += 11;
			else if(str.length() == 7) score += 5;
			else if(str.length() == 6) score += 3;
			else if(str.length() == 5) score += 2;
			else if(str.length() >= 3) score += 1;
		}
		
		private void delete(TrieNode node, String str, int index) {
			if(node.lastNode) {
				node.lastNode = false;
				
				return;
			}
			
			TrieNode tempNode = node;
			node = node.childNode.get(str.charAt(index));
			if(node == null) throw new Error("Can't Find " + str.charAt(index) + " in Trie");
			
			delete(node, str, index + 1);
			
			if(node.childNode.size() == 0 && !node.lastNode) tempNode.childNode.remove(str.charAt(index));
		}
	}
	
	static class TrieNode {
		HashMap<Character, TrieNode> childNode = new HashMap<>();
		boolean lastNode;
	}
}