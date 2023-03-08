import java.io.*;
import java.util.*;


public class Example {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Char To Int;
        char myChar = '3';
        int myInt = Character.getNumericValue(myChar);
        /*
        // String To Char;
        String myString = "apple";
        //1번 방법
        char[] myChars = myString.toCharArray();
        //2번 방법
        for (char c : myString.toCharArray()) {
            System.out.println(c);
        }*/

        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        // 배열 자르기
        arr = Arrays.copyOfRange(arr, 0, 4);
        // 배열 요소 모두 더하기, 총합
        int sum = Arrays.stream(arr).sum();
        //중복 값 제거
        Arrays.stream(arr).distinct().toArray();


        //백트래킹 문제 대표예제 N-Queen
        //상태 공간 트리란 초기 상태에서 목적 상태에 이르는 모든 상태들의 전이 가능 관계를 나타낸 트리이다.
        //백트래킹은 각 상태 노드에서 해가 될 가능성이 없을 경우 자식 노드로 더 이상 탐색을 진행하지 않음
        // BFS
        //


    }
}
