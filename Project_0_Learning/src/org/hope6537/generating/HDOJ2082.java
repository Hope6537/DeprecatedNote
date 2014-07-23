package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ2082 {
    static int MAX = 55;
    static int HALF = 1;
    static Scanner s = new Scanner(System.in);

    public static void insertionSort(int[] a) {
        int j = 0;
        for (int p = 1; p < a.length; p++) {
            // �ӵڶ���Ԫ�ؿ�ʼ��β��
            int tmp = a[p]; // Ȼ���ȡ��p��Ԫ��
            for (j = p; j > 0 && tmp > (a[j - 1]); j--) {
                // ����ѭ�� j��������p��ʼ ��j-1Ԫ�ش���jԪ��ʱ ����
                a[j] = a[j - 1];
            }
            // �������������
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {

        while (s.hasNext()) {
            int n = s.nextInt();
            while (n-- != 0) {
                int[] c1 = new int[MAX];
                int[] c2 = new int[MAX];
                int[] values = new int[27];
                for (int i = 1; i <= 26; i++) {
                    values[i] = s.nextInt();
                }
                for (int i = 0; i <= 50 && i<=values[1]; i++) {
                    c1[i] = 1;
                }
                c1[values[0]] = 1;
                // input done
                for (int i = 2; i <= 26; ++i) {
                    for (int j = 0; j <= 50; ++j) {
                        for (int k = 0; k + j <= 50 && k <= i * values[i]; k += i) {
                            c2[j + k] += c1[j];
                        }

                    }
                    for (int j = 0; j <= 50; ++j) {
                        c1[j] = c2[j];
                        c2[j] = 0;
                    }
                }
                // ��֤��С�������

                int sum = 0;
                for (int i = 1; i <= 50; i++) {
                    sum += c1[i];
                }
                System.out.println(sum);
            }

        }

    }
}