package programmers.lv1_2;

public class 타겟_넘버 {
    public static void main(String[] args){
        int[] n ={1,1,1,1,1};
        int answer = solution(n,3);
        System.out.println(answer);
    }
    public static int solution(int[] numbers, int target) { //{}, 3
        return dfs(numbers, target, 0, 0);
    }

    public static int dfs(int[] numbers, int target, int temp, int start){
        int answer = 0;
        if(start == numbers.length){
            if(temp == target){
                return 1;
            }
            return 0;
        }
        answer += dfs(numbers, target, temp + numbers[start], start+1);
        answer += dfs(numbers, target, temp + numbers[start] * -1, start+1);

        return answer;
    }
}
