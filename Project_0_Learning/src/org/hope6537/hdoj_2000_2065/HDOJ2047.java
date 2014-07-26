package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2047 {

	static Scanner s = new Scanner(System.in);
	
	public static long f(long x){
		if(x==1){
			return 3;
		}
		else if(x==2){
			return 8;
		}else{
			long res = 8;
			long temp = 2;
			for(int i = 2 ; i < x; i ++){
				long tmp = (res - temp);
				res =  (res - temp) * 3 + temp * 2;
				temp = tmp;
			}
			return res;
		}
	}
	
	public static void main(String[] args) {

		while (s.hasNext()) {
			long n = s.nextLong();
			System.out.println(f(n));
		}
		
	}
}
