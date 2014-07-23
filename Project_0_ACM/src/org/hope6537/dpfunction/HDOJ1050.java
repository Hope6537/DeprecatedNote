package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1050 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int[] p = new int[205];
				int n = s.nextInt();
				for (int i = 0; i < n; i++) {
					int s1 = s.nextInt();
					int d = s.nextInt();
					s1 = (s1 - 1) / 2;
					d = (d - 1) / 2;
					if (s1 > d) {
						int temp = s1;
						s1 = d;
						d = temp;
					}
					for (int k = s1; k < d; k++) {
						p[k]++;
					}
				}
				int max = -1;
				for(int i = 0 ; i < 200 ; i++){
					if(p[i] > max){
						max = p[i];
					}
				}
				System.out.println(max * 10);
			}
		}
	}

}
