package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2000 {
	
	public static void insertionSort(char [] a){
		int j = 0;
		for(int p = 1 ; p < a.length ; p++ ){
			//从第二个元素开始到尾部
			char tmp = a[p]; //然后获取第p个元素
			for(j = p ; j > 0 && tmp<a[j-1] ; j--){
				//进行循环  j的索引从p开始 到j-1元素大于j元素时  交换
				a[j] = a[j-1];
			}
			//最后变量交换完毕
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		while(s.hasNext()){
			String str = s.next();
			char [] chars = new char[3];
			for(int i = 0 ; i < str.length() ; i++){
				chars[i] = str.charAt(i);
			}
			insertionSort(chars);
			System.out.println(chars[0]+" "+chars[1]+" "+chars[2]);
		}
	}

}
