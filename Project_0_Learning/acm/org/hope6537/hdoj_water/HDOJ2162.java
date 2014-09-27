package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2162 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int count = 0;
		while (s.hasNext()) {
			int n = s.nextInt();
			if(n<=0){
				break;
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += s.nextInt();
			}
			System.out.println("Sum of #"+(++count)+" is "+sum);
		}
	}

}
