package programmers.lv1;

public class 문자열을_정수로_바꾸기 {
    public static int solution(String s) {
        int answer = 0;
        boolean flag = true; //flag가 true인 경우 양수, false면 음수
        int idx = 0;
        for (char tmp : s.toCharArray()) {
            if (!Character.isDigit(tmp)) {
                idx = -1;
                if (tmp == '-') flag = false;
            } else {
                if(idx==0 && tmp=='0') continue;
                answer = answer * 10 + (tmp - '0');
            }

            idx++;
        }

        if(!flag) answer = answer * -1;
        return answer;
    }

    public static void main(String[] args) {
        String str = "-0234";
        System.out.println(solution(str));
    }
}
