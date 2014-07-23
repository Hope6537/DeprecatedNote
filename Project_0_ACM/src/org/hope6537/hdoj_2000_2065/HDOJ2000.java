package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2000 {
	
	public static void insertionSort(char [] a){
		int j = 0;
		for(int p = 1 ; p < a.length ; p++ ){
			//�ӵڶ���Ԫ�ؿ�ʼ��β��
			char tmp = a[p]; //Ȼ���ȡ��p��Ԫ��
			for(j = p ; j > 0 && tmp<a[j-1] ; j--){
				//����ѭ��  j��������p��ʼ ��j-1Ԫ�ش���jԪ��ʱ  ����
				a[j] = a[j-1];
			}
			//�������������
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
