package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2057 {
	
	
	static char [] number = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	static Scanner s = new Scanner(System.in);
	
	public static int returnIndex(char c){
		for(int i = 0 ; i < number.length ; i++){
			if(c==number[i]){
				return i;
			}
		}
		return 0;
	}
	public static long pow (long x ,int n){
		if(n==0){
			return 1;
		}
		if(n==1){
			return x;
		}
		if(n>=2&&n%2==0){
			return pow (x*x,n/2);
		}
		else{
			return pow (x*x,n/2)*x;
		}
	}
	public static String format(String n){
		if( n.charAt(0) == '-' ){
			return n;
		}else if (n.charAt(0) == '+' ){
			return n;
		}
		return "+"+n;
		
	}
	
	/*public static long SixthToTen(String n){
		long res = 0;
		for(int i = 1 ; i < n.length() ; i++){
			char c = n.charAt(i);
			if(c<= '9' && c>='0'){
				res = (int)c * pow(16,i-1) + res;
			}else{
				res = (long) (returnIndex(n.charAt(i)) * pow(16, i-1)) + res;
			}
		}
		return res;
	
	}*/
	
	
	public static void tenToSixth(long n){
		long res = n;
		long [] array = new long[100];
		int k = 1;
		for(k = 0 ; Math.abs(res)>0 ; k++){
			array[k] = res%16;
			res = res/16;
		}
		
		while(k-- > 0){
			if(Math.abs(array[k])<10)
				System.out.print(array[k]);
			else
				System.out.print((char)(Math.abs(array[k])+55));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		while(s.hasNext()){
			String a = s.next();
			String b = s.next();
			long an = 0;
			long bn = 0;
			boolean isA = false , isB = false;
			a = format(a);
			b = format(b);
			int i = a.length()-1 , j = b.length()-1;
			int count = 0;
			for(;;){
				if(isA&&isB){
					break;
				}
				if(i > 0){
					char c = a.charAt(i);
					if(c<= '9' && c>='0'){
						an = (long)(returnIndex(c)) * pow(16,count) + an;
					}else{
						an = (long) (returnIndex(c) * pow(16, count)) + an;
					}
					i--;
				}else{
					isA = true;
				}
				if(j > 0){
					char c = b.charAt(j);
					if(c<= '9' && c>='0'){
						bn = (long)(returnIndex(c)) * pow(16,count) + bn;
					}else{
						bn = (long) (returnIndex(b.charAt(j)) * pow(16, count)) + bn;
					}
					j--;
				}else{
					isB = true;
				}
				count++;
			}
			an = a.charAt(0) == '-' ? -an:an;
			bn = b.charAt(0) == '-' ? -bn:bn;
			long res = an + bn;
			//10进制的数值处理完毕
			if(res==0){
				System.out.println("0");
			}else{
				
				tenToSixth(res);
				
			}
			
		}	
	}

}
