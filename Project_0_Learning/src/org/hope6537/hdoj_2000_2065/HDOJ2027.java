package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2027 {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = Integer.parseInt(s.nextLine());
		
		String [] strs = new String[n];
		for(int i = 0 ; i <strs.length; i++){
			strs[i] = s.nextLine();
		}
		//input done
		for(int i = 0 ; i <strs.length; i++){
			int [] count =  {0,0,0,0,0};
			String str = strs[i];
			for(int j = 0 ; j < str.length() ; j++){
				char c = str.charAt(j);
				if(c=='a'||c=='A'){
					count[0]++;
				}
				if(c=='e'||c=='E'){
					count[1]++;
				}
				if(c=='i'||c=='I'){
					count[2]++;
				}
				if(c=='o'||c=='O'){
					count[3]++;
				}
				if(c=='u'||c=='U'){
					count[4]++;
				}
			}
			System.out.println("a:"+count[0]);
			System.out.println("e:"+count[1]);
			System.out.println("i:"+count[2]);
			System.out.println("o:"+count[3]);
			System.out.println("u:"+count[4]);
			if(i!=strs.length-1){
				System.out.println();
			}
		}
			
	}
}
