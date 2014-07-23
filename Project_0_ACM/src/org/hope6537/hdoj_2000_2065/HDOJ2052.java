package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2052 {


	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int width = s.nextInt();
			width +=2;
			int height = s.nextInt();
			height +=2;
			
				for(int j = 0 ; j < height ; j++){
					for(int i = 0 ; i < width ; i++){
					if(i==0 && j ==0 || i==width-1 && j==height-1 || i == width-1 && j==0 || i==0 && j==height-1){
						System.out.print("+");
					}
					else if(i==0||i==width-1){
						System.out.print("|");
					}
					else if(j==0||j==height-1){
						System.out.print("-");
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
				System.out.println();
		}
	}
	
}
