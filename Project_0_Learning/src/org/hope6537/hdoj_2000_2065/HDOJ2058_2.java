package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2058_2 {

	
	static Scanner s = new Scanner(System.in);
	
	public static double leihe(double x , double y){
		return ((x+y)/2)  * (Math.abs(x-y)+1);
	}
	
		
	
	public static void main(String[] args) {
		while(s.hasNext()){
			
			long n = s.nextLong();//����
			long m = s.nextLong();//Ŀ��ֵ
			if(n==m&&n==0){
				break;
			}
			/*
			 * ���ݵȲ�������͹�ʽ
			 * ������a β����an ����Ϊd=1 ͬʱ��Ҫ������Ϊn
			 * ��ô a*n + n*(n-1)*d/2 = Sn
			 * ������a�Ĺ�ʽ�ɵ�
			 * ͬʱ����Ҫ���n�Ĵ�С����
			 * ���� (a1+an)*n/2 = m
			 * ���� = n*(a1+a1+(n-1)*d)/2 = m
			 * ���� n*(2a1+n-1)=2m
			 * 
			 * a�Ǵ��ڵ���1��
			 * ����2a���ڵ���2
			 * 2a-1���ڵ���1��2a-1+n���ڵ���n
			 * n*(2a-1+n) >= n^2
			 * ����2m���ڵ���n^2
			 * ����nС�ڵ��ڸ�����2m
			 * ����n�ķ�Χȷ��
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
