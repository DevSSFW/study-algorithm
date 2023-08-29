package Practice;

public class B13505 { //µÎ ¼ö XOR
	static final int max_height = 30;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N = read();
		
		int max = 0;
		Trie trie = new Trie();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = read();
			trie.insert(A[i]);
		}
		
		for(int i = 0; i < N; i++) max = Math.max(max, trie.search(A[i]));
		System.out.println(max);
	}

	static class Trie {
		TrieNode Node = new TrieNode();
		
		void insert(int num) {
			TrieNode node = this.Node;
			
			for(int i = max_height; i >= 0; i--) {
				int n = (num & (1 << i)) == 0 ? 0 : 1;
				
				if(node.childNode[n] == null) node.childNode[n] = new TrieNode();
				node = node.childNode[n];
			}
		}
		
		int search(int num) {
			int res = 0;
			TrieNode node = this.Node;
			
			for(int i = max_height; i >= 0; i--) {
				int o = num & (1 << i);
				int n = o == 0 ? 1 : 0;
				
				if(node.childNode[n] == null) n = o == 0 ? 0 : 1;
				else res += 1 << i;
			
				node = node.childNode[n];
			}
			
			return res;
		}
	}
	
	static class TrieNode {
		TrieNode[] childNode = new TrieNode[2];
	}
	
	static int read() throws Exception {
		int c, n = System.in.read();
		
		if(n == 10) n = System.in.read();
		n &= 15;
		
		while((c = System.in.read()) >= 48) n = (n << 3) + (n << 1) + (c & 15);
		
		return n;
	}
}