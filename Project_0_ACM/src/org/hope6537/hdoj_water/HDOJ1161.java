package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1161 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			String str = s.nextLine();
			for (int i = 0; i < str.length(); i++) {
				 char c = str.charAt(i);
				 if(c>='A' && c<='Z'){
					 c += 32;
				 }
				 System.out.print(c);
			}
			System.out.println();
		}
	}

}
