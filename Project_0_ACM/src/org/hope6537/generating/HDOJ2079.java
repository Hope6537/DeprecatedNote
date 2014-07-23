package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ2079 {
    static int MAX = 1500;
    static int HALF = 500;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        while (s.hasNext()) {
            int T = s.nextInt();
            while (T-- != 0) {
                int n = s.nextInt();
                int k = s.nextInt();
                int[] c1 = new int[MAX];
                int[] c2 = new int[MAX];
                int[] num = new int[HALF];
                int[] value = new int[HALF];
                for (int i = 1; i <= k; i++) {
                    int a = s.nextInt();
                    int b = s.nextInt();
                    value[i] = a;
                    num[i] = b;
                }
                // input done
                
                int length = num[1] * value[1];
                for(int i = 0 ; i <= length ; i++ ){
                    c1[i] = 1;
                }
                for (int m = 2; m <= k; m++) {
                    int i = value[m];
                    for (int j = 0; j <= length; j++) {
                        for (int k1 = 0; k1 <= value[m] * num[m]; k1 += i) {
                            c2[j + k1] += c1[j];
                        }
                    }
                    length += (num[m] * value[m]);
                    for (int j = 0; j <= length; j++) {
                        c1[j] = c2[j];
                        c2[j] = 0;
                    }
                }
                System.out.println(c1[n]);
            }
        }

    }
}