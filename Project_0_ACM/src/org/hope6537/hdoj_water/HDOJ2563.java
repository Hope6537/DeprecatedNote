package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2563 {

	public static int f(int i) {
		if (i == 1) {
			return 3;
		} else if (i == 2) {
			return 7;
		} else {
			return f(i - 1) * 2 + f(i - 2);
		}
	}
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int C = s.nextInt();
			while(C--!=0){
				System.out.println(f(s.nextInt()));
			}
		}
	}
	

}
