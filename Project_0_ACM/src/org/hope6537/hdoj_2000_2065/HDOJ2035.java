package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2035 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int m = s.nextInt();
			if(n==m&&n==0){
				break;
			}
			int i,s=n;
			for(i=0;i<m-1;i++)
	     		s=s*n%1000; // 10000时是四位
			System.out.println(s);
		}
	}

}
