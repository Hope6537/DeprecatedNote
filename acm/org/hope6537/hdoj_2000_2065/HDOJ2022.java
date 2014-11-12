package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2022 {
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int m = s.nextInt();
			int n = s.nextInt();
			int [][] a = new int[m][n];
			for(int i = 0 ; i < m ; i++){
				for(int j = 0 ; j < n ; j++){
					a[i][j] = s.nextInt();
				}
			}
			int x = 0;
			int y = 0;
			int score = 0;
			for(int i = 0 ; i < m ; i++){
				for(int j = 0 ; j < n ; j++){
					if(Math.abs(a[i][j])>Math.abs(score) ){
						x = i;
						y = j;
						score  = a[i][j];
					}
				}
			}
			System.out.println((x+1)+" "+(y+1)+" "+score);
		}
	}

}
