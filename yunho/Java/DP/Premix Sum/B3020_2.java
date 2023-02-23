package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3020_2 { //���˹���(���� ��)
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] section = new int[H + 2]; //�� �������� �ı��� ��ֹ� ��
		
		//�����̸� section[1]�� 1�� �����ְ�, ũ�⸦ �Ѿ�� ������ 1�� ���ش�.
		//��, ���� ������ ������ �ִ� ������ 1�� �����ִٰ� ���� ���� �Ѿ�� ���������� ��ȭ�� ����.
		//�������̸� �������� ���� �ִ� ������ 1�� �����ش�. ������ ���� �Ѿ�� ������ ���� �� ���� ������ 1�� ���� �ʿ䰡 ����.
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i % 2 == 0) {
				section[1]++;
				section[num + 1]--;
			}
			else section[H - num + 1]++;
		}
		
		int min = Integer.MAX_VALUE, count = 0;
		
		//���� ������ �� �������� �ı��� ��ֹ� ���� ���Ѵ�.
		for(int i = 1; i <= H; i++) {
			section[i] += section[i - 1];
		
			if(min > section[i]) {
				min = section[i];
				count = 1;
			}
			else if(min == section[i]) count++;
		}
		
		System.out.println(min + " " + count);
	}
}