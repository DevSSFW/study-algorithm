package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10845 { //ť

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int index = 0 , pop = 0;
		int[] Q = new int[N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			
			if(s.charAt(0) == 'p') {
				if(s.charAt(1) == 'u') Q[index++] = Integer.parseInt(s.substring(5));
				else {
					if(index - pop == 0) System.out.println(-1);
					else System.out.println(Q[pop++]);
				}
			}
			else if(s.charAt(0) == 's') System.out.println(index - pop);
			else if(s.charAt(0) == 'e') {
				if(index - pop == 0) System.out.println(1);
				else System.out.println(0);
			}
			else if(s.charAt(0) == 'f') {
				if(index - pop == 0) System.out.println(-1);
				else System.out.println(Q[pop]);
			}
			else if(s.charAt(0) == 'b') {
				if(index - pop == 0) System.out.println(-1);
				else System.out.println(Q[index - 1]);
			}
		}
	}
}