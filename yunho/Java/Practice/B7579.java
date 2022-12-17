package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7579 { //��

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //�� ����
		int M = Integer.parseInt(st.nextToken()); //�ʿ��� ����Ʈ
		int ans = 10000;
		
		int[] A = new int[N]; //Ȱ��ȭ �Ǿ� �ִ� �� �� ������� �޸��� ����Ʈ ��
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		
		int[] C = new int[N]; // ��Ȱ��ȭ ���� ����� ���
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) C[i] = Integer.parseInt(st.nextToken());
		
		int[] price = new int[10001];
		for(int i = 0; i < N; i++) {
			
			//ans���� ū ���� ������ ���� �� �� ���� ������ j�� ans���� �������ش�.
			for(int j = ans; j >= C[i]; j--) {
				price[j] = Math.max(price[j - C[i]] + A[i], price[j]);
				
				if(price[j] >= M) ans = Math.min(ans, j);
			}
		}
		
		System.out.println(ans);
	}
}