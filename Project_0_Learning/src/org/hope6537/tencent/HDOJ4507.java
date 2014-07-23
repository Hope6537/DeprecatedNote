package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4507 {

	static int mod = 1000000000 + 7;
	static int MAX = 50;
	static long p[];// p[i]表示10^i
	static long digit[];
	static node[][][] dp;// //dp[i][j][k]表示i的前部分每位和模7余j,后部分模7余k
	static class node {
		long n;// 代表后缀的个数
		long rear;// 代表后缀和
		long rearpow;// 代表后缀平方和

		@Override
		public String toString() {
			return "node [n=" + n + ", rear=" + rear + ", rearpow=" + rearpow
					+ "]";
		}

		public node() {
			super();
		}

		public node(long n, long rear, long rearpow) {
			super();
			this.n = n;
			this.rear = rear;
			this.rearpow = rearpow;
		}

	}


	static void init(long n) {
		digit[0] = 0;
		while (n != 0) {
			int index = (int) ++digit[0];
			digit[index] = (n % 10);
			n = n / 10;
		}
	}

	// 依据性质：(a+b1)^2+(a+b2)^2+...(a+bn)^2 = n*a^2+2*a*(b1+b2+...bn)+b1^2+b2^2+...bn^2
	/**
	 * @Descirbe 递推例程
	 * @Author Hope6537(赵鹏)
	 * @param size 后缀长度
	 * @param j
	 * @param k
	 * 			前后段是否合法
	 * @param b 
	 * @return
	 * @SignDate 2014-6-6下午8:11:46
	 * @Version 0.9
	 */
	static node dfs(int size, int j, int k, boolean b) {
		node sum = new node(), num = new node();
		if (size == 0) {
			// 后缀数长度为0
			sum.n = (j != 0 && k != 0) ? 1 : 0;
			// 表示在size前部分的数是否符合条件(整个数就是前部分)
			return sum;
		}
		if (b && dp[size][j][k].n != -1) {
			return dp[size][j][k];//b == true 表示size后部分的数可以随意取,dp[][][].n != -1表示已经寻找过  
		}
		long m = b ? 9 : digit[size];
		for (int i = 0; i <= m; ++i) {
			if (i == 7) {
				continue;
			}
			num = dfs(size - 1, (j + i) % 7, (k * 10 + i) % 7, b || i < m);//取模失误导致WA1次
			sum.n += num.n;
			sum.n %= mod;
			// i*10^i+x1+i*10^i+x2+.....=i*10^i*n+(x1+x2+...xn)
			sum.rear += (p[size - 1] * i % mod * num.n + num.rear);
			sum.rear %= mod;

			// (i*10^i+x1)^2+(i*10^i+x2)^2+(i*10^i+x3)^2+...=(i*10^i)^2*n+2*i*10^i*(x1+x2+...xn)+(x1^2+x2^2+...xn^2)
			sum.rearpow += (p[size - 1] * p[size - 1] % mod * i * i % mod
					* num.n + 2 * p[size - 1] * i % mod * num.rear + num.rearpow);
			sum.rearpow %= mod;

		}
		if (b) {
			dp[size][j][k] = sum;
		}
		return sum;
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		dp = new node[MAX][7][7];
		p = new long[MAX];
		digit = new long[MAX];
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < 7; j++) {
				for (int k = 0; k < 7; k++) {
					dp[i][j][k] = new node(-1, -1, -1);
				}
			}
		}
		p[0] = 1;
		for (int i = 1; i < MAX; i++) {
			p[i] = (p[i - 1] * 10) % mod;// 取模！！！ WA了2次
		}
		int t = s.nextInt();
		while (t-- != 0) {
			long l = s.nextLong();
			long r = s.nextLong();
			init(r);
			long b = dfs((int) digit[0], 0, 0, false).rearpow;
			init(l - 1);
			long a = dfs((int) digit[0], 0, 0, false).rearpow;
			System.out.println((b - a + mod) % mod);
		}
	}
}
