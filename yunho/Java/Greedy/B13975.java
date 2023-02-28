package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13975 { //파일 합치기 3
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> PQ = new PriorityQueue<>();
			
			for(int i = 0; i < K; i++) PQ.add(Long.parseLong(st.nextToken()));
			
			long res = 0;
			while(true) {
				long[] num = {PQ.remove(), PQ.remove()};
				
				long temp = num[0] + num[1];
				res += temp;
				
				if(PQ.isEmpty()) break;
				PQ.add(temp);
			}
			
			sb.append(res + "\n");
		}
		
		System.out.println(sb);
	}
}