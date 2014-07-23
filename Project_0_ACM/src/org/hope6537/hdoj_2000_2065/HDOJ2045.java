package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2045 {
	
	public static long fin(long x){
		if(x==1){
			return 3;
		}
		else if(x==2){
			return 6;
		}
		else if(x==3){
			return 6;
		}else{
			long njian1 = 6;
			long njian2 = 6;
			long res = 6;
			for(int i = 3 ; i < x ; i++){
				res = njian1 + njian2*2;
				njian2 = njian1;
				njian1 = res;
			}
			return res;
		}
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {

		while (s.hasNext()) {
			long n = s.nextLong();
			System.out.println(fin(n));
		}
	}

}
