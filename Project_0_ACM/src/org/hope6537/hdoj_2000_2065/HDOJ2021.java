package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe ̰���㷨��Ӳ��
 * @Author Hope6537(����)
 * @Signdate 2014-4-14����5:10:54
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2021 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();//����
			if(n==0){
				break;
			}
			int [] a = new int [n];
			int [] cash = {100,50,10,5,2,1};
			for(int i = 0 ; i<n ; i++){
				a[i] = s.nextInt();
			}
			//input done
			int count = 0;
			for(int i = 0 ; i<n ; i++){
				int tempcash = a[i];
				int tempcount = count;
				int sum = 0;
				for(int j = 0 ; j < cash.length ; ){
					int money = cash[j];
					if(sum+money>tempcash){
						j++;
					}else{
						sum = sum + money;
						tempcount++;
					}
				}
				count = tempcount;
			}
			System.out.println(count);
		}
	}
}
