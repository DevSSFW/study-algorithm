package Practice;

import java.util.Scanner;

public class B2097 { //���൹

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE; //���� �ѷ�
		
		if(n < 4) {
			System.out.println(4);
			return;
		}
		
		int i;
		for(i = 1; i * i <= n; i++) {
			int num; //���� ����
			if(n % i == 0) num = (n / i + i - 2) * 2; //n
			else num = (n / i + i - 1) * 2; //n���� ũ��, ���������� ���� ����
			
			min = Math.min(num, min);
		}
		min = Math.min(min, (i - 1) * 4); //n���� ū �������� �ѷ� ��
		
		System.out.println(min);
	}
}