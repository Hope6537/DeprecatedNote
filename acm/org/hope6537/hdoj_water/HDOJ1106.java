package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1106 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			String str = s.next();
			String[] strs = str.split("5");
			int[] nums = new int[10];
			int counts = 0;
			for (int i = 0; i < strs.length; i++) {
				if (!strs[i].isEmpty()) {
					nums[counts] = Integer.parseInt(strs[i]);
					counts++;
				}
			}
			int i = 0;
			Arrays.sort(nums, 0, counts);
			for (i = 0; i < counts - 1; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println(nums[i]);
		}
	}
}
