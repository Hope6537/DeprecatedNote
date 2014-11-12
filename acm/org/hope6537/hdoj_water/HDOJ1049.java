package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1049 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            int u = s.nextInt();
            int d = s.nextInt();
            if(n==u && u==d && n == 0){
                break;
            }
            int min = 0;
            while(n>0){
                if(min % 2 == 0){//童鞋 你该爬起来了
                    n = n - u;
                    min++;
                }
                else{
                    n = n + d;
                    min++;
                }
            }
            System.out.println(min);
        }
    }
}
