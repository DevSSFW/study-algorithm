package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B3955Me { //Äµµð ºÐ¹è
	
	static ArrayList<Long> t = new ArrayList<>();
	static ArrayList<Long> q = new ArrayList<>();
	static ArrayList<Long> r = new ArrayList<>();
	static String result = "IMPOSSIBLE";
	static boolean wasOther = false;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long k = Long.parseLong(st.nextToken());
			if(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			long c = Long.parseLong(st.nextToken());
			long iniK = k;
			wasOther = false;
			
			if(c == 1 && k < 1e9) {
				System.out.println(k + 1);
				continue;
			}
			if(k == 1) {
				System.out.println(1);
				continue;
			}
			
			if(k % c == 0) System.out.println("IMPOSSIBLE");
			else{
				if(c == 2) {
					System.out.println((k + 1) / 2);
					continue;
				}
				k = InitialValue(k, c, iniK);			
					
				if(r.get(1) == 0) {
					System.out.println(result);
					continue;
				}
				else if(r.get(1) == 1) {
					isEqual(k, c, 1);
					System.out.println(result);
					continue;
				}
				
				int j = 2;
				
				while(result.equals("IMPOSSIBLE")) {
					q.add(r.get(j - 2) / r.get(j - 1));
					r.add(r.get(j - 2) % r.get(j - 1));
					t.add(t.get(j - 2) - t.get(j - 1) * q.get(j));
					
					if(r.get(j) <= 1) {
						if(r.get(j) == 1) {
							if(j % 2 == 0) {
								k += iniK;
								wasOther = true;
								k = InitialValue(k, c, iniK);
								j = 1;
							}
							else {
								isEqual(k, c, j);
								break;
							}
						}
						else {
							if(wasOther) {
								k += iniK;
								k = InitialValue(k, c, iniK);
								j = 1;
							}
							else break;
						}
						if(t.get(j) > 1e9) break;
					}
					j++;
				}				
				
				System.out.println(result);
			}
		}
	}
	
	public static void isEqual(long k, long c, int j) {
		if(t.get(j) <= 1e9) result = Long.toString(t.get(j));			
	}
	
	public static long InitialValue(long k, long c, long iniK) {
		t.clear(); r.clear(); q.clear();
		result = "IMPOSSIBLE";
		
		if(wasOther && k % c == 0) k += iniK;
		
		r.add(k % c); r.add(c % r.get(0));
		q.add(k / c); q.add(c / r.get(0));
		t.add(-q.get(0)); t.add(1 + q.get(0) * q.get(1));
		if(r.get(0) == 1) {
			k += iniK;
			wasOther = true;
			InitialValue(k,c, iniK);
		}
		else if(r.get(1) == 0 && wasOther) {
			k += iniK;
			InitialValue(k,c, iniK);
		}
		else if(r.get(1) == 1) isEqual(k, c, 1);
		
		return k;
	}
}