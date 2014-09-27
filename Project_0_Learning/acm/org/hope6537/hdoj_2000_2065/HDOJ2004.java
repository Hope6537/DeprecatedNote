package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2004 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int grade = s.nextInt();
			if(grade>=90&&grade<=100){
				System.out.println("A");
			}
			else if(grade>=80&&grade<=89){
				System.out.println("B");
			}
			else if(grade>=70&&grade<=79){
				System.out.println("C");
			}
			else if(grade>=60&&grade<=69){
				System.out.println("D");
			}
			else if(grade>=0&&grade<=59){
				System.out.println("E");
			}
			else{
				System.out.println("Score is error!");
			}
		}
	}

}
