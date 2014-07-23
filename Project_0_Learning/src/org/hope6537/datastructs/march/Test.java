package org.hope6537.datastructs.march;

import java.util.Iterator;

public class Test {
	
	public static void main(String[] args) {
		int [][] a = {{0,0,0},{0,1,1},{1,1,1}};
		for(int i = 0 ; i< a.length ; i++){
			for(int j = 0 ; j<a.length ; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		int x = 0;
		int y = 0;
		System.out.println(a[++x][++y]);
		System.out.println(y);
		
	}

}
