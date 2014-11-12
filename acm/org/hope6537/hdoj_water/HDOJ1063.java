package org.hope6537.hdoj_water;

import java.math.BigDecimal;
import java.util.Scanner;

public class HDOJ1063 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			BigDecimal bigDecimal = s.nextBigDecimal();
			int n = s.nextInt();
			BigDecimal c = bigDecimal.pow(n);
			String str = c.toPlainString();
			if (c.toPlainString().contains(".") == false) {
				System.out.println(c);
			} else {
				// 对于索引x和y 从头部和尾部开始遍历
				int x = 0;
				int y = str.length() - 1;
				while (str.charAt(x) == '0') {
					x++;
				}
				while (str.charAt(y) == '0') {
					y--;
				}
				if (str.charAt(y) != '.') {
					y++;
					
				}
				System.out.println(str.substring(x, y));
			}
		}
	}

}
