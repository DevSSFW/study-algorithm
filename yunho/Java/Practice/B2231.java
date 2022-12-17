package Practice;

import java.util.Scanner;

public class B2231{ //ºÐÇØÇÕ
    public static void main(String[] args){
    	// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int i = 1;
        for(; i < n; i++){
            int sum = i, d = i;
            
            do {
                int p = d % 10;
                d /= 10;
                sum += p;
            }while(d > 0);
            
            if(sum == n){
                System.out.println(i);
                break;
            }
        }
        if(i == n) System.out.println(0);
    }
}