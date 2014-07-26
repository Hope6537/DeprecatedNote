package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2017 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			for(int i = 0 ; i < n; i++){
				String str = s.next();
				int count = 0;
				for(int j = 0 ; j<str.length() ; j++){
					char c = str.charAt(j);
					if(c>='0'&&c<='9'){
						count++;
					}
				}
				System.out.println(count);
			}
			
			
		}
	
	}
}
