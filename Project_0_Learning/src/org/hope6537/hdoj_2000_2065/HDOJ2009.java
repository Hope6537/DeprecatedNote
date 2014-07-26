package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;


public class HDOJ2009 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			double number = s.nextDouble();
			int count = s.nextInt();
			double sum = number;
			for(int i = 0 ; i < count - 1 ; i++){
				sum = Math.sqrt(number) + sum;
				number = Math.sqrt(number);
			}
			System.out.printf("%.2f\r\n",sum);
		}
	}

}
