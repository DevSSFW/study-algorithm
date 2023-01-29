package programmers.lv1;

public class 비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            str1 = makeSameLength(n, str1);
            str2 = makeSameLength(n, str2);

            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) == '1' || str2.charAt(j) == '1') {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }

    private static String makeSameLength(int n, String str) {
        while (str.length() < n) {
            str = "0" + str;
        }
        return str;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        for (String str : solution(n, arr1, arr2)) {
            System.out.println(str);
        }
    }
}
