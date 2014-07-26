package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1005{

    public static long f(long A, long B, long n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            long x_1 = 1;
            long x_2 = 1;
            for (long i = 3; i <= n; i++) {
                long temp = (A * x_1 + B * x_2) % 7;
                x_2 = x_1;
                x_1 = temp;
            }
            return x_1;
        }
    }
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        while(s.hasNext()){
            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();
            if (a == b && b == n && a == 0) {
                break;
            }
            long [] arr = new long[50];
            for(int i = 1 ; i < 50 ; i ++){
                arr[i] = f(a,b,i);
            }
            System.out.println(arr[n%49]);
        }
        
        
    }
}
