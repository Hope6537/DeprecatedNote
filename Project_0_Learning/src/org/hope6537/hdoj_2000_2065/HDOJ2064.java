package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2064 {

	static long f(long x){
		if(x==1){
			return 2;
		}else{
			long sum = 2;
			for(long i = 1 ; i < x ; i++){
				sum = 3 * sum + 2;
			}
			return sum;
		}
	}
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int x = s.nextInt();
			System.out.println(f(x));
		}
	}
}
