package org.hope6537.hdoj_water;

import java.util.Scanner;

/**
 * @Describe 为自行解决学费，chx勤工俭学收入10000元以1年定期存入银行，年利率为3.7% 。利率
 *           按年计算，表示100元存1年的利息为3.7元.实际上有时提前有时推迟取，因此实际利息按天 计算，1年按365天计算，因此Q天的利息是
 *           本金*3.7/100 *Q/365 存了100天后1年定期年利息提高到3.9%。如将存款提前全取出，再存1年定期。那么前面的
 *           100天只能按活期利息1.7%计算。 100天的利息和本金：10000（1+1.7/100*100/365)=10046.6
 *           再存1年定期 ：10046.6(1+3.9/100)=10438.4 得到的利息加本金为10438.4
 *           如果无视利息的提高，再存1年。得到的利息加本金为（定期推迟取，利率不变）
 *           10000（1+3.7/100*（100+365）/365)=10471.4
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-17下午12:56:06
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
                 * Y-存入的本金<=100000, Q-已存天数<=365,e-活期利率,f-定期利率,g-提高后的定期利率
                 */
                double Y = s.nextDouble();
                int Q = s.nextInt();
                double e = s.nextDouble();
                double f = s.nextDouble();
                double g = s.nextDouble();
                /* output
                 * 每组数据输出2行. 第1行,提前支取后再存1年所得本金和利息. 第2行,继续存1年,Q+365天后所得本金和利息.
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
