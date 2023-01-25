package baekjoon.Intro.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱_난쟁이 {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int spyA = 0, spyB = 0;
        int[] smallThing = new int[9];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int index = 0; index < smallThing.length; index++) {
            smallThing[index] = Integer.parseInt(reader.readLine());
            sum += smallThing[index];
        }
        Arrays.sort(smallThing);

        for (int a = 0; a < smallThing.length - 1; a++) {
            for (int b = a + 1; b < smallThing.length; b++) {
                if (sum - smallThing[a] - smallThing[b] == 100) {
                    spyA = a;
                    spyB = b;
                    break;
                }
            }
        }
        for (int j = 0; j < smallThing.length; j++) {
            if (j == spyA || j == spyB) {
                continue;
            }
            System.out.println(smallThing[j]);
        }
        reader.close();
    }
}