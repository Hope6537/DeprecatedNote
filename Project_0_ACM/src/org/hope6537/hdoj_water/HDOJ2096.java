package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2096 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            if (n == 0) {
                break;
            }
            while (n-- != 0) {
                long a = s.nextLong();
                long b = s.nextLong();
                long res = (a % 100) + (b % 100);
                res = res % 100;
                System.out.println(res);
            }

        }
    }
}
