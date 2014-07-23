package org.hope6537.hdoj_2000_2065;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2014 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			if(!(n>2&&n<=100)){
				break;
			}
			int [] s1 = new int [n];
			for(int i = 0 ; i < s1.length ; i++){
				s1[i] = s.nextInt();
			}
			Arrays.sort(s1);
			double sum = 0;
			for(int i = 1 ; i < s1.length-1 ; i++){
				sum = sum + s1[i];
			}
			System.out.printf("%.2f\r\n",(sum/(n-2)));
		}
	}

}
