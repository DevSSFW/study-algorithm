package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 { //프린터 큐

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //문서의 개수
			int m = Integer.parseInt(st.nextToken()); //원하는 값
			int[] count = new int[10];
			int max = -1, ans = 0;
			Queue<int[]> Q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				Q.add(new int[] {j, num}); //0은 위치, 1은 우선순위
				max = Math.max(num, max);
				count[num]++;
			}
			
			while(!Q.isEmpty()) {
				int[] cur = Q.remove();
				int curL = cur[0], curP = cur[1];
				
				if(curP < max) {
					Q.add(new int[] {curL, curP});
					continue;
				}
				else {
					ans++;
					if(m == curL) {
						sb.append(ans).append("\n");
						break;
					}
					else {
						if(--count[max] == 0) {
							for(int j = max - 1; j > 0; j--) {
								if(count[j] > 0) {
									max = j;
									break;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}