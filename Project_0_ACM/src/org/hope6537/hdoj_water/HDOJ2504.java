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
					//����c��˵ ��b��ʼ������ӣ�һֱ��b�ı���
					if (gcd(b, c) == b && gcd(a, c) == b && c != b) {
						//���b c����С��������b
						//a c����С��������b
						//��ô������С��c������ ͬʱc��b�����
						//���������
						break;
					}
				}
				System.out.println(c);
			}
			
		}
	}
}
