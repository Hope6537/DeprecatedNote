package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2053 {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
		long n = s.nextLong();
		int count = 0;
		for(int i = 1 ; i<= n ; i++){
			if(n%i==0){
				count++;
			}
		}
		if(count%2!=0){
			System.out.println("1");
		}else{
			System.out.println("0");
		}
		}
	}
	
}
