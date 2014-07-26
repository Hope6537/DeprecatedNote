package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2503{

    static Scanner s = new Scanner(System.in);

    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            while (n-- != 0) {
                int a = s.nextInt();
                int b = s.nextInt();
                int c = s.nextInt();
                int d = s.nextInt();
                int fenmu = 0;
                int fenzi = 0;
                if(b==d){
                    fenmu = b;
                    fenzi = a+c;
                }
                else{
                    fenmu = (int) lcm(b, d);
                    fenzi = a * (fenmu/b) + c * (fenmu/d);
                }
                //算出了分数，开始化简
                int gcd = (int) gcd(fenmu, fenzi);
                int lcm = (int) lcm(fenzi, fenmu);
                if(gcd!=1){
                    fenzi = fenzi / gcd;
                    fenmu = fenmu / gcd;
                }
                System.out.println(fenzi + " " + fenmu);
            }

        }
    }
}
