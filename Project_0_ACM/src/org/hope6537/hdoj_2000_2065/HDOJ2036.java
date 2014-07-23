package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2036 {
	
	private static class S{
		int bianshu;
		int [] x;
		int [] y;
		double mianji;
		public S(int s){
			this.bianshu = s;
			x  = new int [bianshu];
			y  = new int [bianshu];
		}
		/**
		 * @Descirbe 采用将凹多边型分割三角的方法进行计算
		 * @Author Hope6537(赵鹏)
		 * @Params 
		 * @SignDate 2014-4-15下午2:02:28
		 * @Version 0.9
		 */
		public void getMianji(){
			double sum = 0;
			double tri = 0;
			for(int i=1;i <bianshu-1 ; i++){
				int x0 = x[0];
				int xi = x[i];
				int xijia1 = x[i+1];
				int y0 = y[0];
				int yi = y[i];
				int yijia1 = y[i+1];
				tri=((x0-xijia1)*(yi-yijia1)-(xi-xijia1)*(y0-yijia1))/2.0; //以横轴为界限 分别求两个三角形
				sum+=tri;
			}
			this.mianji = sum;
		}
	}
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			S d = new S(n);
			if(n==0 || n<3){
				break;
			}
			for(int i = 0 ; i < n ; i ++){
				d.x[i] = s.nextInt();
				d.y[i] = s.nextInt();
			}
			d.getMianji();
			System.out.printf("%.1f\r\n",d.mianji);
			//input done
			
		}
	}

}
