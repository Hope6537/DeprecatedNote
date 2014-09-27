package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2024 {
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		while(s.hasNext()){
			int n = Integer.parseInt(s.nextLine());
			String [] strs = new String[n];
			for(int i = 0 ; i <strs.length; i++){
				strs[i] = s.nextLine();
			}
			//input done 
			for(int i = 0; i < strs.length ; i++){
				String temp = strs[i];
				boolean isYes = true;
				boolean firstCharOK = (temp.charAt(0)>='A' && temp.charAt(0)<='Z') || (temp.charAt(0)>='a' && temp.charAt(0)<='z')  || (temp.charAt(0)=='_');
				
				for(int j = 0 ; j < temp.length() ; j++){
					
					char c = temp.charAt(j);
					if(!firstCharOK){
						isYes = false;
						break;
					}
					boolean charOk = (c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9') || (c=='_');
					if(!charOk){
						isYes = false;
						break;
					}
				}
				if(isYes){
					System.out.println("yes");
				}else{
					System.out.println("no");
				}
			}
			
		}
	}

}
