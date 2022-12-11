package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장_가까운_같은_글자 {

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            if(s.indexOf(s.charAt(i)) == i) {
                answer[i] = -1;
            }
            else {
                for(int j=i-1; j>=0; j--) {
                    if(s.charAt(j) == s.charAt(i)) {
                        answer[i] = i-j;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int x : solution(s)) {
            System.out.print(x + " ");
        }
    }
}
