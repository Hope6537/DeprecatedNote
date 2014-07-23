package org.hope6537.hdoj_water;

import java.util.Scanner;
import java.util.Stack;

public class HDOJ2097 {

    static Scanner s = new Scanner(System.in);

    public static String ten_to_sixth(int n, int mode) {
        int a[] = new int[10];
        int i = 0;
        String res = "";
        for (i = 0; n > 0; i++) {
            a[i] = n % mode;
            n = n / mode;
        }
        while (i-- > 0) {
            if (a[i] < 10) {
                res += a[i];
            } else {
                res += (char) (a[i] + 55);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        while (s.hasNext()) {
            Integer n = s.nextInt();
            if(n==0){
                break;
            }
            String n0 = n.toString();
            String n1 = ten_to_sixth(n, 16);
            String n2 = ten_to_sixth(n, 12);
            int sum0 = 0;
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n0.length(); i++) {
                sum0 += Integer.parseInt((n0.charAt(i) + ""));
            }
            for (int i = 0; i < n1.length(); i++) {
                char c = n1.charAt(i);
                if (c >= 'A') {
                    sum1 += (int) c - 55;
                } else {
                    sum1 += Integer.parseInt((n1.charAt(i) + ""));
                }
            }
            for (int i = 0; i < n2.length(); i++) {
                char c = n2.charAt(i);
                if (c >= 'A') {
                    sum2 += (int) c - 55;
                } else {
                    sum2 += Integer.parseInt((n2.charAt(i) + ""));
                }
            }
            if (sum1 == sum2 && sum2 == sum0) {
                System.out.println(n+" is a Sky Number.");
            }else{
                System.out.println(n+" is not a Sky Number.");
            }
        }
    }
}