package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1655_1 { //가운데를 말해요 (이분탐색)
	static ArrayList<Integer> num;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		num = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			search(n);
			
			if(i % 2 == 1) sb.append(Math.min(num.get(i / 2), num.get(i / 2 + 1))).append('\n');
			else sb.append(num.get(i / 2)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void search(int key) {
		int l = 0, r = num.size() - 1, mid = (l + r) / 2;
		
		while(l <= r) {
			mid = (l + r) / 2;
			
			if(num.get(mid) == key) {
				num.add(mid, key);
				return;
			}
			else if(num.get(mid) > key) r = mid - 1;
			else l = mid + 1;
		}
		
		num.add(l, key);
	}
}