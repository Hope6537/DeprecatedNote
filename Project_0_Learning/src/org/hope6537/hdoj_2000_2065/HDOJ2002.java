package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2002 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double PI = 3.1415927;
		while(s.hasNext()){
			double r = s.nextDouble();
			r = r*r*r;
			double res = r*PI*(4.0/3.0);
			System.out.printf("%.3f\r\n",res);
		}
	}
}
