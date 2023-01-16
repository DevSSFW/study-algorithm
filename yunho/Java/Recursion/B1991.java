package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1991 { //트리 순회
	static ArrayList<Integer>[] alpha;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		alpha = new ArrayList[27];
		for(int i = 0; i < N; i++) alpha[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();

			int P = str.charAt(0) - 'A';
			int L = str.charAt(2) - 'A';
			int R = str.charAt(4) - 'A';
			
			alpha[P].add(L);
			alpha[P].add(R);
		}
		System.out.println(Solve1(0));
		System.out.println(Solve2(0));
		System.out.println(Solve3(0));
	}

	public static String Solve1(int P) {
		String res = "" + (char)(P + 'A');
		
		for(int a : alpha[P]) {
			if(a == '.' - 'A') continue;
			res += Solve1(a);
		}
		
		return res;
	}
	
	public static String Solve2(int P) {
		String res = "";
		
		if(alpha[P].get(0) != '.' - 'A' && alpha[P].get(1) != '.' - 'A') {
			res += Solve2(alpha[P].get(0));
			res += (char)(P + 'A');
			res += Solve2(alpha[P].get(1));
		}
		else if(alpha[P].get(0) != '.' - 'A') {
			res += Solve2(alpha[P].get(0));
			res += (char)(P + 'A');
		}
		else if(alpha[P].get(1) != '.' - 'A') {
			res += (char)(P + 'A');
			res += Solve2(alpha[P].get(1));
		}
		if(alpha[P].get(0) == '.' - 'A' && alpha[P].get(1) == '.' - 'A') return res + (char)(P + 'A');
		
		return res;
	}
	
	public static String Solve3(int P) {
		String res = "";
		
		if(alpha[P].get(0) != '.' - 'A' && alpha[P].get(1) != '.' - 'A') {
			res += Solve3(alpha[P].get(0));
			res += Solve3(alpha[P].get(1));
			res += (char)(P + 'A');
		}
		else if(alpha[P].get(0) != '.' - 'A') {
			res += Solve3(alpha[P].get(0));
			res += (char)(P + 'A');
		}
		else if(alpha[P].get(1) != '.' - 'A') {
			res += Solve3(alpha[P].get(1));
			res += (char)(P + 'A');
		}
		if(alpha[P].get(0) == '.' - 'A' && alpha[P].get(1) == '.' - 'A') return res + (char)(P + 'A');
		
		return res;
	}
}