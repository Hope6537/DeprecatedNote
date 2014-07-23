package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2016 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			if(n==0){
				break;
			}else{
				int [] a = new int [n];
				for(int i = 0; i < a.length ; i++){
					a[i] = s.nextInt();
				}
				//input done
				int min = Integer.MAX_VALUE;
				int index = 0;
				for(int i = 0 ; i < a.length ; i++){
					if(a[i] < min){
						min = a[i];
						index = i;
					}
				}
				
				int temp = a[0];
				a[0] = a[index];
				a[index] = temp;
				int flag = 0;
				for(int i = 0 ; i < a.length ; i++){
					if(flag==1){
						System.out.print(" ");
					}
					System.out.print(a[i]);
					flag=1;
				}
				System.out.println();
			}
		}
	}
}
