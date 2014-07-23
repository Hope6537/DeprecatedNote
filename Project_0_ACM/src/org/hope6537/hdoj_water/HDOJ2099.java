package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2099 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String[] wei = new String[100];
        for (int i = 0; i < 100; i++) {
            wei[i] = i / 10 + "" + i % 10;
        }
        while (s.hasNext()) {
            String a = s.next();
            int b = s.nextInt();
            if(a.equals("0")&&b==0){
                break;
            }
            int flag = 0;
            for (int i = 0; i < 100; i++) {
                int temp = Integer.parseInt(a + wei[i]);
                if (temp % b == 0) {
                    if (flag == 1) {
                        System.out.print(" ");
                    }
                    System.out.print(wei[i]);
                    flag = 1;
                }
            }
            System.out.println();
        }
    }
}