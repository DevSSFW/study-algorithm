package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1969 { //DNA
	static int N, M;
	static int[] DNA;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String[] s = new String[N];
		for(int i = 0; i < N; i++) s[i] = br.readLine();
		
		char[] printDNA = new char[4];
		printDNA[0] = 'A';
		printDNA[1] = 'C';
		printDNA[2] = 'G';
		printDNA[3] = 'T';
		
		int dis = 0;
		for(int i = 0; i < M; i++) {
			DNA = new int[4]; //0 : A, 1 : C, 2 : G, 3 : T
			
			for(int j = 0; j < N; j++) {
				char c = s[j].charAt(i);
				
				Hamming(c);
			}
			
			int index = Distance();
			sb.append(printDNA[index]);
			dis += N - DNA[index];
		}
		
		sb.append('\n').append(dis);
		System.out.println(sb);
	}
	
	static void Hamming(char c) {
		if(c == 'A') DNA[0]++;
		else if(c == 'C') DNA[1]++;
		else if(c == 'G') DNA[2]++;
		else DNA[3]++;
	}

	static int Distance() {
		int max = Integer.MIN_VALUE, index = 0;
		
		for(int i = 0; i < 4; i++) {
			if(max < DNA[i]) {
				index = i;
				max = DNA[i];
			}
		}
		
		return index;
	}
}