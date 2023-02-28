package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B10827 { //a^b
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean check = false; //true면 소수점
		int count = 0;
		String a = st.nextToken(), temp = "";
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '.') {
				check = true;
				continue;
			}
			
			temp += a.charAt(i);
			if(check) count++;
		}
		BigInteger A = new BigInteger(temp);
		int B = Integer.parseInt(st.nextToken());

		A = A.pow(B);
		a = A.toString();
		
		count *= B;
		int aLen = a.length();
		if(aLen <= count) {
			sb.append("0.");
			
			count -= aLen;
			for(int i = 0; i < count; i++) sb.append('0');
			sb.append(a);
		}
		else {
			sb.append(a.substring(0, aLen - count)).append('.').append(a.substring(aLen - count));
		}

		System.out.println(sb);
	}
}