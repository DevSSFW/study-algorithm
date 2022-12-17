package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11728 { //배열 합치기
	private static int n, m;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //A의 크기
		m = Integer.parseInt(st.nextToken()); //B의 크기
		
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());
		
		sort(A, B, 0, 0);
		
		System.out.println(sb);
	}
	
	public static int sort(int[] A, int[] B, int inA, int inB) {
		if(n <= inA) {
			for(int i = inA + inB; i < n + m; i++, inB++) sb.append(B[inB]).append(" ");
			return 0;
		}
		else if(m <= inB) {
			for(int i = inA + inB; i < n + m; i++, inA++) sb.append(A[inA]).append(" ");
			return 0;
		}
		
		if(A[inA] > B[inB]) {
			sb.append(B[inB]).append(" ");
			return sort(A, B, inA, ++inB);
		}
		else {
			sb.append(A[inA]).append(" ");
			return sort(A, B, ++inA, inB);
		}
	}
}