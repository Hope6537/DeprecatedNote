package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @Describe �����������Ȱ���һ��������C����ʾ��C����������� ÿ����������ĵ�һ������������n��m(1<=n<=100, 1<=m<=100),
 *           �ֱ��ʾ���ѵĽ��ʹ��׵����࣬ Ȼ����m�����ݣ�ÿ�а���3����p��h��c(1<=p<=20,1<=h<=200,1<=c<=20)��
 *           �ֱ��ʾÿ���ļ۸�ÿ���������Լ���Ӧ������׵Ĵ�����
 * @Author Hope6537(����)
 * @Signdate 2014-5-21����08:13:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2191 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int C = s.nextInt();
		while (C-- != 0) {
			/*
			 * �����������Ȱ���һ��������C����ʾ��C����������� ÿ����������ĵ�һ������������n��m(1<=n<=100,
			 * 1<=m<=100), �ֱ��ʾ���ѵĽ��ʹ��׵����࣬
			 * Ȼ����m�����ݣ�ÿ�а���3����p��h��c(1<=p<=20,1<=h<=200,1<=c<=20)��
			 * �ֱ��ʾÿ���ļ۸�ÿ���������Լ���Ӧ������׵Ĵ�����
			 */
			int n = s.nextInt();
			int m = s.nextInt();
			int[] cash = new int[m + 1];
			int[] weight = new int[m + 1];
			int[] type = new int[m + 1];
			for (int i = 1; i <= m; i++) {
				int p = s.nextInt();
				int h = s.nextInt();
				int c = s.nextInt();
				cash[i] = p;
				weight[i] = h;
				type[i] = c;
			}
			/*
			 * ����ÿ��������ݣ�������ܹ�������׵��������������Լ��辭���򲻹����еĴ��ף� ���Ҿ�������Բ����ꡣÿ��ʵ�������ռһ�С�
			 */
			/**
			 * N����Ʒ��һ������ΪV�ı�������i����Ʒ�����n[i]�����ã�ÿ��������c[i]����ֵ��w[i]��
			 * ��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�ķ����ܺͲ����������������Ҽ�ֵ�ܺ����
			 * ��f[i][v]��ʾǰi����Ʒǡ����һ������Ϊv�ı��������Ȩֵ
			 * 
			 * f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k<=n[i]}
			 */

			/*
			 * dp[i][j]��ʾǰi�ִ���ǡ�ý��Ϊv����ֵ�򵽵�������� cash[i] = c[i] ����۸� �����൱�ڱ���������
			 * weight[i] = w[i] �������� �����൱�ڱ����ڵ���Ʒ�ļ�ֵ type[i] = n[i] �����i����Ʒ�Ŀ�������
			 * dp[i][j] = max{dp[i-1][v - k * cash[i]] + k * weight[i]}
			 * (0<=k<=type[i]) n�����ѵĽ�� m������׵�����
			 */
			/*
			 * int[][] dp = new int[m+5][n+5]; for(int i = 1 ; i <= m ; i++){
			 * for(int j = n ; j >= type[i] * cash[i] ; j--){ dp[i][j] = 0;
			 * for(int k = 0 ; k <= type[i] ; k++){ int res = dp[i-1][j - (k *
			 * cash[i])] + k * weight[i]; if(res > dp[i][j]){ dp[i][j] = res; }
			 * }
			 * 
			 * } }
			 */
			int[] dp = new int[n + 1];
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j < type[i]; j++) {
					for (int k = n; k >= cash[i]; k--) {
						int res = dp[k-cash[i]] + weight[i];
						if(res > dp[k]){
							dp[k] = res;
						}
					}
				}
			}
			System.out.println(dp[n]);
//			System.out.println(dp[m][n]);

		}

	}
}
