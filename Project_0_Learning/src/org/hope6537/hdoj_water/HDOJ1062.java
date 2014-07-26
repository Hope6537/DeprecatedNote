package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1062 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int T = Integer.parseInt(s.nextLine());
		while (T-- != 0) {
			String str = s.nextLine();
			str += "#1";
			str = str.replace(' ', '#');
			String[] strs = str.split("#");
			int flag = 0;
			for (int i = 0; i < strs.length-1; i++) {
				String string = strs[i];
				
				if (flag == 1) {
					System.out.print(" ");
				}
				flag = 1;
				for (int j = string.length() - 1; j >= 0; j--) {
					System.out.print(string.charAt(j));
				}

			}
			System.out.println();

		}
	}
}
