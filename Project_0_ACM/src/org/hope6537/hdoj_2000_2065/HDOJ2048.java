package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe 错排公式的运用
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-4-16下午7:17:37
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2048 {

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
	
	
	public static void main(String[] args) {
		while(s.hasNext()){
			long n = s.nextLong();
			
			for(int i = 0 ; i < n ; i++){
				long x = s.nextLong();
//				System.out.println("x!="+jiecheng(x));
//				System.out.println(f(x));
				System.out.printf("%.2f",((f(x)/(jiecheng(x)*1.0)))*100);
				System.out.print("%\r\n");
			}
		}
		
	}
}
