package programmers.lv1_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 단어 s를 받는다
 * 가운데 글자를 반환한다.
 * 단어의 길이가 짝수라면 가운데 두글자를 반환한다.
 */
public class 가운데_글자_가져오기 {
    public static String solution(String s) throws Exception {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split("");

        if (arr.length % 2 == 0) {
            sb.append(arr[arr.length / 2 - 1]).append(arr[arr.length / 2]); //
        } else {
            sb.append(arr[arr.length / 2]);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine(); // abcde

        String answer = solution(s);

        bw.write(answer);
        bw.flush();
        bw.close();

    }
}