package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2029 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			 int n = s.nextInt();
			 for(int i = 0 ; i < n ; i++){
				 String str = s.next();
				 int center = str.length()/2;
				 String  first = new String();
				 String  last = new String();
				 for(int j = 0 , k = str.length()-1 ; j < center ; j++ , k--){
					 first = first + str.charAt(j);
					 last = last + str.charAt(k);
				 }
				 if(first.equals(last)){
					 System.out.println("yes");
				 }else{
					 System.out.println("no");
				 }
			 }
		}
	}
}
