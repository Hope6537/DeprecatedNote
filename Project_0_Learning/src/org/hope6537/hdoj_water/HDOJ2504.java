package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2504 {

	static Scanner s = new Scanner(System.in);

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
	
		while (s.hasNext()) {
			int n = s.nextInt();
			while(n--!=0){
				int a = s.nextInt();
				int b = s.nextInt();
				int c = b;
				while ((c += b) != 0) {
					//对于c来说 从b开始递增相加，一直是b的倍数
					if (gcd(b, c) == b && gcd(a, c) == b && c != b) {
						//如果b c的最小公倍数是b
						//a c的最小公倍数是b
						//那么符合最小的c的条件 同时c和b不相等
						//跳出并输出
						break;
					}
				}
				System.out.println(c);
			}
			
		}
	}
}
