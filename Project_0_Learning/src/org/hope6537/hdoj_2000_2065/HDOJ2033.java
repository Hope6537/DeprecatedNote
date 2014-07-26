package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe 人见人爱A+B
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-4-15下午1:03:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2033 {
	
	private static class Time{
		int shi;
		int fen;
		int miao;
		public Time(int h , int m , int s){
			shi=h;
			fen=m;
			miao=s;
		}
		
		public Time jisuan(Time t){
			int newmiao = this.miao + t.miao;
			if(newmiao/60>0){
				this.fen = this.fen + (newmiao / 60);
			}
			this.miao = newmiao%60;
			int newfen = this.fen + t.fen;
			if(newfen/60>0){
				this.shi = this.shi + (newfen / 60);
			}
			this.fen = newfen%60;
			this.shi = this.shi + t.shi;
			return this;
		}
	}
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n  = s.nextInt();
			for(int i = 0 ; i < n ; i++){
				 Time a = new Time(s.nextInt(),s.nextInt(),s.nextInt());
				 Time b = new Time(s.nextInt(),s.nextInt(),s.nextInt());
				 a.jisuan(b);
				 System.out.println(a.shi+" "+a.fen+" "+a.miao);
			}
		}
	}

}
