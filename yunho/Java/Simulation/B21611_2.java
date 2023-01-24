package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21611_2 { //마법사 상어와 블리자드
	static int N, M, res;
	static int[][] map;
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		num = new int[N * N];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Initial();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			Skill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Reset();
			//PrintMap("초기화");
		}
		
		System.out.println(res);
	}
	
	//맵을 배열로 초기화
	//시작은 왼쪽으로 이동하는 것부터 시작
	//왼쪽과 아래가 이동 수가 같고, 오른쪽과 위가 이동 수가 같다.
	//아래 -> 오른쪽, 위 -> 왼쪽으로 방향이 바꿀 때마다 이동 수가 1 증가
	//마지막은 맨 위 N - 1에서 0으로 왼쪽으로 이동
	public static void Initial() {
		int count = 0, index = 1, move = 1;
		int col = (N + 1) / 2, row = (N + 1) / 2;
	
		num[0] = 5; //상어
		for(int i = 1; i < N * N; ) {
			if(count == move * 2) {
				count = 0;
				move++;
			}
			
			if(move == N) {
				for(int j = N - 1; j > 0; j--) num[i++] = map[1][j];
				break;
			}
			
			for(int j = 0; j < move; j++) {
				int n = 0;
				
				if(index == 1) n = map[col][--row]; //좌
				else if(index == 2) n = map[++col][row]; //하
				else if(index == 3) n = map[col][++row]; //우
				else n = map[--col][row]; //상
				
				num[i++] = n;
				
				count++;
			}
			
			index = (index % 4) + 1;
		}
	}
	
	//1 : 상, 2 : 하, 3 : 좌, 4 : 우
	//계차수열
	public static void Skill(int d, int s) {
		int prevNum = 0, n = 0;
		
		if(d == 1) n = 7;
		else if(d == 2) n = 3;
		else if(d == 3) n = 1;
		else n = 5;

		for(int i = 1; i <= s; i++) {
			prevNum += n + (i - 1) * 8;
			
			if(prevNum >= num.length) break;
			num[prevNum] = 0;
		}
		
		//PrintMap("스킬 발동");
		Move();
	}
	
	public static void Bomb() {
		int count = 0, tempNum = 0;
		boolean isBomb = false;
		
		for(int i = 1; i < num.length; i++) {
			int n = num[i];
			
			if(n == 0) break;
			if(tempNum == n) count++;
			else {
				if(count >= 4) {
					for(int j = 1; j <= count; j++) num[i - j] = 0;
					res += tempNum * count;
					isBomb = true;
				}
				
				tempNum = n;
				count = 1;
			}
		}
		
		if(count >= 4) {
			for(int i = 1; i <= count; i++) num[num.length - i] = 0;
			res += tempNum * count;
			isBomb = true;
		}
		
		if(isBomb) Move();
	}
	
	public static void Move() {
		boolean isMove = false;
		Queue<Integer> zero = new LinkedList<>();
		
		for(int i = 1; i < N * N; i++) {
			if(num[i] == 0) zero.add(i);
			else if(zero.size() > 0) {
				num[zero.remove()] = num[i];
				num[i] = 0;
				zero.add(i);
				isMove = true;
			}
		}
		
		//PrintMap("이동");
		if(isMove) Bomb();
	}
	
	public static void Reset() {
		int[] temp = new int[N * N];
		int tempNum = num[1], count = 1, tempLen = 1;
		
		temp[0] = 5;
		for(int i = 2; i < num.length; i++) {
			int n = num[i];
			
			if(tempNum == 0) {
				num = temp;
				
				return;
			}
			if(tempNum == n) count++;
			else {
				if(tempLen >= N * N) {
					num = temp;
					
					return;
				}
				else if (tempLen == N * N - 1) {
					temp[tempLen++] = count;
					num = temp;
					
					return;
				}
				
				temp[tempLen++] = count;
				temp[tempLen++] = tempNum;
				
				tempNum = n;
				count = 1;
			}
		}
		
		if(tempLen >= N * N) {
			num = temp;
			
			return;
		}
		else if (tempLen == N * N - 1) {
			temp[tempLen++] = count;
			num = temp;
			
			return;
		}
		
		temp[tempLen++] = count;
		temp[tempLen++] = tempNum;
		
		num = temp;
	}
	
	public static void PrintMap(String str) {
		System.out.println();
		System.out.println(str);
		for(int i = 0; i < N * N; i++) System.out.println(i + " : " + num[i]);
	}
}