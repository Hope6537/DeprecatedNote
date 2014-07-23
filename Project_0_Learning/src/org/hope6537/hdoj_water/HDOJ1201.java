package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1201 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				String bDate = s.next();
				String[] strs = bDate.split("-");
				int year = Integer.parseInt(strs[0]);
				int month = Integer.parseInt(strs[1]);
				int day = Integer.parseInt(strs[2]);
				int sum = 0;
				int x = 0;
				if(month==2&&day==29)
				{
					System.out.printf("-1\r\n");
				    continue;
				}
				if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
						&& month < 3)
					sum++;
				x = year + 18;
				if ((x % 4 == 0 && x % 100 != 0 || x % 400 == 0) && month >= 3)
					sum++;
				for (int i = year + 1; i < year + 18; i++)
					if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
						sum++;
				System.out.printf("%d\r\n", 365 * 18 + sum);

			}
		}
	}
}
