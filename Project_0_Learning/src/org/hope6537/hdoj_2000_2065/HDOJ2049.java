package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2049 {


	static Scanner s = new Scanner(System.in);

	public static long f(long x){
		if(x==1){
			return 0;
		}else if(x==2){
			return 1;
		}else{
			return (x-1)*(f(x-1)+f(x-2));
		}
	}
	
	public static long jiecheng(long x){
		if(x==1){
			return 1;
		}else{
			return jiecheng(x-1) * x; 
		}
	}
	
	/**
	 * @Descirbe 连乘 A n,m n在下 m在上
	 * @Author Hope6537(赵鹏)
	 * @Params @return
	 * @SignDate 2014-4-16下午8:02:54
	 * @Version 0.9
	 */
	public static long A(long n, long m){
		if( n == m){
			return jiecheng(n);
		}else if(n>m){
			return jiecheng(n)/jiecheng(n-m);
		}else{
			return -1;
		}
	}
	
	/**
	 * @Descirbe 俗称的C n,m排列组合运算 
	 * @Author Hope6537(赵鹏)
	 * @Params @param n
	 * @Params @param m
	 * @Params @return
	 * @SignDate 2014-4-16下午8:04:49
	 * @Version 0.9
	 */
	public static long C(long n , long m){
		if(n>m){
//			return A(n,m)/A(m,m); 
			return (long)(jiecheng(n)*1.0/(jiecheng(m)*jiecheng(n-m)));
//			return (long)(A(n,m)*1.0/A(m,m));
		}
		else if(n==m){
			return 1;
		}
		else if(m==1){
			return n;
		}
		else{
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
		while(s.hasNext()){
	//		System.out.println(C(3,1));
			int num = s.nextInt();
			
			for(int i = 0 ; i < num ; i++){
				long n = s.nextLong();
				long m = s.nextLong();
				{
					long res = (long)(C(n,m)*f(m));
					System.out.print(res+"\r\n");
				}
			}
		}
	}
	
}
