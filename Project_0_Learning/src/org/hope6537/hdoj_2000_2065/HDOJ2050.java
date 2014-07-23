package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe 平面分割问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-4-16下午8:56:38
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2050 {
	/*
	 * n条折线的最多分割为 交点个数+顶点个数+1
	 * 对于n-1条折线来说 第n条线的每个边都会和n-1条折线的两边相交 产生2（n-1）个新交点
	 * 折线有两个边 所以2*2*(n-1)
	 * 顶点+1
	 * f(n) = f(n-1) + 4*(n-1) +1
	 */
	static Scanner s = new Scanner(System.in);

	public static long f(long x){
		if(x==1){
			return 2;
		}else{
			return f(x-1) + 4*(x-1) + 1;
		}
	}
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			for(int i = 0 ; i < n ; i ++){
				long num = s.nextLong();
				System.out.println(f(num));
			}
		}
	}

}
