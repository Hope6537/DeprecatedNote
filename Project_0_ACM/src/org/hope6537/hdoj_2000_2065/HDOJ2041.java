package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2041 {
	
	
	
	
	public static int f(int x){
		if(x==0){
			return 1;
		}
		else if(x==1){
			return 1;
		}else{
			return f(x-1) + f(x-2);
		}
		
	}
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (s.hasNext()) {
			int n = s.nextInt();
			for(int i = 0 ; i < n ; i ++){
				int steps = s.nextInt();
				System.out.println(f(steps-1));
			}
		}
	}

}
