package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2001 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			long x1 = s.nextLong();
			long y1 = s.nextLong();
			long x2 = s.nextLong();
			long y2 = s.nextLong();
			
			double res = Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));
			System.out.println(res);
			System.out.printf("%.2f\r\n",res);
		}
	}

}
