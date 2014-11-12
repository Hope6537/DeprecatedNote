package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2055 {
	
	static Scanner s = new Scanner(System.in);
	
	public static int f(char c){
		if(c>='A'&&c<='Z'){
			return ((int)c - 64);
		}else if(c>='a'&&c<='z'){
			return -((int)c - 96);
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			for(int i = 0 ; i < n ; i++){
				char x = s.next().charAt(0);
				int y = s.nextInt();
				System.out.println(y+f(x));
			}
			
		}
	}

}
