package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1082_2 { //방 번호
	static String[] l; //방 번호에 붙일 수 있는 제일 긴 문자열
	static boolean[] vis; //vis[i]가 true라는 뜻은 해당 돈에서 최대 값과 최대 길이를 찾았다는 의미이다.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] P = new int[N]; //숫자들 가격
		for(int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken()); //각 숫자들의 가격을 넣어준다.
		
		int M = Integer.parseInt(br.readLine()); //가지고 있는 돈
		l = new String[51]; //M이 기준이다.
		vis = new boolean[51];
		int index = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			l[P[i]] = Integer.toString(i);
			vis[P[i]] = true;
			index = Math.min(index, P[i]);
		}
		
		/*
		 * 3 6 9가 입력되면 l[3] = 0, l[6] = 1, l[9] = 2가 위에 반복문에서 저장된다.
		 * i가 index + 1부터 시작하는 이유를 보면,
		 * index = 3이고, 3은 무조건 0이다.
		 * 6도 0이다.
		 * 하지만 9는 2가 아닌 6 + 3, 즉 10이 가장 큰 숫자이다.
		 * 그래서 index + 1부터 M까지 다이나믹 프로그래밍을 이용해서 가장 큰 숫자를 구한다.  
		 */
		
		for(int i = index + 1; i <= M ; i++) {
			String max_len = "0"; //max_len : 최대 길이 저장할 변수 
			
			/*
			 * i는 돈이고, j는 숫자이다.
			 * 배열 P에 6 7 8이 입력되면, 숫자 0의 가격은 6, 숫자 1의 가격은 7, 숫자 2의 가격은 8이다.
			 * i만큼 돈을 가지고 있을때, l[i]는 해당 돈에서 가장 긴 문자열이다.
			 * 
			 * l[i]가 가장 긴 문자열이 되려면,
			 * 1- i원에서 P[j]원 만큼 빼준 돈에서 가장 긴 문자열을 구한다. 즉, l[i - P[j]]를 구한다. 여기서 l[i - P[j]]는 이전에 DP로 이미 저장되어 있다.
			 * 2- 첫번째 문자에 j를 넣어주고, 나머지는 l[i - P[j]]을 더한다.
			 * 3- max_len과 위 과정에서 구한 문자열을 비교 후 큰 값을 max_len에 저장한다.
			 * 4- 1, 2, 3 과정을 모든 숫자만큼 반복한다.
			 */
			
			for(int j = 0; j < N; j++) {
				if(i < P[j]) continue; //i가 P[j]보다 작다면 다음 j값으로 넘긴다. 즉, 7원을 가지고 있는데, P[1]이 8이면 1은 살 수 없다.
				
				String len = Integer.toString(j); //길이를 저장할 변수, max_len과 비교한다. 처음 값은 j를 저장한다.
				if(i > P[j] && vis[i - P[j]]) { //방문을 하지 않았을 경우에는 해당 돈에서 가장 긴 문자열을 알 수 없기 때문에 실행하지 않는다.
					len += l[i - P[j]];
				}
                
				if(len.length() > max_len.length()) max_len = len; //길이가 더 긴 문자열을 저장한다.
				else if(len.length() == max_len.length() && len.compareTo(max_len) > 0) max_len = len; //길이가 같을 경우 더 큰 값을 저장한다.
			}
		    l[i] = max_len; //가장 긴 값을 l[i]에 저장한다. 즉, i만큼 돈을 가지고 있을 때 가장 긴 문자열을 저장한다.
			vis[i] = true;
		}
		
        String max = "0"; //max가 ""면 1\n 1\n 50을 넣었을 때 0이 나와야 하지만 ""가 나온다. 즉 기본값은 0이다.
        for(int i = 0; i < N; i++) {
            if(M < P[i]) continue;
            
            String s = Integer.toString(i);
            if(M > P[i] && vis[M - P[i]]) s += l[M - P[i]];
            
            if(s.length() > max.length() && s.charAt(0) != '0') max = s;
            else if(s.length() == max.length() && s.compareTo(max) > 0) max = s;
        }
        System.out.println(max);
	}
}