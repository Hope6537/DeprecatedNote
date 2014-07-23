package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ1085 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();
            int n3 = s.nextInt();
            int[] num = { 0, n1, n2, n3 };
            int max = n1 * 1 + n2 * 2 + n3 * 5;
            if (n1 == 0 && n2 == 0 && n3 == 0) {
                break;
            }

            int c1[] = new int[100100];
            int c2[] = new int[100100];
            for (int i = 0; i <= max; i++) // 首先对于第一个多项式进行初始化 都是1
            {
                c1[i] = 0;
                c2[i] = 0;
            }
            for(int i = 0 ; i <= n1 ; i++){
                c1[i] = 1;
            }
            for (int i = 0; i <= n1; i++) {
                for (int j = 0; j <= n2 * 2; j += 2) {
                    c2[j + i] += c1[i];
                }
            }
            for (int i = 0; i <= n2 * 2 + n1; i++) {
                c1[i] = c2[i];
                c2[i] = 0;
            }
            
            for(int i = 0 ; i <=  n2 * 2 + n1 ; i++){
                for(int j  = 0 ; j <= n3  * 5 ; j+=5){
                    c2[i+j] += c1[i];
                }
            }
            for(int i = 0 ; i <= max ; i++){
                c1[i] = c2[i];
                c2[i] = 0;
            }
            int i;
            for(i = 0 ; i <= max ; i++){
                if(c1[i] == 0){
                    System.out.println(i);
                    break;
                }
            }
            if(i>=max+1){
                System.out.println(i);
            }
            
        }
    }
}