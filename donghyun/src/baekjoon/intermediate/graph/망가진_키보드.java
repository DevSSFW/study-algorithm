package baekjoon.intermediate.graph;
import java.io.*;

public class 망가진_키보드 {
    static int m;
    static int[] visit;
    static int L;
    static int R;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            m = Integer.parseInt(br.readLine());
            if (m == 0) break;
            String s = br.readLine();
            visit = new int[128]; // 키보드 문자열 가짓수 싹 다 담기
            R = -1;
            L = -1;
            int counter = 0;
            int answer = twoPointer(m, s, counter);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int twoPointer(int m, String str, int counter) {
        int max = 0;
        while (L <= R) {
            if (R == str.length() - 1) break;
            if (counter < m || (counter == m && visit[str.charAt(R + 1)] != 0)) { //반례 추가해서
                R++;
                visit[str.charAt(R)]++;
                if (visit[str.charAt(R)] == 1) { //처음 확인된 문자일 경우
                    counter++;
                }
            } else {
                if(counter == m && visit[str.charAt( R + 1)] == 0){
                    L++;
                    visit[str.charAt(L)]--;
                    if (visit[str.charAt(L)] == 0) { //처음 확인된 문자 개수를 줄여 0이 되면
                        counter--;
                    }
                }
            }
            max = Math.max(R - L, max);
        }
        return max;
    }
}
