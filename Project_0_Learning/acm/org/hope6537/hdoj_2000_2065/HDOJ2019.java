package org.hope6537.hdoj_2000_2065;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2019 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			int m = s.nextInt();
			if(n==m && n==0){
				break;
			}
			int [] a = new int [n+1];
			for(int i = 0 ; i < n ; i++){
				a[i] = s.nextInt();
			}
			a[n] = m;
			Arrays.sort(a);
			int flag = 0;
			for(int i = 0 ; i < n+1 ; i++){
				if(flag==1){
					System.out.print(" ");
				}
				System.out.print(a[i]);
				flag=1;
			}
			System.out.println();
			
			
		}
	
	}
	
}
