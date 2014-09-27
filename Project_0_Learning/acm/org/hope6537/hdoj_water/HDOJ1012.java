package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1012 {

	static Scanner s = new Scanner(System.in);

	public static long jiecheng(long x) {
		if (x == 1) {
			return 1;
		} else {
			int x_1 = 1;
			for (int i = 2; i <= x; i++) {
				x_1 = x_1 * i;
			}
			return x_1;
		}
	}

	public static double e(int n){
		
		if(n==0){
			return 1;
		}
		else if(n==1){
			return 2;
		}
		else if(n==2){
			return 2.5;
		}
		else{
			double sum = 2.5;
			for(int i = 3 ; i <= n ; i ++){
				sum  += (1*1.0/jiecheng(i));
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		System.out.println("n e");
		System.out.println("- -----------");
		System.out.println("0 "+(int)e(0));
		System.out.println("1 "+(int)e(1));
		System.out.println("2 "+e(2));
		for (int i = 3; i <= 9; i++) {
			System.out.printf("%d %.9f\r\n",i,e(i));
		}
	}
}
