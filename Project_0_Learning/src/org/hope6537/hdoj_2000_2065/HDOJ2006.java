package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2006 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int num = s.nextInt();
			int sum = 1;
			for(int i = 0 ; i<num;i++){
				int number = s.nextInt();
				if(number%2!=0){
					sum = sum * number;
				}
			}
			System.out.println(sum);
		}
	}
}
