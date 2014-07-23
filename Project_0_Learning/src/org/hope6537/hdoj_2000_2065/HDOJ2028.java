package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2028 {
	
	public static long gcd(long m , long n){
		while(n != 0){
			long rem = m%n;
			m = n;
			n = rem;
		}
		return m;
	}
	

	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			long [] a = new long [n];
			for(int i = 0 ; i< n ; i++){
				a[i] = s.nextLong();
			}
			long res = a[0]*a[1]/gcd(a[0],a[1]);
			if(n>2){
				for(int i = 2 ; i < n ; i++){
					res = res*a[i]/gcd(res, a[i]);
				}
			}
			System.out.println(res);
		}
	}
}
