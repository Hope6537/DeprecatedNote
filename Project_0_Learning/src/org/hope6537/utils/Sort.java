package org.hope6537.utils;

import java.util.Arrays;

import org.junit.Test;

public class Sort {

	public static void sort(int[] a) {
		int j;
		for (int p = 1; p < a.length; p++) {
			int temp = a[p];
			for (j = p; j > 0 && temp - a[j-1] > 0; j--) {
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	
	
	@Test
	public void test(){
		int [] a = {1,8,95,3,567,137,52,3,4};
		sort(a);
		System.out.println(Arrays.toString(a));
	}

}
