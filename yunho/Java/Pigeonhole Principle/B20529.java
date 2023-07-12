package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20529 { //가장 가까운 세 사람의 심리적 거리
	static String[] mbti;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			if(N > 32) {
				br.readLine();
				sb.append(0).append("\n");
				continue;
			}
			
			mbti = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) mbti[i] = st.nextToken();
			
			sb.append(solve(N)).append("\n");
		}
		
		System.out.println(sb);
	}

	static int solve(int N) {
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int temp = 0;
					temp += calcul(mbti[i], mbti[j]);
					temp += calcul(mbti[i], mbti[k]);
					temp += calcul(mbti[j], mbti[k]);
					
					res = Math.min(res, temp);
				}
			}
		}
		
		return res;
	}
	
	static int calcul(String a, String b) {
		int res = 0;
		
		for(int i = 0; i < 4; i++) {
			if(a.charAt(i) != b.charAt(i)) res++;
		}
		
		return res;
	}
}