package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651 { //N°ú M (3)
	private static StringBuilder sb = new StringBuilder();
	private static int N, M; //1 <= M <= N <= 7
	private static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		search(0);
		
		System.out.println(sb);
	}
	public static void search(int k) {
		if(k == M) {
			for(int i = 0; i < M; i++) sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			arr[k] = i;
			search(k + 1);
		}
	}
}