package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24313 { //알고리즘 수업 - 점근적 표기 1
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A1 = Integer.parseInt(st.nextToken()), A2 = Integer.parseInt(st.nextToken()); //정수
		int C = Integer.parseInt(br.readLine()), N0 = Integer.parseInt(br.readLine()); //양의 정수
	
		int n = C - A1; //n
		if(n < 0) {
			System.out.println(0);
			return ;
		}
		if(n == 0) {
			if(A2 <= 0) System.out.println(1);
			else System.out.println(0);
			return ;
		}
		
		if(A2 % n != 0) A2 = A2 / n + 1;
		else A2 = A2 / n;
		
		if(N0 >= A2) System.out.println(1);
		else System.out.println(0);
	}
}