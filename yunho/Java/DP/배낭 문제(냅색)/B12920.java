package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//V : ����, C : ������ ,K : ����
public class B12920 { //����� �賶 2
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ArrayList<HashMap<Integer, Integer>> stuff = new ArrayList<>(); //index : ����, key : ������, value : ����
		int[] dp = new int[10001];
		
		//���� 0���� 10000���� �ʱ�ȭ
		for(int i = 0; i <= 10000; i++) stuff.add(new HashMap<Integer, Integer>());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
			
			//v ���� �� ��ġ�� c�� ������ �̹� �ʱ�ȭ ������ ���� + k�� ���ְ�, �ƴϸ� k�� �ʱ�ȭ
			if(stuff.get(v).containsKey(c)) stuff.get(v).put(c, stuff.get(v).get(c) + k);
			else stuff.get(v).put(c, k);
		}
		
		//������ Ȧ���� ���� ������ ������ 1�� �ٲ��ְ�, V * 2 ���� �� C * 2 ��ġ�� ������ K / 2��ŭ �÷��ش�.
		//������ ¦���� ���� ������ ������ 2�� �ٲ��ְ�, V * 2 ���� �� C * 2 ��ġ�� ������ (K - 2) / 2��ŭ �÷��ش�.
		//������ 2�̸� ���� ���� X
		for(int i = 1; i <= 5000; i++) {
			if(stuff.get(i).size() > 0) {
				for(int key : stuff.get(i).keySet()) {
					int value = stuff.get(i).get(key);
					
					if(value <= 2) continue;
					
					int oldValue = 0, newValue = 0;
					
					if(value % 2 == 0) {
						oldValue = 2;
						newValue = (value - 2) / 2;
					}
					
					else {
						oldValue = 1;
						newValue = value / 2;
					}
					
					stuff.get(i).put(key, oldValue);
					
					if(!stuff.get(i * 2).containsKey(key * 2)) stuff.get(i * 2).put(key * 2, newValue);
					else stuff.get(i * 2).put(key * 2, stuff.get(i * 2).get(key * 2) + newValue);
				}
			}
		}
		
		//V * K <= 10000�̹Ƿ�,
		//V�� 5000���� ũ�� K ���� 1�� �ʱ�ȭ
		for(int i = 5001; i <= 10000; i++) {
			if(stuff.get(i).size() > 0) {
				for(int key : stuff.get(i).keySet()) {
					stuff.get(i).put(key, 1);
				}
			}
		}
		
		//i : ����, key : ��ġ, value : ����
		//���ǵ��� ������ �������� �賶 ���� �ذ�
		//�̶�, value�� 2�̸� �ѹ� �� �ݺ��Ѵ�.
		for(int i = 1; i <= 10000; i++) {
			if(stuff.get(i).size() > 0) {
				for(int key : stuff.get(i).keySet()) {
					int value = stuff.get(i).get(key);
					
					for(int j = 0; j < value; j++) {
						for(int k = 10000; k >= i; k--) dp[k] = Math.max(dp[k], dp[k - i] + key);
					}
				}
			}
		}
		
		System.out.println(dp[M]);	
	}
}