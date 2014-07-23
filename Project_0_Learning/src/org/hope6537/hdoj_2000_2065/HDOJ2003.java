package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2003 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			double i = s.nextDouble();
			System.out.printf("%.2f\r\n",Math.abs(i));
		}
	}
}
