package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B5525 { //IOIOI
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		boolean isIOI = false;
		int ans = 0, countI = 0, countO = 0;
		for(int i = 0; i < M; i++) {
		
			if(s.charAt(i) == 'O' && countI == countO + 1) {
				countO++;
				continue;
			}
				
			if(s.charAt(i) == 'O') {
				countI = 0;
				countO = 0;
				isIOI = false;
				continue;
			}
				
			if(s.charAt(i) == 'I' && countI == countO) {
				countI++;
				
				if(!isIOI && countI == N + 1) {
					isIOI = true;
					ans++;
				}
				else if(isIOI) ans++;
				
				continue;
			}
				
			if(s.charAt(i) == 'I') {
				countI = 1;
				countO = 0;
				isIOI = false;
				continue;
			}
		}
		
		System.out.println(ans);
	}
}