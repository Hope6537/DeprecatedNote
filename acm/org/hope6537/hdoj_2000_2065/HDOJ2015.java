package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2015 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt(); // 长度
			int m = s.nextInt(); // 条约
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = (i + 1) * 2;
			}
			int flag = 0;
			for (int i = 0; i < n; i += m) {
				
				int sum = 0;
				int count = 0;
				for (int j = i; j < i + m; j++) {
					if (j > n - 1) {
						break;
					}
					count++;
					sum = sum + a[j];
				}
			/*	System.out.println("count="+count);*/
				if(flag == 1){
					System.out.print(" ");
				}
				System.out.print(sum / count);
				flag = 1;
			}

			System.out.println();
		}
	}

}
