package SWEA;

import java.util.Scanner;

public class S_1284 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int P, Q, R, S, W;
            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();

            int feeA = feeA(P, W);
            int feeB = feeB(Q, R, S, W);
            System.out.format("#%d %d\n", test_case, Math.min(feeA, feeB));
        }
    }

    public static int feeA(int P, int W) {
        return P * W;
    }
    public static int feeB(int Q, int R, int S, int W) {
        if (W <= R) return Q;
        else return Q + ((W - R) * S);
    }
}
