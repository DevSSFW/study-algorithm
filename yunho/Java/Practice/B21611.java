package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B21611 { //마법사 상어와 블리자드
	static int N, M, temp_num, one, two, three;
	static int[][] map_num;
	static int[] map;
	static Stack<int[]> S = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map_num = new int[N + 1][N + 1];
		map = new int[N * N];
		
		//순서 만들기
		make_num((N + 1) / 2, (N + 1) / 2, 1, 1, 1);
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) map[map_num[i][j]] = Integer.parseInt(st.nextToken());
		}
		
		int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
			int row = (N + 1) / 2, col = (N + 1) / 2;
			
			//스킬 시전
			int temp = s;
			while(temp-- > 0) {
				row += dx[d]; col += dy[d];
				
				map[map_num[row][col]] = 0;
				S.push(new int[] {row, col});
			}
			
			//구슬 이동
			temp = s;
			while(temp-- > 0) {
				int[] cur = S.pop();
				int num = map_num[cur[0]][cur[1]];
				
				while(true) {
					if(num == N * N - 1) {
						map[num] = 0;
						break;
					}
					
					map[num] = map[num + 1];
					if(map[num++] == 0) break;
				}
			}
			
			//구슬 폭발
			while(true) {
				boolean clear = false;
				int num = 0, count = 0;
					
				temp_num = 0;
				for(int i = 1; i < N * N; i++) {
					if(map[i] != num) {
						if(count >= 4) {
							S.push(new int[] {temp_num, count});
							boom(count);
							clear = true;
						}

						num = map[i];
						count = 1;
						temp_num = i;
						continue;
					}

					if(map[i] == 0) break;
						
					count++;
				}
					
				if(count >= 4) {
					S.push(new int[] {temp_num, count});
					boom(count);
					clear = true;
				}

				//폭발 후 이동
				move();
				
				if(!clear) break;
				
				//for(int i = 1; i < N * N; i++) {
				//	System.out.println("num : " + i + " map : " + map[i]);
				//}
			}
			
			//구슬 변화
			change();
		}
		
		System.out.println(one + two * 2 + three * 3);
	}

	//왼쪽 : 1, 아래 : 2, 오른쪽 : 3, 위 : 4
	public static void make_num(int row, int col, int d, int count, int num) {
		int temp = count;
		int[] dx = {0, 0, 1, 0, -1}, dy = {0, -1, 0, 1, 0};
		
		while(temp-- > 0) {
			row += dx[d]; col += dy[d];
			
			if(col == 0) return;
			
			map_num[row][col] = num++;
		}
		
		d = (d % 4) + 1;
		if(d == 1 || d == 3) count++;
		
		make_num(row, col, d, count, num);
	}
	
	public static void move() {
		while(!S.isEmpty()) {
			int[] cur = S.pop();
			int num = cur[0], count = cur[1];
			
			while(true) {
				if(num == N * N - count) {
					for(int i = num; i < num + count; i++) map[i] = 0;
					break;
				}
				
				map[num] = map[num + count];
				if(map[num++] == 0) break;
			}
		}
	}
	
	public static void boom(int count) {
		int n = temp_num;
		
		for(int i = n; i < n + count; i++) {
			if(map[i] == 1) one++;
			else if(map[i] == 2) two++;
			else if(map[i] == 3) three++;
			
			map[i] = 0;
		}
	}
	
	public static void change() {
		int temp = 1, num = map[1], count = 1;
		int[] temp_map = new int[N * N];
		
		for(int i = 2; i < N * N; i++) {
			if(num != map[i]) {
				//구슬 변화
				if(temp >= N * N) break;
				else if(temp + 1 >= N * N) temp_map[temp] = count;
				else {
					temp_map[temp] = count;
					temp_map[temp + 1] = num;
				}
				temp += 2;
				
				//초기화
				num = map[i];
				count = 1;
			}
			else count++;
		}
		
		map = Arrays.copyOf(temp_map, N * N);
	}
}