package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1114 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 10001;
	static int M = 10000000;

	/**
	 * @Descirbe 
	 * @Author Hope6537(赵鹏)
	 * @Params @param args
	 * @SignDate 2014-5-18下午04:26:41
	 * @Version 0.9
	 */
	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int minweight = s.nextInt();
				int maxweight = s.nextInt();
				int weight = maxweight - minweight;
				int type = s.nextInt();
				int[] values = new int[MAX];
				int[] weights = new int[MAX];
				int[] dp = new int [MAX];
				for (int i = 0; i < type; i++) {
					int v = s.nextInt();
					int w = s.nextInt();
					values[i]  = v;
					weights[i] = w;
				}
				for(int i = 0 ; i <= weight ; i++){
					dp[i] = M;
				}
				dp[0] = 0;
				//input done
				//套用完全背包公式
				/*
				 * dp[k] = max(dp[k],f[k-volume[i]]+value[i]);
				 * 只不过将max改成了min
				 */
				for(int i = 0 ; i < type ; i++){
					for(int j = weights[i] ; j <= weight ; j++ ){
						dp[j] = Math.min(dp[j], dp[j-weights[i]] + values[i]);
					}
				}
				if(dp[weight]!=M){
					System.out.println("The minimum amount of money in the piggy-bank is "+dp[weight]+".");
				}else{
					System.out.println("This is impossible.");
				}
				
			}

		}
	}
}
