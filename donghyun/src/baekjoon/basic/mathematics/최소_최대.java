package baekjoon.basic.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * <p>B_10818</p>
 */
public class 최소_최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int max = -1000001;
        int min = 1000001;

        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            if(val>max) {
                max = val;
            }
            if(val<min) {
                min = val;
            }
        }
        System.out.println(min + " " + max);
    }
}
