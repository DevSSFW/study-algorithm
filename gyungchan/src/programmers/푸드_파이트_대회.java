package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 푸드_파이트_대회 {
    public static String solution(int[] food) {
        String answer = "";
        for(int i=1; i<food.length; i++) {
            int n = food[i]/2;
            for(int j=0; j<n; j++){
                answer += i;
            }
        }
        String tmp = new StringBuilder(answer).reverse().toString();
        answer += "0"+tmp;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] food = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            food[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(food));
    }
}
