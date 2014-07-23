package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2031 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		//char [] number = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while (s.hasNext()) {
			int [] a = new int[100];
			int n = s.nextInt();
			int r = s.nextInt();
			int i = 0;
			if(n<0){
				System.out.print("-");
				n = -n;
			}
			for(i = 0 ; n>0 ; i++){
				a[i] = n%r;
				n = n/r;
			}
			while(i-- > 0){
				if(a[i]<10)
					System.out.print(a[i]);
				else
					System.out.print((char)(a[i]+55));
			}
			System.out.println();
			
		}
	}
}
