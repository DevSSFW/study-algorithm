package baekjoon.basic.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>B_2751</p>
 */
public class 수_정렬하기2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>(); //Collections -> O(nlogn), O(logN)을 보장

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for (int j : list) {
            bw.write(j + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
