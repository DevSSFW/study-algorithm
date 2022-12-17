package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164 { //Ä«µå2

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 1; i <= n; i++) Q.add(i);
		
		while(Q.size() > 1) {
			Q.remove();
			Q.add(Q.remove());
		}
		
		System.out.println(Q.remove());
	}
}