package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7579 { //앱

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //앱 개수
		int M = Integer.parseInt(st.nextToken()); //필요한 바이트
		int ans = 10000;
		
		int[] A = new int[N]; //활성화 되어 있는 앱 당 사용중인 메모리의 바이트 수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int[] C = new int[N]; // 비활성화 했을 경우의 비용
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) C[i] = Integer.parseInt(st.nextToken());
		
		int[] price = new int[10001];
		for(int i = 0; i < N; i++) {
			
			//ans보다 큰 값은 어차피 답이 될 수 없기 때문에 j를 ans부터 시작해준다.
			for(int j = ans; j >= C[i]; j--) {
				price[j] = Math.max(price[j - C[i]] + A[i], price[j]);
				
				if(price[j] >= M) ans = Math.min(ans, j);
			}
		}
		
		System.out.println(ans);
	}
}