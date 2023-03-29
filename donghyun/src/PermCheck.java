import java.util.*;

public class PermCheck {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,4,2,2,5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        //HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(A);
        int i = 0;
        for (int n : A) {
            if (n != i + 1) return 0;
            i += 1;
        }
        return 1;
    }
}
