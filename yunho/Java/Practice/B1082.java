package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1082 { //�� ��ȣ
	static String[] room, l; //room : ���� ū �� ��ȣ, l : �� ��ȣ�� ���� �� �ִ� ���� �� ���ڿ�
	static boolean[] vis; //vis[i]�� true��� ���� �ش� ������ �ִ� ���� �ִ� ���̸� ã�Ҵٴ� �ǹ��̴�.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] P = new int[N]; //���ڵ� ����
		for(int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken()); //�� ���ڵ��� ������ �־��ش�.
		
		int M = Integer.parseInt(br.readLine()); //������ �ִ� ��
		room = new String[51]; l = new String[51]; //M�� �����̴�.
		vis = new boolean[51];
		int index = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			room[P[i]] = Integer.toString(i);
			l[P[i]] = Integer.toString(i);
			vis[P[i]] = true;
			index = Math.min(index, P[i]);
		}
		
		/*
		 * 3 6 9�� �ԷµǸ� room[3] = 0, room[6] = 1, room[9] = 2�� ���� �ݺ������� ����ȴ�. �迭 l�� ���������̴�.
		 * i�� index + 1���� �����ϴ� ������ ����,
		 * index = 3�̰�, 3�� ������ 0�̴�.
		 * 6�� 0�̴�.
		 * ������ 9�� 2�� �ƴ� 6 + 3, �� 10�� ���� ū �����̴�.
		 * �׷��� index + 1���� M���� ���̳��� ���α׷����� �̿��ؼ� ���� ū ���ڸ� ���Ѵ�.  
		 */
		
		for(int i = index + 1; i <= M ; i++) {
			String max = "0", max_len = "0"; //max : �ִ� �� ������ ����, max_len : �ִ� ���� ������ ���� 
			
			/*
			 * i�� ���̰�, j�� �����̴�.
			 * �迭 P�� 6 7 8�� �ԷµǸ�, ���� 0�� ������ 6, ���� 1�� ������ 7, ���� 2�� ������ 8�̴�.
			 * i��ŭ ���� ������ ������, room[i]�� ���� ū �����̰�, l[i]�� �ش� ������ ���� �� ���ڿ��̴�.
			 * 
			 * room[i]�� ���� ū ���ڰ� �Ƿ���,
			 * 1- i������ P[j]�� ��ŭ ���� ������ ���� �� ���ڿ��� ���Ѵ�. ��, l[i - P[j]]�� ���Ѵ�. ���⼭ l[i - P[j]]�� ������ DP�� �̹� ����Ǿ� �ִ�.
			 * 2- ù��° ���ڿ� j�� �־��ְ�, �������� l[i - P[j]]�� ���Ѵ�.
			 * 3- max�� �� �������� ���� ���ڿ��� �� �� ū ���� max�� �����Ѵ�.
			 * 4- 1, 2, 3 ������ ��� ���ڸ�ŭ �ݺ��Ѵ�.
			 * 
			 * l[i]�� ���� �� ���ڿ��� �Ƿ���,
			 * 1- i������ P[j]�� ��ŭ ���� ������ ���� �� ���ڿ��� ���Ѵ�. ��, l[i - P[j]]�� ���Ѵ�. ���⼭ l[i - P[j]]�� ������ DP�� �̹� ����Ǿ� �ִ�.
			 * 2- ù��° ���ڿ� j�� �־��ְ�, �������� l[i - P[j]]�� ���Ѵ�.
			 * 3- max_len�� �� �������� ���� ���ڿ��� �� �� ū ���� max_len�� �����Ѵ�.
			 * 4- 1, 2, 3 ������ ��� ���ڸ�ŭ �ݺ��Ѵ�.
			 * 
			 * room[i]�� l[i]�� �������� room[i]�� 0��° �ε����� 0�� �� �� ������(000�� �� �� ����), l[i]�� �ܼ��� ���̰� �� ���ڿ��� �����ϴ� ���̱� ������ 0�� ��� �ڸ��̵� �� �� �ִ�.(000�� �� �� �ִ�)
			 */
			
			for(int j = 0; j < N; j++) {
				if(i < P[j]) continue; //i�� P[j]���� �۴ٸ� ���� j������ �ѱ��. ��, 7���� ������ �ִµ�, P[1]�� 8�̸� 1�� �� �� ����.
				
				//s : ���� ������ ����, max ���� ���Ѵ�. ó�� ���� j�� �����Ѵ�.
				//len : ���̸� ������ ����, max_len�� ���Ѵ�. ó�� ���� j�� �����Ѵ�.
				String s = Integer.toString(j), len = Integer.toString(j);
				if(i > P[j] && vis[i - P[j]]) { //�湮�� ���� �ʾ��� ��쿡�� �ش� ������ ���� �� ���ڿ��� �� �� ���� ������ �������� �ʴ´�.
					s += l[i - P[j]];
					len += l[i - P[j]];
				}
				
				if(s.length() > max.length() && s.charAt(0) != '0') max = s; //���̰� ����� �� ū ���� ������. ��, ù��° �ڸ����� 0�϶��� ���� ���� ����.
				else if(s.length() == max.length() && s.compareTo(max) > 0) max = s; //���̰� ���� ��� ���� �� �� max�� ū ���� �����Ѵ�.
			
				if(len.length() > max_len.length()) max_len = len; //���̰� �� �� ���ڿ��� �����Ѵ�.
				else if(len.length() == max_len.length() && len.compareTo(max_len) > 0) max_len = len; //���̰� ���� ��� �� ū ���� �����Ѵ�.
			}
			
			room[i] = max; //���� ū ���� room[i]�� �����Ѵ�. ��, i��ŭ ���� ������ ���� �� ���� ū ���ڸ� �����Ѵ�.
			l[i] = max_len; //���� �� ���� l[i]�� �����Ѵ�. ��, i��ŭ ���� ������ ���� �� ���� �� ���ڿ��� �����Ѵ�.
			vis[i] = true;
			
			//System.out.println("M : " + i + " room : " + max + " l : " + max_len); //�׽�Ʈ
		}
		System.out.println(room[M]);
	}
}