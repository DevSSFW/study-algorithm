package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11651 { //좌표 정렬하기2
	private static int[][] room, temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		room = new int[N][2];
		temp = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(0, N - 1);
		
		for(int i = 0; i < N; i++) sb.append(room[i][0]).append(" ").append(room[i][1]).append("\n");
		System.out.println(sb);
	}
	
	public static void merge_sort(int st, int en) {
		if(st < en) {
			int mid = (st + en) / 2;
			
			merge_sort(st, mid);
			merge_sort(mid + 1, en);
		
			int firArr = st, secArr = mid + 1;
			for(int i = st; i <= en; i++) {
				if(firArr > mid) temp[i] = room[secArr++];
				else if(secArr > en) temp[i] = room[firArr++];
				else if(room[firArr][1] < room[secArr][1]) temp[i] = room[firArr++];
				else if(room[firArr][1] == room[secArr][1]) {
					if(room[firArr][0] <= room[secArr][0]) temp[i] = room[firArr++];
					else temp[i] = room[secArr++];
				}
				else temp[i] = room[secArr++];
			}
			
			for(int i = st; i <= en; i++) {
				room[i] = temp[i];
			}
		}
	}
}