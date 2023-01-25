package baekjoon.Intro.mathematics;

/**
 * <p>B_15596</p>
 */
public class 정수_N개의_합 {
    /**
     * <p>함수 구현 문제</p>
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N=2
        int[] a = new int[N];

        String s = br.readLine();
        String[] arr = s.split(" ");

        for (int k = 0; k < N; k++) {
            a[k] = Integer.parseInt(arr[k]);
        }

        System.out.println(sum(a));
    }
    */
    static long sum(int[] a) {
        long sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
