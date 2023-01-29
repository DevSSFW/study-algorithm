package programmers.lv1;

public class 핸드폰_번호_가리기 {
    public static String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone_number.length() - 4; i++) {
            sb.append("*");
        }
        phone_number = phone_number.substring(phone_number.length() - 4);
        sb.append(phone_number);
        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        String phone_number = "01033334444";

        System.out.println(solution(phone_number));
    }
}
