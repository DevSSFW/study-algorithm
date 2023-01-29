package programmers.lv1;

public class 키패드_누르기 {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;

        for (int x : numbers) {
            if (x == 1 || x == 4 || x == 7) {
                left = x;
                sb.append("L");
            } else if (x == 3 || x == 6 || x == 9) {
                right = x;
                sb.append("R");
            } else {
                if(x==0) x = 11;

                int left_count = Math.abs(x - left) / 3 + Math.abs(x - left) % 3;
                int right_count = Math.abs(x - right) / 3 + Math.abs(x - right) % 3;

                if (left_count == right_count) {
                    if (hand.equals("right")) {
                        right = x;
                        sb.append("R");
                    } else {
                        left = x;
                        sb.append("L");
                    }
                } else if (left_count > right_count) {
                    right = x;
                    sb.append("R");
                } else {
                    left = x;
                    sb.append("L");
                }
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {7,0,8,2,8,3,1,5,7,6,2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }
}
