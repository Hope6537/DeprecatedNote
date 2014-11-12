package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2020 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			if(n==0){
				break;
			}
			int [] a = new int [n];
			//System.out.println(n);
			for(int i = 0 ; i < n ; i++){
				a[i] = s.nextInt();
			}
			//input done
			for(int i = 0 ; i < n ; i++){
				for(int j = 0 ; j < n ; j++){
					if(Math.abs(a[i]) > Math.abs(a[j])){
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
			int flag = 0;
			for(int i = 0 ; i < n ; i++){
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
