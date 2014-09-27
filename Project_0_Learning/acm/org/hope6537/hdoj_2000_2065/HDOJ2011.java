package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2011 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		for(int i = 0 ; i < count ; i++){
			int n =  s.nextInt();
			double sum = 0;
			for(int j = 1 ; j <= n ; j++){
				double sr = Math.pow(-1, j-1) ;
//				System.out.println(sr);
				sum = (sr / j) + sum  ; 
			}
			System.out.printf("%.2f\r\n",sum);
		}
	}

}
