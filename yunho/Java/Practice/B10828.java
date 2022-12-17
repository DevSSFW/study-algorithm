package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 { //Ω∫≈√

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> S = new Stack<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int n = -1;
			if(st.hasMoreTokens()) n = Integer.parseInt(st.nextToken());
			
			if(s.equals("push")) S.push(n);
			else if(s.equals("pop")) {
				if(S.size() > 0) System.out.println(S.pop());
				else System.out.println(-1);
			}
			else if(s.equals("size")) System.out.println(S.size());
			else if(s.equals("empty")) {
				if(S.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(s.equals("top")) {
				if(S.size() > 0) System.out.println(S.peek());
				else System.out.println(-1);
			}
		}
	}
}