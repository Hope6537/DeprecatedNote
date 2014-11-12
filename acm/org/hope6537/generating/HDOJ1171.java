package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ1171 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            if (n < 0) {
                break;
            }
            int[] num = new int[n + 1];
            int[] value = new int[n + 1];
            int maxValue = 0;
            for (int i = 1; i <= n; i++) {
                value[i] = s.nextInt();
                num[i] = s.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                maxValue += value[i] * num[i];
            }
            int c1[] = new int[250010];
            int c2[] = new int[250010];
            for (int i = 0; i <= maxValue; i++) {
                c1[i] = 0;
                c2[i] = 0;
            }
            for (int i = 0; i <= num[1] * value[1]; i += value[1]) {
                c1[i] = 1;
            }
            int length = value[1] * num[1];
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= length/* value[i - 1] * num[i - 1] */; j++) {
                    for (int k = 0; k /* + j */<= (value[i] * num[i])
                    /* + (value[i - 1] * num[i - 1]) */; k += value[i]) {
                        c2[j + k] += c1[j];
                    }

                }
                length += num[i] * value[i];
                for (int j = 0; j <= length /*
                                             * (value[i] * num[i]) + (value[i -
                                             * 1] * num[i - 1])
                                             */; j++) {
                    c1[j] = c2[j];
                    c2[j] = 0;
                }
            }

            int half = maxValue / 2;

            for (int i = half; i >= 0; i--) {
                if (c1[i] != 0) {
                    System.out.print((maxValue - i) + " " + i + "\r\n");
                    break;
                }
            }

        }
    }
}
