package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 { //ž

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Stack<int[]> S = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            
            while(!S.isEmpty()) {
                if(S.peek()[1] >= top) {
                    System.out.print(S.peek()[0] + " ");
                    break;
                }
                
                S.pop();
            }
            
            if(S.isEmpty()) {
                System.out.print("0 ");
            }
            
            S.push(new int[] {i, top}); 
        }
    }
}