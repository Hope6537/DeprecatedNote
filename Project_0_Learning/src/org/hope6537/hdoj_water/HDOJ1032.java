package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1032 {

	static Scanner s = new Scanner(System.in);

	public static int f(int i){
		int count = 1;
		int temp = i;
		while(temp!=1){
			if(temp%2!=0){
				temp = 3 * temp + 1;
			}else{
				temp = temp / 2;
			}
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		while (s.hasNext()) {
			int a = s.nextInt();
			int b = s.nextInt();
			System.out.print(a + " " + b + " ");
			if(a>b){
				int temp = a;
				a = b;
				b = temp;
			}
			int max = 0;
			for(int i = a ; i <= b ; i++){
				int temp = f(i);
				if(max < temp){
					max = temp;
				}
			}
			System.out.print(max+"\r\n");
		}
	}

}
