package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 { //�Ҿ���� ��ȣ
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String num = "";
		int ans = 0, a = 0;
		boolean minus = false; //���̳ʽ��� ���� �ڷδ� ��� ���ش�.
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num += s.charAt(i);
				continue;
			}
			
			a = Integer.valueOf(num);
			num = "";
			
			if(minus) ans -= a;
			else ans += a;
			
			if(s.charAt(i) == '-') minus = true;
		}
		
		a = Integer.valueOf(num);
		num = "";
		
		if(minus) ans -= a;
		else ans += a;

		System.out.println(ans);
	}
}