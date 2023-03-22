import java.util.*;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 5,};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int N = A.length;
        int maxSum = (N + 1) * (N + 2) / 2;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            currentSum += A[i];
        }
        return maxSum - currentSum;
    }
}
