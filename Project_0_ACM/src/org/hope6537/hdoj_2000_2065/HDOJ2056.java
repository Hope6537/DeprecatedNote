package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe WRONG ANSWER 还需研究边界问题
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-4-17下午9:14:28
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2056 {

	private static class Rectangles{
		double x1;
		double y1;
		double x2;
		double y2;
		public Rectangles(double x1, double y1, double x2, double y2) {
			this.x1 = x1 < x2 ? x1:x2;
			this.y1 = y1 < y2 ? y1:y2;
			this.x2 = x2 > x1 ? x2:x1;
			this.y2 = y2 > y1 ? y2:y1;
		}
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static double max(double a, double b){
		return a>b?a:b;
	}
	
	public static double min(double a, double b){
		return a>b?b:a;
	}
	public static void main(String[] args) {
		while(s.hasNext()){
			Rectangles r1 = new Rectangles(s.nextDouble(),s.nextDouble(),s.nextDouble(),s.nextDouble());
			Rectangles r2 = new Rectangles(s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble());
			double x = max(r1.x1, r2.x1) - min(r1.x2, r2.x2);
			double y = max(r1.y1, r2.y1) - min(r1.y2, r2.y2);
			if(x>0||y>0){
				System.out.println("0.00");
			}else{
				System.out.printf("%.2f\r\n",x*y);
			}
			
		}
		
	}
}
