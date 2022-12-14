package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 옹알이 {

    public static int solution(String[] babbling) {
        int answer = 0;
        for (String x : babbling) {
            if (x.equals("aya") || x.equals("ye")
                    || x.equals("woo") || x.equals("ma")) {
                answer++;
            }
            else {
                String tmp = x;
                String check = "";
                boolean bool = true;
                while (bool) {
                    char c = tmp.charAt(0);
                    int check_length = check.length();
                    switch (c) {
                        case 'a':
                            check += "aya";
                            break;
                        case 'y':
                            check += "ye";
                            break;
                        case 'w':
                            check += "woo";
                            break;
                        case 'm':
                            check += "ma";
                            break;
                        default:
                            bool = false;
                            break;
                    }
                    if (check.length() >= x.length()) break;
                    tmp = tmp.substring(check.length() - check_length);
                    if (c == tmp.charAt(0)) break;
                }
                if (check.equals(x)) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] str = new String[st.countTokens()];
        for (int i = 0; i < str.length; i++) {
            str[i] = st.nextToken();
        }

        System.out.println(solution(str));
    }
}
