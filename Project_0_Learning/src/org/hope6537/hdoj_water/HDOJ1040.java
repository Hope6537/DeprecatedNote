package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1040 {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			while(n--!=0){
				int num = s.nextInt();
				int [] nums = new int[num];
				for(int i = 0 ; i < nums.length ; i ++){
					nums[i] = s.nextInt();
				}
				Arrays.sort(nums);
				for(int i = 0 ; i < nums.length ; i ++){
					System.out.print(nums[i]);
					if(i<nums.length-1){
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}
