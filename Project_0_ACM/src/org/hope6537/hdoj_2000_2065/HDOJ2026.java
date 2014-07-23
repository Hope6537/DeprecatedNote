package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2026 {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
			String string = s.nextLine();
			String newString = "";
			int isZiMu = 0;
			for(int i = 0 ; i < string.length() ; i++){				
				
				if(isZiMu == 0){
					newString = newString + (char)((int)(string.charAt(i))-32);
					isZiMu=1;
				}else{
					newString = newString + string.charAt(i);
					if(string.charAt(i)==' '){
						isZiMu=0;
					}
				}
			}
			System.out.println(newString);
		}
	}
}
