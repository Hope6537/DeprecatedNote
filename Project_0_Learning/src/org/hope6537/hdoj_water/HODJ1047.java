package org.hope6537.hdoj_water;

import java.math.BigDecimal;
import java.util.Scanner;

public class HODJ1047 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		while (s.hasNext()) {
			BigDecimal bigDecimal1 = s.nextBigDecimal();
			BigDecimal bigDecimal2 = s.nextBigDecimal();
			String str = bigDecimal1.add(bigDecimal2).toPlainString();
			if (str.contains(".") == false) {
				System.out.println(str);
			} else {
				int x = 0;
				int y = str.length() - 1;

				while (str.charAt(y) == '0') {
					y--;
				}
				if (str.charAt(y) != '.') {
					y++;
				}
				System.out.println(str.substring(x, y));
			}}
	}
}
