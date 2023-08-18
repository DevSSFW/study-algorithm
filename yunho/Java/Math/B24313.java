package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B24313 { //�˰��� ���� - ������ ǥ�� 1
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A1 = Integer.parseInt(st.nextToken()), A2 = Integer.parseInt(st.nextToken()); //����
		int C = Integer.parseInt(br.readLine()), N0 = Integer.parseInt(br.readLine()); //���� ����
	
		int n = C - A1; //n
		if(n < 0) {
			System.out.println(0);
			return ;
		}
		if(n == 0) {
			if(A2 <= 0) System.out.println(1);
			else System.out.println(0);
			return ;
		}
		
		if(A2 % n != 0) A2 = A2 / n + 1;
		else A2 = A2 / n;
		
		if(N0 >= A2) System.out.println(1);
		else System.out.println(0);
	}
}