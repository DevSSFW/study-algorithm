package baekjoon.basic.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱_난쟁이 {
    public static void main(String[] args) {


    }

    private static void getSmallThing() throws IOException {
        int sum = 0;
        int[] smallThing = new int[9];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int index = 0; index < smallThing.length; index++) {
            smallThing[index] = Integer.parseInt(reader.readLine());
            sum += smallThing[index];
        }
        Arrays.sort(smallThing);
    }
    private static void searchNotSmallThing(){
        int nota;
        int notb;
    }
}
