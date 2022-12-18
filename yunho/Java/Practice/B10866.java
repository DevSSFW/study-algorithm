package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B10866 { //µ¦

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> D = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = 0;			
			String s = st.nextToken();
			if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
			Integer ans;
			
			if(s.equals("push_front")) D.addFirst(x);
			else if(s.equals("push_back")) D.addLast(x);
			else if(s.equals("pop_front")) {
				if((ans = D.pollFirst()) == null) System.out.println(-1);
				else System.out.println(ans);
			}
			else if(s.equals("pop_back")) {
				if((ans = D.pollLast()) == null) System.out.println(-1);
				else System.out.println(ans);
			}
			else if(s.equals("size")) System.out.println(D.size());
			else if(s.equals("empty")) {
				if(D.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(s.equals("front")) {
				if((ans = D.peekFirst()) == null) System.out.println(-1);
				else System.out.println(ans);
			}
			else if(s.equals("back")) {
				if((ans = D.peekLast()) == null) System.out.println(-1);
				else System.out.println(ans);
			}
		}
	}
}