package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2062 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int m = s.nextInt();
			/*
			 * if(m==1){ System.out.print("1"); continue; }
			 */
			// MyArrayList<Integer> list = new MyArrayList<Integer>();
			int[] father = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				// list.add(i);
				father[i] = i;
			}
			// input done

			/*
			 * 思路：计算出该排列组合中m的最大值 即子集合的数量 根据分析 对于具有n个元素的集合 可以按照首元素将其分为n组子集
			 * 这些组的子集中，除了本身首元素之外，还有n-1个元素 即f(n-1) 在加上本身单体的1个子集 既有f(n-1) + 1
			 * 对于n个元素的自己为f(n) = n*(f(n-1)+1) 可得到子集合的一定规律
			 */
			// System.out.println(caluM(m));
			int flag = 0;
			while (m > 0) {
				int max_M = caluM(n);
				int countofGroup = n;// 共有多少组？
				int countofTarget = max_M / countofGroup;// 每组多少个？
				// 然后计算当前m的索引代表第几组？
				int groupNum = (m % countofTarget) == 0 ? (m / countofTarget)
						: (m / countofTarget) + 1;// 这是第几组
				int targetNum = m - ((groupNum - 1) * countofTarget);// 这是第几个
				// Integer num = list.get(groupNum);
				int num = father[groupNum];
				if (flag == 1) {
					System.out.print(" ");
				}
				if (targetNum > 0 && num != 0) {
					System.out.print(num);// 找到了首数字，可以输出
					flag = 1;
				} else {
					flag = 0;
				}
				n--;
				m = targetNum - 1;
				// list.remove(groupNum);
				for (int i = groupNum; i < father.length - 1; i++) {
					father[i] = father[i + 1];
				}
			}
			System.out.print("\r\n");

			/*
			 * if(targetNum - 1 > 0){ //如果这不是个空集合，即还有输出 targetNum--;//将空集合剔除
			 * 得到当前n-1项中元素的位置 groupNum = caluM(m-1) / m-1;//这是第几组
			 * System.out.println(groupNum); }
			 */

		}
	}

	public static int caluM(int m) {
		int temp = 1;
		for (int i = 1; i < m + 2; i++) {
			temp = (temp + 1) * (i - 1);
		}
		return temp;
	}
}
