package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2060{
    
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        //yellow(2 point), green(3 point), brown(4 point), blue(5 point), pink(6 point), black(7 point), 
        int REDBALL = 1;
        int YELLOW = 2;
        int GREEN = 3;
        int BLOWN = 4;
        int BLUE = 5;
        int PINK = 6;
        int BLACK = 7;
        int HIGH = YELLOW + GREEN + BLOWN + BLUE + PINK + BLACK;
        int [] COLORBALL = {7,6,5,4,3,2};
        while(s.hasNext()){
            int n = s.nextInt();
            for(int k = 0 ; k < n ; k++){
                int left = s.nextInt();
                int p_s = s.nextInt();
                int o_s = s.nextInt();
                if(left>6){
                    int redball = left - 6;
                    p_s = p_s + REDBALL * redball + BLACK * redball + HIGH;
                    
                }else{
                     for(int i = 0 ; i < left ; i++){
                         p_s = p_s + COLORBALL[i];
                     }
                }
                
                if(p_s>=o_s){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
            
        }
    }
}
