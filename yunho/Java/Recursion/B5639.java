package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B5639 { //이진 검색 트리
	static ArrayList<Integer> num;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		num = new ArrayList<>();
		String str;
		while((str = br.readLine()) != null) num.add(Integer.parseInt(str));
		
		search(0, num.size() - 1);
		System.out.println(sb);
	}

	static void search(int start, int end) {
		if(start > end) return;
		if(start == end) {
			sb.append(num.get(start)).append('\n');
			return;
		}
			
		int mid = start + 1;
		while(mid <= end && num.get(start) > num.get(mid)) mid++;
		
		search(start + 1, mid - 1);
		search(mid, end);
		sb.append(num.get(start)).append('\n');
	}
}