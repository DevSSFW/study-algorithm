package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 { //���� �ڸ���

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken()); //k <= n
		
		long temp = 0;
		int[] lines = new int[k];
		for(int i = 0; i < k; i++) {
			int line = Integer.parseInt(br.readLine()); // ���� �� ��
			lines[i] = line;
			temp = Math.max(line, temp);
		}
		
		int count = 0; //���� ���� ����
		long low = 1, mid = 0, high = temp + 1; //������ ����, ����� ������ ������ ��������.
		while(low < high) {
			mid = (high + low) / 2;
			count = 0;
			for(int i = 0; i < k; i++) count += lines[i] / mid;
			
			//	(������ ������ �� ����)	low		mid		high	(������ ������ �� ����)
			if(count >= n) low = mid + 1; //���� ������ ������ n���� ũ�ų� ���� ��, ������ ���̸� �ø���.
			else high = mid; //���� ������ ������ n���� ���� ��, ������ ���̸� ���δ�.
		}
		System.out.println("low:" + low + " mid:" + mid + " high:" + high + " count:" + count);
		
		System.out.println(high - 1);
	}
}