package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2030 {
	
	
	public static boolean isRegexpValidate(String source) {
		return source.matches("[\u4E00-\u9FA5]*");
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = Integer.parseInt(s.nextLine());
			 for(int i = 0 ; i < n ; i++){
				 String str = s.nextLine();
				 int count = 0;
				 for(int j = 0 ; j < str.length() ; j++){
					 char c = str.charAt(j);
					 boolean isChina = ((int)c)>=0&&((int)c)<=128;
					 if(!isChina){
						 count++;
					 }
					 /*
					 String c = str.charAt(j) + "";
					 boolean isChina = isRegexpValidate(c);
					 if(isChina){
						 count++;
					 }
				 */}
				 System.out.println(count);
			 }
		}
	}
}
