package org.hope6537.hdoj_2000_2065;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ2034 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int m = s.nextInt();
			if(n==m&&n==0){
				break;
			}
			int [] a = new int [n];
			int [] b = new int [m];
			int [] c = new int [n];
			for(int i = 0 ; i < n ; i++){
				a[i] = s.nextInt();
				c[i] = Integer.MIN_VALUE;
			}
			for(int i = 0 ; i < m ; i++){
				b[i] = s.nextInt();
			}
			//input done
			
			for(int i = 0 ; i < n ; i++){
				boolean isOk = true;
				for(int j = 0 ; j < m ; j++){
					if(a[i] == b[j]){
						b[j] = -1;
						isOk = false;
					}
				}
				if(isOk){
					c[i] = a[i];
				}
			}
			Arrays.sort(c);
			int flag = 0;
			int count = 0;
			for(int i = 0 ; i < c.length ; i++){
				
				if(c[i]>Integer.MIN_VALUE){
					/*if(flag==1){
						System.out.print(" ");
					}*/
					System.out.print(c[i]+" ");
					count++;
					flag=1;
				}
			}
			if(count==0){
				System.out.print("NULL");
			}
			System.out.println();
		}
	}

}
