package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3020_2 { //개똥벌레(구간 합)
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] section = new int[H + 2]; //각 구간에서 파괴할 장애물 수
		
		//석순이면 section[1]에 1을 더해주고, 크기를 넘어가는 구간에 1을 빼준다.
		//즉, 구간 합으로 석순이 있는 구간만 1씩 더해주다가 석순 위로 넘어가는 구간에서는 변화가 없다.
		//종류석이면 종유석의 끝에 있는 구간에 1을 더해준다. 종유석 위로 넘어가는 구간은 있을 수 없기 때문에 1을 빼줄 필요가 없다.
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i % 2 == 0) {
				section[1]++;
				section[num + 1]--;
			}
			else section[H - num + 1]++;
		}
		
		int min = Integer.MAX_VALUE, count = 0;
		
		//구간 합으로 각 구간에서 파괴할 장애물 수를 구한다.
		for(int i = 1; i <= H; i++) {
			section[i] += section[i - 1];
		
			if(min > section[i]) {
				min = section[i];
				count = 1;
			}
			else if(min == section[i]) count++;
		}
		
		System.out.println(min + " " + count);
	}
}