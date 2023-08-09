package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 { //연산자 끼워넣기
	static int N, min, max;
	static int[] num, oper; //oper[0] : +, oper[1] : -, oper[2] : *, oper[3] : /
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) oper[i] = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		backtracking(1, num[0]);
	
		System.out.println(max + "\n" + min);
	}

	//count starts from one.
	//res starts from num[0].
	static void backtracking(int count, int res) {
		if(count == N) {
			min = Math.min(min, res);
			max = Math.max(max, res);

			return;
		}
		
		for(int j = 0; j < 4; j++) {
			if(oper[j] > 0) {
				int temp = calculate(res, num[count], j);
				
				oper[j]--;
				backtracking(count + 1, temp);
				oper[j]++;
			}
		}
		
	}
	
	static int calculate(int a, int b, int o) {
		if(o == 0) return a + b;
		else if(o == 1) return a - b;
		else if(o == 2) return a * b;
		else return a / b;
	}
}