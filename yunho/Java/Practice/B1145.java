package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1145 { //��� ��κ��� ���

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n[] = new int[5]; //�ڿ��� 5��
		int min = Integer.MAX_VALUE; //���� ���� ��
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) {
			n[i] = Integer.parseInt(st.nextToken());
			if(min > n[i]) min = n[i];
		}
		
		while(true) { //��� �� ���� ����� ���� ������ �ݺ�
			int count = 0;
			for(int i = 0; i < 5; i++) {
				if(min % n[i] == 0) count++;
			}
			if(count >= 3) {
				System.out.println(min);
				break;
			}
			min++;
		}
	}
}