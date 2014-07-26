package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2058_2 {

	
	static Scanner s = new Scanner(System.in);
	
	public static double leihe(double x , double y){
		return ((x+y)/2)  * (Math.abs(x-y)+1);
	}
	
		
	
	public static void main(String[] args) {
		while(s.hasNext()){
			
			long n = s.nextLong();//个数
			long m = s.nextLong();//目标值
			if(n==m&&n==0){
				break;
			}
			/*
			 * 根据等差数列求和公式
			 * 首项是a 尾项是an 公差为d=1 同时需要的项数为n
			 * 那么 a*n + n*(n-1)*d/2 = Sn
			 * 则首项a的公式可得
			 * 同时我们要求得n的大小长度
			 * 又有 (a1+an)*n/2 = m
			 * 所以 = n*(a1+a1+(n-1)*d)/2 = m
			 * 则有 n*(2a1+n-1)=2m
			 * 
			 * a是大于等于1的
			 * 所以2a大于等于2
			 * 2a-1大于等于1，2a-1+n大于等于n
			 * n*(2a-1+n) >= n^2
			 * 则有2m大于等于n^2
			 * 则有n小于等于根号下2m
			 * 所以n的范围确定
			 */
			
			
			
			
			
			long limit = (long) Math.sqrt(2.0*m);
			for(long i = limit ; i >= 1 ; i--){
				long a = m/i - (i-1)/2;
				long res = (i*(2*a+i-1))/2;
				if(res == m){
					System.out.println("["+(long)a+","+(long)(a+i-1)+"]");
				}
			}
			System.out.println();
//			System.out.println("done");
		}
	}
	
}
