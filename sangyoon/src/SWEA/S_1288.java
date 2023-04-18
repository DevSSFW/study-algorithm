package SWEA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class S_1288 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int cur;
        Set<Integer> seen = new HashSet<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            seen.clear();

            for (int i = 1; ; i++) {
                cur = N * i;

                for (int temp = cur; temp > 0; temp /= 10) {
                    int q = temp % 10;
                    seen.add(q);
                }

                if (seen.size() > 9) break;
            }

            System.out.format("#%d %d\n", test_case, cur);
        }
    }
}
