package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2058 {

	
	static Scanner s = new Scanner(System.in);
	
	public static double leihe(double x , double y){
		return ((x+y)/2)  * (Math.abs(x-y)+1);
	}
	
	public static void jisuanLeihe(long start,long end,double m){
		if(true){
			long index_forward = start;
			
			for(long i = start ; ;){
				double leihe_forward = leihe(i,index_forward);
				if(i>m){
					return;
				}
				if(leihe_forward<m){
					index_forward++;
				}
				else if(leihe_forward == m){
					System.out.println("["+i+","+index_forward+"]");
					i++;
				}else if(leihe_forward > m){
					i++;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		while(s.hasNext()){
			
			double n = s.nextDouble();//个数
			double m = s.nextDouble();//目标值
			jisuanLeihe(1, (long)n, m);
			/*int index_forward = 1;
			for(int i = 1 ; ;){
				double leihe_forward = leihe(i,index_forward);
				if(i>((int)m)){
					break;
				}
				if(leihe_forward<m){
					index_forward++;
				}
				else if(leihe_forward == m){
					System.out.println("["+i+","+index_forward+"]");
					i++;
				}else if(leihe_forward > m){
					i++;
				}
			}*/
			System.out.println("done");
		}
	}
	
}
