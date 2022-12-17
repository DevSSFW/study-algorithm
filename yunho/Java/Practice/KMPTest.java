package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KMPTest {
	static int[] pi;
	static char[] pattern;
	static String src;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		pi = new int[N]; pattern = new char[N];
		for(int i = 0; i < N; i++) pattern[i] = s.charAt(i);
		src = br.readLine();
		
		make_pi();
		System.out.println(KMP());
	}
	static void make_pi() {
		int size = pattern.length;
		
		for(int i = 1, j = 0; i < size; i++) {
			while(j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];
			if(pattern[i] == pattern[j]) pi[i] = ++j;
		}
	}
	
	static int KMP() {
		int res = 0, sizePattern = pattern.length, sizeSrc = src.length();
		
		for(int i = 0, j = 0; i < sizeSrc; i++) {
			while(j > 0 && pattern[j] != src.charAt(i)) j = pi[j - 1];
			if(pattern[j] == src.charAt(i)) {
				if(j == sizePattern - 1) {
					res++;
					j = pi[j];
				}
				else j++;
			}
		}
		
		return res;
	}
}