package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2051 {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int [] a = new int[100];
			int n = s.nextInt();
			int i = 0;
			if(n<0){
				System.out.print("-");
				n = -n;
			}
			for(i = 0 ; n>0 ; i++){
				a[i] = n%2;
				n = n/2;
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
