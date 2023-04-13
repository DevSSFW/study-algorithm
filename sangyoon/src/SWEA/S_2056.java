package SWEA;

import java.util.Scanner;

public class S_2056 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int test_case = 1; test_case <= T; test_case++) {
            String day = sc.next();
            String year = day.substring(0, 4);
            String month = day.substring(4, 6);
            String date = day.substring(6, 8);

            if (Integer.parseInt(year) <= 0 ) System.out.println("#" + test_case + " -1");
            else if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) System.out.println("#" + test_case + " -1");
            else if (Integer.parseInt(date) > days[Integer.parseInt(month) - 1] || Integer.parseInt(date) <= 0) System.out.println("#" + test_case + " -1");
            else System.out.println("#" + test_case + " " + year + "/" + month + "/" + date);
        }
    }
}
