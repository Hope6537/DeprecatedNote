package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2070 {

    static Scanner s = new Scanner(System.in);

    
    public static long f(long x){
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        long x_1 = 1;
        long x_2 = 1;
        for(int i = 2 ; i < x ; i++){
            long temp = x_1;
            x_1 = x_1 + x_2;
             x_2 = temp;
        }
        return x_1;
    }
    
    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            if (n == -1) {
                break;
            }else{
                System.out.println(f(n));
            }
            
        }
    }
}
