package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2040 {
	
	public static int f(int x){
		int sum = 0;
		for(int i = 1 ; i < x ; i ++ ){
			if(x%i==0){
				sum = sum + i;
			}
		}
		return sum;
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (s.hasNext()) {
			int n = s.nextInt();
			for(int i = 0 ; i < n ; i++){
				int x = s.nextInt();
				int y = s.nextInt();
				
				if(f(x)==y && f(y)==x){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
			
			
		}
	}

}
