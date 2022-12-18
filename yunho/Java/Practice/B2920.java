package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2920{ //À½°è
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int countA = 0, countD = 0, count = 0;
        int i = 0, size = s.length();
        
        while(i < s.length()) {
        	if(s.charAt(i) == ' ') size--;
        	i++;
        }
        
        i = 0;
        while(i < s.length()){
            if(s.charAt(i) == 32) {
                i++;
                continue;
            }
            if(s.charAt(i) == Character.forDigit(count + 1, 10)) {
            	countA++;
            	if(count + 1 == size - count) countD++;
            }
            else if(s.charAt(i) == Character.forDigit(size - count, 10)) countD++;
            i++;
            count++;
        }
        
        if(countA == size) System.out.println("ascending");
        else if(countD == size) System.out.println("descending");
        else System.out.println("mixed");
    }
}