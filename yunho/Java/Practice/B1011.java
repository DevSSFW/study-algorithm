package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1011 { //Fly me to the Alpha Centauri

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
				
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < t; i++) {			
			
			int count = 0, distance = 0;
			
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int goal = y - x;
			
			distance = (int)Math.sqrt(goal);
			count = distance * 2 - 1;
					
			int a = goal - distance * distance;
					
			count += Math.ceil((double)a / distance);
			
			String result = String.valueOf(count);
			bw.write(result);
			bw.write("\n");
			bw.flush();
		}
		
		bw.close();
	}
}