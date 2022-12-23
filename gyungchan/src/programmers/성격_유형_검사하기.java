package programmers;

import java.util.HashMap;

public class 성격_유형_검사하기 {

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('R', 0);
        hash.put('T', 0);
        hash.put('C', 0);
        hash.put('F', 0);
        hash.put('J', 0);
        hash.put('M', 0);
        hash.put('A', 0);
        hash.put('N', 0);

        for (int i = 0; i < choices.length; i++) {
            char[] ch = survey[i].toCharArray();
            switch (choices[i]) {
                case 1:
                    hash.put(ch[0], hash.get(ch[0])+3);
                    break;
                case 2:
                    hash.put(ch[0], hash.get(ch[0])+2);
                    break;
                case 3:
                    hash.put(ch[0], hash.get(ch[0])+1);
                    break;
                case 4:
                    break;
                case 5:
                    hash.put(ch[1], hash.get(ch[1])+1);
                    break;
                case 6:
                    hash.put(ch[1], hash.get(ch[1])+2);
                    break;
                case 7:
                    hash.put(ch[1], hash.get(ch[1])+3);
                    break;
            }
        }

        if(hash.get('R') >= hash.get('T')) answer += "R";
        else answer += "T";

        if(hash.get('C') >= hash.get('F')) answer += "C";
        else answer += "F";

        if(hash.get('J') >= hash.get('M')) answer += "J";
        else answer += "M";

        if(hash.get('A') >= hash.get('N')) answer += "A";
        else answer += "N";

        return answer;
    }

    public static void main(String[] args) {

        String[] str = {"AN", "CF", "MJ", "RT", "NA"};
        int[] arr = {5, 3, 2, 7, 5};
        System.out.println(solution(str, arr));
    }
}
