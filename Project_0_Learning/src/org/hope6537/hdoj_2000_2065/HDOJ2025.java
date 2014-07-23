package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe ÕâÌâ´¿À¬»ø
 * @Author Hope6537(ÕÔÅô)
 * @Signdate 2014-4-14ÏÂÎç7:03:32
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2025 {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(s.hasNext()){
			
			String str = s.next();
			int maxnumber = 0;
			for(int i = 0 ; i < str.length(); i++){
				char c = str.charAt(i);
				if(maxnumber < (int)(c - 64)){
					maxnumber = (int)(c - 64);
				}
				
			}
			//maxnumber is here
			String newString = "";
			for(int i = 0 ; i < str.length(); i++){
				char c = str.charAt(i);
				if(maxnumber == (int)(c - 64)){
					newString = newString + c + "(max)";
				}else{
					newString = newString + c;
				}
			}
			System.out.println(newString);
		}
	
		/*
		
		while(s.hasNext()){
			
			String str = s.next();
			int maxnumber = 0;
			for(int i = 0 ; i < str.length(); i++){
				char c = str.charAt(i);
				if(c>='A' && c<='Z'){
					if(maxnumber < (int)(c - 64)){
						maxnumber = (int)(c - 64);
					}
				}
				if(c>='a' && c<='z'){
					if(maxnumber < (int)(c - 96)){
						maxnumber = (int)(c - 96);
					}
				}
			}
			//maxnumber is here
			String newString = "";
			for(int i = 0 ; i < str.length(); i++){
				char c = str.charAt(i);
				if(c>='A' && c<='Z'){
					if(maxnumber == (int)(c - 64)){
						newString = newString + c + "(max)";
					}else{
						newString = newString + c;
					}
				}
				else if(c>='a' && c<='z'){
					if(maxnumber == (int)(c - 96)){
						newString = newString + c + "(max)";
					}else{
						newString = newString + c;
					}
				}
				
			}
			System.out.println(newString);
		}
	*/}

}
