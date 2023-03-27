package programmers;

import java.io.IOException;
import java.util.Arrays;

public class 정렬_K번째수 {
    public static void main(String[] args) throws IOException {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        정렬_K번째수 s = new 정렬_K번째수();
        System.out.println(Arrays.toString(s.solution(array,commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}


