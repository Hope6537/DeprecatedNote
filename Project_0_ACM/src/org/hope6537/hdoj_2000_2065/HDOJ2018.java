package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2018 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			if(n==0){
				break;
			}
			int count = f(n);
			System.out.println(count);
			
		}
	
	}
	private static int f(int n) {
		if(n==1){
			return 1;
		}else if(n==2){
			return 2;
		}else if(n==3){
			return 3;
		}else{
			return f(n-1) + f(n-3);
		}
	}
}
