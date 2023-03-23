/*
class Spot {
    int x;
    int y;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

public class SWEA_01 {
    static String[][] node;
    static boolean[][] check;
    static String[] answer;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북{0, 1, 0, -1}
    static int[] dy = {1, 0, -1, 0}; //{1, 0, -1, 0}
    static int R;
    static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            R = sc.nextInt();
            C = sc.nextInt();

            node = new String[R][C];
            check = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                String s = sc.next();
                for (int j = 0; j < C; j++) {
                    node[i][j] = String.valueOf(s.charAt(j));
                    check[i][j] = false;
                }
            }
            check[0][0] = true;
            bfs(0, 0, node);
            System.out.println("#" + test_case + " " + Arrays.stream(answer).filter(Objects::nonNull).count());

        }
    }

    public static void bfs(int x, int y, String[][] s) {
        Queue<Spot> q = new LinkedList<>();
        q.offer(new Spot(x, y));

        int M = 0;
        answer = new String[s.length  s[0].length]; //2  4 = 8
        answer[M] = s[x][y]; // a[0] = "A"

        while (!q.isEmpty()) { //다 순회, 탐색 할 때까지
            Spot spot = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = spot.getX() + dx[i];
                int ny = spot.getY() + dy[i];

                if (nx >= s.length || nx < 0 || ny >= s[nx].length || ny < 0) {
                    continue;
                }
                if (check[nx][ny]) {
                    continue;
                }
                if (s[spot.getX()][spot.getY()].equals(s[nx][ny]) || Arrays.asList(answer).contains(s[nx][ny])) { // s[0][0] equals s[-1][0] (상)
                    //상하좌우 문자열 값이 같다면, 정답 문자열에 포함되어 있다면
                    continue;
                }

                if (!(s[spot.getX()][spot.getY()].equals(s[nx][ny])) && !(Arrays.asList(answer).contains(s[nx][ny]))) {
                    // 상하좌우 문자열 값이 같지 않으면서, 정답 문자열 배열에 포함되지 않았으면
                    M++;
                    answer[M] = s[nx][ny]; // 넣어준다.
                }
                q.offer(new Spot(nx, ny));
                check[nx][ny] = true;
            }
        }
    }
}

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_01 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R;
    static int C;
    static char[][] board;
    static ArrayList<Character> collection;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            board = new char[21][21];
            visited = new boolean[21][21];
            collection = new ArrayList<>(27);

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for (int i = 0; i < R; i++) {
                String data = br.readLine();
                for (int j = 0, k = 0; j < C; j++, k++) {
                    board[i][j] = data.charAt(k);
                }
            }
            ans = 0;
            collection.add(board[0][0]);
            visited[0][0] = true;

            dfs(0, 0, 1);

            System.out.println("#" + test_case + " " + ans);
        }
    }

    static void dfs(int y, int x, int element) {
        ans = Math.max(ans, element);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }

            if (!visited[ny][nx] && !collection.contains(board[ny][nx])) {
                visited[ny][nx] = true;
                collection.add(board[ny][nx]);

                dfs(ny, nx, element + 1);

                collection.remove(element);
                visited[ny][nx] = false;
            }
        }
    }
}

