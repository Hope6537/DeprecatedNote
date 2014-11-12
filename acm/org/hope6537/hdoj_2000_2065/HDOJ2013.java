package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2013 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int day = s.nextInt();
			int count = 1;
			for(int i = day ; i > 1 ; i -- ){
				count = (count + 1)*2;
			}
			System.out.println(count);
		}
	}
}
