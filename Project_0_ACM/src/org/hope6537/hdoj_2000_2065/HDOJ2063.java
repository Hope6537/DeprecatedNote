package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe ��ɽ������ �������㷨
 * @Author Hope6537(����)
 * @Signdate 2014-5-3����05:56:04
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2063{

    static Scanner s = new Scanner(System.in);

    /**
     * @Describe ���ڼ�¼������
     */
    static int[][] map = new int[510][510];
    /**
     * @Describe ���ڼ�¼�Ƿ�ռ��
     */
    static int[] flag = new int[510];
    /**
     * @Describe ���ڼ�¼pre[i]������i�����Ů��������
     */
    static int[] pre = new int[510];

    /**
     * @Describe n��Ů���� m�������� num������
     */
    static int n, m, num;

    static int find(int cur) {
        // �ӵ�һ��������ʼ���α���
        for (int i = 1; i <= m; i++) {
            if (map[cur][i] == 1 && flag[i] == 0) {
                // ������������Ժ͸�Ů������һ��ͬʱ������û�б�������ռ���
                flag[i] = 1;// ��������ռ��
                if (pre[i] == 0 || find(pre[i]) == 1) {
                    // ���������û��Ů����ԣ�������˵�͸�������Ե�Ů�������ҵ����� ���Ů�����������ռ��
                    pre[i] = cur;
                    return 1;

                }

            }

        }
        return 0;
    }


    public static void main(String[] args) {
        int girl, boy, sum;
        while (s.hasNext()) {

            sum = 0;
            for (int i = 0; i < map.length; i++) {
                pre[i] = 0;// ���ǳ�ʼ��������Զ�
                for(int j = 0 ; j < map.length ; j++){
                    map[i][j] = 0;
                }
            }
            num = s.nextInt();
            if (num == 0) {
                break;
            }
            n = s.nextInt(); // ��Ů��
            m = s.nextInt(); // ������
            
            for (int i = 0; i < num; i++) {
                girl = s.nextInt();
                boy = s.nextInt();
                map[girl][boy] = 1;// ����ƥ��
            }
            for (int i = 1; i <= n; i++) {
                // Ů��ȥƥ������
                for (int j = 0; j < flag.length; j++) {
                    flag[j] = 0;
                }
                sum += find(i);
            }
            System.out.print(sum+"\r\n");
        }
    }
}