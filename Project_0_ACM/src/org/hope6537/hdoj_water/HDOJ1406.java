package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1406 {

    static Scanner s = new Scanner(System.in);

    public static int wanshu(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n ? 1 : 0;
    }

    public static void main(String[] args) {
        /*for(int i = 1 ; i <= 1000 ; i++){
            if(wanshu(i)==1)System.out.println(i);
        }*/
    	
        while (s.hasNext()) {
            int n = s.nextInt();
            while (n-- != 0) {
                int num1 = s.nextInt();
                int num2 = s.nextInt();
                if (num1 > num2) {
                    int temp = num2;
                    num2 = num1;
                    num1 = temp;
                }
                int count = 0;
                for (int i = num1; i <= num2; i++) {
                    count += wanshu(i);
                }
                System.out.println(count);
            }

        }
    }
}