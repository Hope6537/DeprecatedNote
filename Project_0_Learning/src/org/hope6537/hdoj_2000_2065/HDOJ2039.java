package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2039 {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = s.nextInt();
		for(int i = 0 ; i < n ; i++){
			double a = s.nextDouble();
			double b = s.nextDouble();
			double c = s.nextDouble();
			boolean a1 = c>Math.abs(a-b)&&c<Math.abs(a+b);
			boolean a2 = a>Math.abs(c-b)&&a<Math.abs(c+b);
			boolean a3 = b>Math.abs(c-a)&&b<Math.abs(c+a);
			if(a1||a2||a3){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
