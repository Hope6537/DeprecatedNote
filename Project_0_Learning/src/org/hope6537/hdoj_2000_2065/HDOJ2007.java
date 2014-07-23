package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2007 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int m, n, summ, sumn, i, temp;
			m = s.nextInt();
			n = s.nextInt();
			if (m > n) {
				temp = m;
				m = n;
				n = temp;
			}
			summ = sumn = 0;
			for (i = m; i <= n; i++)
				if (i % 2 == 1)
					summ += i * i * i;
				else
					sumn += i * i;
			System.out.println(sumn+" "+summ);
		}/*
		 * int oushu = 0; int jishu = 0;
		 * 
		 * for(int i = 0 ; i < 2; i++){ int number = s.nextInt(); if(number%2 ==
		 * 0){ oushu = number * number + oushu; }else{ jishu = number * number *
		 * number + jishu; } } System.out.println(oushu+" "+jishu);
		 */
	}
}
