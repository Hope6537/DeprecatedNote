package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ2059_2 {
	static Scanner s = new Scanner(System.in);

	/*
	 * ��һ����һ������L�����ܵ����ܳ��� �ڶ��а�����������N��C��T���ֱ��ʾ���վ�ĸ������綯���������Ժ�����ʻ�ľ����Լ�ÿ�γ������Ҫ��ʱ��
	 * ������Ҳ����������VR��VT1��VT2���ֱ��ʾ�����ܲ����ٶȣ��ڹ꿪�綯�����ٶȣ��ڹ�ŵŵ綯�����ٶ�
	 * �����а�����N(N<=100)������p1,p2...pn,�ֱ��ʾ�������վ���ܵ����ľ��룬����0<p1<p2<...<pn<L
	 */
	public static double max(double a, double b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			double L = s.nextDouble();
			int N = s.nextInt();
			double C = s.nextDouble();
			double T = s.nextDouble();
			double VR = s.nextDouble();
			double VT1 = s.nextDouble();
			double VT2 = s.nextDouble();
			double[] P = new double[N + 2];
			for (int i = 1; i <= N; i++) {
				P[i] = s.nextDouble();
			}
			P[N + 1] = L;
			double rabbitTime = 1.0 * L / VR;
			// input done
			// ��״̬���̰�ͬѧ .....��
			// ��ô����վ�������0 ��һ������վ�±���1---->N
			// dp[i]�����ڹ꾭��Ҫ�ӵ�i������վ׼������ʱ��ʱ��
			// dp[i] = dp[i-1]+Max{T + len - C > 0 ? C/VT1 + len-C / VT2 : len/VT1 , (C-tempC)/VT1 + (len - (C - tempC) > 0?len - (C - tempC) : 0 )/VT2}
			double dp[] = new double[N + 2];
			dp[0] = 0;
			for (int i = 1; i <= N + 1; i++) {
				dp[i] = 0xffffff;
				double time = 0;
				for (int j = 0; j < i; j++) {
					double len = P[i] - P[j];
					if (len > C) {
						time = C / VT1 + (len - C) / VT2;
					} else {
						time = len / VT1;
					}
					time += dp[j];
					if (j > 0) {
						time += T;
					}
					dp[i] = Math.min(dp[i], time);
				}
			}
			System.out.println(rabbitTime > dp[N + 1] ? "What a pity rabbit!"
					: "Good job,rabbit!");
		}
	}
}
