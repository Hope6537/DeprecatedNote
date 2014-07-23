package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe ƽ��ָ�����
 * @Author Hope6537(����)
 * @Signdate 2014-4-16����8:56:38
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2050 {
	/*
	 * n�����ߵ����ָ�Ϊ �������+�������+1
	 * ����n-1��������˵ ��n���ߵ�ÿ���߶����n-1�����ߵ������ཻ ����2��n-1�����½���
	 * ������������ ����2*2*(n-1)
	 * ����+1
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
