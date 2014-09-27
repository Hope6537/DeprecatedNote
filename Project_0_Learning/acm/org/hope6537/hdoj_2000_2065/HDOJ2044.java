package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2044 {
	static Scanner s = new Scanner(System.in);

	public static long f(long x){
		long a0 = 0;
		long a1 = 1;
		long res = 1;
		if(x<=1){
			return 1;
		}
		for(int i = 0 ; i < x ; i++){
//			long temp = res;
			res = a0 + a1;
			a0 = a1;
			a1 = res;
		}
		return res;
	}
	
	public static void main(String[] args) {

		while (s.hasNext()) {

			int n = s.nextInt();
			for(int i = 0 ; i < n ; i++){
				long start = s.nextLong();
				long end = s.nextLong();
				long x = end - start;
				System.out.println(f(x));
			}
		}
	}

}
