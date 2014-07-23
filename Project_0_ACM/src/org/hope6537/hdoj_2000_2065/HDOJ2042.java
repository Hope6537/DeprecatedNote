package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2042 {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (s.hasNext()) {
			int n = s.nextInt();
			for(int i = 0 ; i < n; i++){
				int stops = s.nextInt();
				int sum = 3;
				for(int j = 0 ; j < stops ; j++){
					sum = ((sum-1)*2);
				}
				System.out.println(sum);
			}
		}
	}

}
