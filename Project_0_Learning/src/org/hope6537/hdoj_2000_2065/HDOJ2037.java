package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2037 {
	
	private static class Show{
		int start ;
		int end;
		public Show(int i , int j){
			start = i;
			end = j;
		}
		
	}
	
	private static void insertionSort(Show [] a){
		int j = 0;
		for(int p = 1 ; p < a.length ; p++ ){
			//从第二个元素开始到尾部
			Show tmp = a[p]; //然后获取第p个元素
			for(j = p ; j > 0 && (tmp.end)<(a[j-1].end) ; j--){
				//进行循环  j的索引从p开始 到j-1元素大于j元素时  交换
				a[j] = a[j-1];
			}
			//最后变量交换完毕
			a[j] = tmp;
		}
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while (s.hasNext()) {
			int n = s.nextInt();
			if(n==0){
				break;
			}
			Show [] shows = new Show [n];
			for(int i = 0 ; i < n ; i ++){
				shows[i] = new Show(s.nextInt(), s.nextInt());
			}
			insertionSort(shows);
			/*for(int i = 0 ; i < n ; i++){
				System.out.println(shows[i].start + " " + shows[i].end);
			}*/
			//input done
			for(Show s : shows){
				System.out.println(s.start + " " + s.end);
			}
			int maxcount = 1;
			for(int i = 0 ; i < n ; i++){
				int count = 1;
				Show startShow = shows[i];
				//int time = startShow.start;
				for(int j = 0 ; j < n ; j++){
					Show nextShow = shows[j];
					if(nextShow.start < startShow.end){ //如果下一个节目开始的时间早于之前的节目
						continue;
					}else{
						startShow = nextShow;
						count++;
						if(count>maxcount){
							maxcount = count;
						}
					}
				}
			}
			System.out.println(maxcount);
		}
	}

}
