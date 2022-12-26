package programmers;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int answer = 0;
        int width_max = 0; //가로 최대값
        int height_max = 0; //세로 최대값
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }

            width_max = Math.max(width_max, sizes[i][0]);
            height_max = Math.max(height_max, sizes[i][1]);
        }

        answer = width_max * height_max;

        return answer;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
}
