package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 { //스위치 켜고 끄기
	static int N, numOfStudent;
	static int[] s; //스위치
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = new int[N + 1];
		for(int i = 1; i <= N; i++) s[i] = Integer.parseInt(st.nextToken());
		
		numOfStudent = Integer.parseInt(br.readLine());
		for(int i = 0; i < numOfStudent; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(p == 1) {
				for(int j = num; j <= N; j += num) {
					s[j] = reverse(j);
				}
			}
			else {
				s[num] = reverse(num);
				if(num == 1 || num == N) continue;
				solve(num - 1, num + 1);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(s[i] + " ");
			if(i != 1 && i % 20 == 0) System.out.println();
		}
	}
	
	static void solve(int left, int right) {
		if(left == 0 || right == N + 1) return;
		if(s[left] == s[right]) {
			int temp = reverse(left);
			s[left] = temp;
			s[right] = temp;
			
			solve(left - 1, right + 1);
		}
		else return;
	}
	
	static int reverse(int index) {
		if(s[index] == 0) return 1;
		else return 0;
	}
}