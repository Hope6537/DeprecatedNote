package org.hope6537.hdoj_water;

import java.util.Scanner;

/**
 * @Describe 由斯特林[striling]公式可得：lnN!=NlnN－N+0.5ln(2N*pi)
 *           而N的阶乘的位数等于：log10(N!)取整后加1 log10(N!)=lnN!/ln(10) 所以len=lnN!/ln(10)+1
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-21下午07:06:19
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1018 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int t = s.nextInt();
			while (t-- != 0) {

				long n = s.nextInt();
				if (n == 0) {
					break;
				}
				double pi = Math.acos(-1.0);
				double res = (n * Math.log(n) - n + (0.5 * Math.log(2 * n * pi)))
						/ Math.log(10);
				double sum = (n * Math.log(n) - n + 0.5 * Math.log(2 * n * pi))
						/ Math.log(10);

				System.out.println((int) res + 1);
			}
		}
	}

}
