package programmers.lv1_2;

import java.io.*;
import java.util.*;

public class 자동완성 { //Lv.3
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        System.out.println(solution(words));
    }

    public static int solution(String[] words) throws Exception {
        int answer = 0;
        Arrays.sort(words);
        int[] counts = new int[words.length]; //3

        for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String next = words[i + 1];
            int len = Math.min(pre.length(), next.length()); // 길이가 작은 문자열 //4
            int sameCount = getSameCount(pre, next, len);  //같은 문자 수 카운트 //1

            if (len == sameCount) {
                counts[i] = Math.max(counts[i], sameCount); //counts[0] = 2;
            } else {
                counts[i] = Math.max(counts[i], sameCount + 1); //counts[1] = 3;
            }
            counts[i + 1] = Math.max(counts[i + 1], sameCount + 1); //count[1] = 3; , count[2] = 2;
        }

        for (int count : counts) {
            answer += count;
        }
        return answer;
    }

    public static int getSameCount(String pre, String next, int len) {
        int count = 0;
        for (int j = j = 0; j < len; j++) {
            if (pre.charAt(j) != next.charAt(j)) {
                return count;
            }
            count++;
        }
        return count;
    }
}
