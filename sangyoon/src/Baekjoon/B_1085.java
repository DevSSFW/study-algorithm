package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int dist = 1000;

        if (dist >= w - x) dist = w - x;
        if (dist >= w - (w -x)) dist = w - (w - x);
        if (dist >= h - y) dist = h - y;
        if (dist >= h - (h - y)) dist = h - (h - y);

        System.out.println(dist);
    }
}
