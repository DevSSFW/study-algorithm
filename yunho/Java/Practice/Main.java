package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { //K¹øÂ° ¼ö, ¾ÈµÊ
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int st = 1;
		int en = K;
		while (st <= en) {
			int count = 0;
			int mid = (st + en) >> 1;
			for (int i = 1; i <= N; i++)
				count += Math.min(N, mid / i);
			if(count == K) {
				System.out.println(mid);
				break;
			}
            else if (count < K) st = mid + 1;
			else en = mid - 1;
		}
    }
}