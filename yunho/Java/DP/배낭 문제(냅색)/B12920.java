package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//V : 무게, C : 만족도 ,K : 개수
public class B12920 { //평범한 배낭 2
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ArrayList<HashMap<Integer, Integer>> stuff = new ArrayList<>(); //index : 무게, key : 만족도, value : 개수
		int[] dp = new int[10001];
		
		//무게 0부터 10000까지 초기화
		for(int i = 0; i <= 10000; i++) stuff.add(new HashMap<Integer, Integer>());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
			
			//v 무게 중 가치가 c인 물건을 이미 초기화 했으면 개수 + k를 해주고, 아니면 k로 초기화
			if(stuff.get(v).containsKey(c)) stuff.get(v).put(c, stuff.get(v).get(c) + k);
			else stuff.get(v).put(c, k);
		}
		
		//개수가 홀수면 현재 물건의 개수를 1로 바꿔주고, V * 2 무게 중 C * 2 가치의 개수를 K / 2만큼 올려준다.
		//개수가 짝수면 현재 물건의 개수를 2로 바꿔주고, V * 2 무게 중 C * 2 가치의 개수를 (K - 2) / 2만큼 올려준다.
		//개수가 2이면 물건 분할 X
		for(int i = 1; i <= 5000; i++) {
			if(stuff.get(i).size() > 0) {
				for(int key : stuff.get(i).keySet()) {
					int value = stuff.get(i).get(key);
					
					if(value <= 2) continue;
					
					int oldValue = 0, newValue = 0;
					
					if(value % 2 == 0) {
						oldValue = 2;
						newValue = (value - 2) / 2;
					}
					
					else {
						oldValue = 1;
						newValue = value / 2;
					}
					
					stuff.get(i).put(key, oldValue);
					
					if(!stuff.get(i * 2).containsKey(key * 2)) stuff.get(i * 2).put(key * 2, newValue);
					else stuff.get(i * 2).put(key * 2, stuff.get(i * 2).get(key * 2) + newValue);
				}
			}
		}
		
		//V * K <= 10000이므로,
		//V가 5000보다 크면 K 값을 1로 초기화
		for(int i = 5001; i <= 10000; i++) {
			if(stuff.get(i).size() > 0) {
				for(int key : stuff.get(i).keySet()) {
					stuff.get(i).put(key, 1);
				}
			}
		}
		
		//i : 무게, key : 가치, value : 개수
		//물건들의 정리가 끝났으면 배낭 문제 해결
		//이때, value가 2이면 한번 더 반복한다.
		for(int i = 1; i <= 10000; i++) {
			if(stuff.get(i).size() > 0) {
				for(int key : stuff.get(i).keySet()) {
					int value = stuff.get(i).get(key);
					
					for(int j = 0; j < value; j++) {
						for(int k = 10000; k >= i; k--) dp[k] = Math.max(dp[k], dp[k - i] + key);
					}
				}
			}
		}
		
		System.out.println(dp[M]);	
	}
}