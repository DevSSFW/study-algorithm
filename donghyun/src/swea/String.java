package swea;

import java.util.Scanner;

public class String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        int answer = 0;

        for (int i = 0; i < T; i++) {
            int number = sc.nextInt();
            java.lang.String str = sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();

            for (int j = 0; j < arr.length - str.length() + 1; j++) { //문장길이 5, 단어 2, -1 = 4(0,1,2,3)
                if (arr[j] == str.charAt(0)) {
                    answer += 1;
                    for (int k = 1; k < str.length(); k++) {
                        if (arr[j + k] != str.charAt(j)) {
                            answer -= 1;
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}
