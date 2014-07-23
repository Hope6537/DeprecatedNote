package org.hope6537.hdoj_water;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class HDOJ1108 {

	static Scanner s=  new Scanner(new BufferedInputStream(System.in));
	
	public static long gcd(long m, long n) {
		while (n != 0) {
			long rem = m % n;
			m = n;
			n = rem;
		}
		return m;
	}

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int a = s.nextInt();
			int b = s.nextInt();
			System.out.println(lcm(a,b));
		}
	}
	
}
