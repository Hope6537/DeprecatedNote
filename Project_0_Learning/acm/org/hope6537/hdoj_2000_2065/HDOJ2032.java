package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2032 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n  = s.nextInt();

			for (int i = 0; i < n; i++) {
				int flag = 0;
				for (int j = 0; j < i + 1; j++) {
					int a = 1;
					
					for (int k = 0; k < j; k++) {
						a = a * (i - k) / (k + 1);
					}
					if(flag==1){
						System.out.print(" ");
					}
					System.out.print(a);
					flag=1;
				}
				System.out.println();
			}
			System.out.println();
		
		}
	}

}
