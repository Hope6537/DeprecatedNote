package org.hope6537.hdoj_water;

import java.util.Scanner;

/**
 * @Describe Ϊ���н��ѧ�ѣ�chx�ڹ���ѧ����10000Ԫ��1�궨�ڴ������У�������Ϊ3.7% ������
 *           ������㣬��ʾ100Ԫ��1�����ϢΪ3.7Ԫ.ʵ������ʱ��ǰ��ʱ�Ƴ�ȡ�����ʵ����Ϣ���� ���㣬1�갴365����㣬���Q�����Ϣ��
 *           ����*3.7/100 *Q/365 ����100���1�궨������Ϣ��ߵ�3.9%���罫�����ǰȫȡ�����ٴ�1�궨�ڡ���ôǰ���
 *           100��ֻ�ܰ�������Ϣ1.7%���㡣 100�����Ϣ�ͱ���10000��1+1.7/100*100/365)=10046.6
 *           �ٴ�1�궨�� ��10046.6(1+3.9/100)=10438.4 �õ�����Ϣ�ӱ���Ϊ10438.4
 *           ���������Ϣ����ߣ��ٴ�1�ꡣ�õ�����Ϣ�ӱ���Ϊ�������Ƴ�ȡ�����ʲ��䣩
 *           10000��1+3.7/100*��100+365��/365)=10471.4
 * @Author Hope6537(����)
 * @Signdate 2014-5-17����12:56:06
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1994 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            while (n-- != 0) {
                /*
                 * input 
                 * Y-����ı���<=100000, Q-�Ѵ�����<=365,e-��������,f-��������,g-��ߺ�Ķ�������
                 */
                double Y = s.nextDouble();
                int Q = s.nextInt();
                double e = s.nextDouble();
                double f = s.nextDouble();
                double g = s.nextDouble();
                /* output
                 * ÿ���������2��. ��1��,��ǰ֧ȡ���ٴ�1�����ñ������Ϣ. ��2��,������1��,Q+365������ñ������Ϣ.
                 */
                double cash1_pre = Y *(1+e/100*Q/365);
                double cash1 = cash1_pre*(1+g/100);
                System.out.printf("%.1f\r\n",cash1);
                double cash2 = Y*(1+f/100*(Q+365)/365);
                System.out.printf("%.1f\r\n",cash2);
            }
        }
    }

}