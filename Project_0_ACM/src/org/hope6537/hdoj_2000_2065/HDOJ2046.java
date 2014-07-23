package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2046 {
	
	public static long f(long x){
		long a0 = 0;
		long a1 = 1;
		long res = 1;
		if(x<=3){
			return x;
		}
		for(int i = 0 ; i < x ; i++){
//			long temp = res;
			res = a0 + a1;
			a0 = a1;
			a1 = res;
		}
		return res;
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {

		while (s.hasNext()) {
			long n = s.nextLong();
			System.out.println(f(n));
		}
	}
}
