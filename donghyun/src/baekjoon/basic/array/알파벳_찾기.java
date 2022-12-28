package baekjoon.basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>B_10809</p>
 */
public class 알파벳_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(s.indexOf(c) + " "); //문자 c의 index 번호를 반환해서 sb에 append
        }
        System.out.println(sb);

    }
}
