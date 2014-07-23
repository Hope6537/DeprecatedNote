package org.hope6537.hdoj_water;

import java.math.BigInteger;
import java.util.Scanner;

public class HDOJ2568 {

	/*
	 * ����A��һ����ɱ��һ������� ���������ǰ��������Ϊ��������ô�ͱ����ȳ�һ�н���Bɱ����������һ����ʹ������Ϊż�����ٳ�����A��
	 */

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			while (n-- != 0) {
				int b = 0;
				BigInteger bigInteger = s.nextBigInteger();
				while (bigInteger.compareTo(bigInteger.ZERO) != 0) {
					if (bigInteger.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO)==0) {
						bigInteger = bigInteger.divide(BigInteger.valueOf(2));
					} else {
						bigInteger = bigInteger.subtract(bigInteger.valueOf(1));
						b++;
					}
				}
				System.out.println(b);

			}
		}
	}

}
