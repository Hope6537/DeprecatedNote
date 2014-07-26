package org.hope6537.datastructs.march;

public class 欧几里得算法 {

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
		System.out.println(gcd(50, 15));
	}
}
