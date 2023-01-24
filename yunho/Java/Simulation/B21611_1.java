package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B21611_1 { //������ ���� ���ڵ�
	static int N, M, res;
	static int[][] map;
	static StringBuilder num = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Initial();

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			if(num.length() < 2) break;
			
			Skill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			num = Reset();
		}
		
		System.out.println(res);
	}
	
	//���� �迭�� �ʱ�ȭ
	//������ �������� �̵��ϴ� �ͺ��� ����
	//���ʰ� �Ʒ��� �̵� ���� ����, �����ʰ� ���� �̵� ���� ����.
	//�Ʒ� -> ������, �� -> �������� ������ �ٲ� ������ �̵� ���� 1 ����
	//�������� �� �� N - 1���� 0���� �������� �̵�
	public static void Initial() {
		int count = 0, index = 1, move = 1;
		int col = (N + 1) / 2, row = (N + 1) / 2;
	
		num.append(5); //���
		for(int i = 1; i < N * N; ) {
			if(count == move * 2) {
				count = 0;
				move++;
			}
			
			if(move == N) {
				for(int j = N - 1; j > 0; j--) num.append(map[1][j]);
				break;
			}
			
			for(int j = 0; j < move; j++) {
				int n = 0;
				
				if(index == 1) n = map[col][--row]; //��
				else if(index == 2) n = map[++col][row]; //��
				else if(index == 3) n = map[col][++row]; //��
				else n = map[--col][row]; //��
				
				num.append(n);
				
				count++;
			}
			
			index = (index % 4) + 1;
		}
	}
	
	//1 : ��, 2 : ��, 3 : ��, 4 : ��
	//��������
	public static void Skill(int d, int s) {
		int prevNum = 0, n = 0;
		
		if(d == 1) n = 7;
		else if(d == 2) n = 3;
		else if(d == 3) n = 1;
		else n = 5;
		
		for(int i = 1; i <= s; i++) {
			prevNum += n + (i - 1) * 8;
			
			if(prevNum >= num.length()) break;
			num.deleteCharAt(prevNum);
			prevNum--;
		}
		
		Bomb();
	}
	
	public static void Bomb() {
		int count = 0, tempNum = 0;
		boolean bomb = false;
		
		for(int i = 1; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			
			if(n == 0) {
				num.deleteCharAt(i);
				i--;
				bomb = true;
				continue;
			}
			
			if(tempNum == n) count++;
			else {
				if(count >= 4) {
					num.delete(i - count, i);
					i -= count;
					res += tempNum * count;
					bomb = true;
				}
				
				tempNum = n;
				count = 1;
			}
		}
		
		if(count >= 4) {
			num.delete(num.length() - count, num.length());
			res += tempNum * count;
			bomb = true;
		}
		if(bomb) Bomb();
	}
	
	public static StringBuilder Reset() {
		StringBuilder tempSb = new StringBuilder();
		if(num.length() < 2) return num;
		
		int tempNum = num.charAt(1) - '0', count = 1;
		
		tempSb.append(5);
		for(int i = 2; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			
			if(tempNum == n) count++;
			else {
				if(tempSb.length() >= N * N) return tempSb;
				else if (tempSb.length() == N * N - 1) {
					tempSb.append(count);
					return tempSb;
				}
				
				tempSb.append(count).append(tempNum);
				tempNum = n;
				count = 1;
			}
		}
		
		if(tempSb.length() >= N * N) return tempSb;
		else if (tempSb.length() == N * N - 1) {
			tempSb.append(count);
			return tempSb;
		}
		
		tempSb.append(count).append(tempNum);
		return tempSb;
	}
}