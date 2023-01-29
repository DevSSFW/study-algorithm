package programmers.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 과일_장수 {
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        reverseOrder(score);
        int n = score.length/m;
        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=i*m; j<(i*m)+m; j++){
                if(min > score[j]) min = score[j];
            }
            answer += min*m;
        }

        return answer;
    }

    public static void reverseOrder(int[] score) {
        Arrays.sort(score);
        for(int i=0; i<score.length/2; i++){
            int tmp = score[i];
            score[i] = score[score.length - i - 1];
            score[score.length - i - 1] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] score = {4,1,2,2,4,4,4,4,1,2,4,2};

        System.out.println(solution(k, m, score));
    }
}
