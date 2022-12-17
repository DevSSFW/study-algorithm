package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10773 { //Á¦·Î

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int ans = 0;
		Stack<Integer> S = new Stack<>();
		for(int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) ans -= S.pop();
			else {
				S.push(num);
				ans += num;
			}
		}
		
		System.out.println(ans);
	}
}