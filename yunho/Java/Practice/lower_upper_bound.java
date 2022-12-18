package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//lower_bound�� ã������ ���� ���ų� ū �� �߿��� ���� ���� ���� ã�´�.
//upper_bound�� ã������ ������ ū �� �߿��� ���� ���� ���� ã�´�.
public class lower_upper_bound {
	static int N, target;
	static int[] num;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		target = Integer.parseInt(br.readLine());
		
		int l = lower_bound(), u = upper_bound();
		if(l == -1) {
			System.out.println("ã������ �� ����");
			return;
		}
		
		System.out.println("lower_bound : " + num[l] + " upper_bound : " + num[u]);
	}

	static int lower_bound() {
		int st = 0, en = N;
		while(st < en) {
			int mid = (st + en) / 2;
			
			if(num[mid] < target) st = mid + 1;
			else en = mid;
		}
		
		if(en == N) return -1;
		return en;
	}
	
	static int upper_bound() {
		int st = 0, en = N;
		while(st < en) {
			int mid = (st + en) / 2;
			
			if(num[mid] <= target) st = mid + 1;
			else en = mid;
		}
		
		if(en == N) return -1;
		return en;
	}
}