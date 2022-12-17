package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1874 { //스택 수열

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		boolean isAns = true;
		boolean[] vis = new boolean[n];
		int s1 = 0, s2 = 0;		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
	
			if(num > s1) {
				for(int j = 0; j < num - s1; j++) sb.append("+\n");
				sb.append("-\n");
				s1 = num;
			}
			else {
				if(s2 < num) s2 = s1;
				int tempN = num;
				while(vis[tempN++] && tempN < s2);
				if(tempN == s2) {
					sb.append("-\n");
					s2 = num;
				}
				else isAns = false;
			}
			
			vis[num - 1] = true;
		}
		
		if(isAns) System.out.println(sb);
		else System.out.println("NO");
	}
}