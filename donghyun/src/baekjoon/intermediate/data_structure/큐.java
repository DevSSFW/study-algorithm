package baekjoon.intermediate.data_structure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * B_10845
 */
public class 큐 {
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        String back = "";

        for (int T = 0; T < N; T++) {
            arr = br.readLine().split(" ");

            switch (arr[0]) {
                case "push":
                    back = arr[1];
                    q.offer(back);

                    break;
                case "pop":
                    bw.write(q.isEmpty() ? "-1" + "\n" : q.poll() + "\n");

                    break;
                case "size":
                    bw.write(q.size() + "\n");

                    break;
                case "empty":
                    bw.write(q.isEmpty() ? "1" + "\n" : "0" + "\n");

                    break;
                case "front":
                    bw.write(q.isEmpty() ? "-1" + "\n" : q.peek() + "\n");
                    break;
                case "back":
                    bw.write(q.isEmpty() ? "-1" + "\n" : back + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
