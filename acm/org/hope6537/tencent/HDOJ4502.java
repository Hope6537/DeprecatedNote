package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4502 {

	static Scanner s = new Scanner(System.in);

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {

		int T = s.nextInt();
		while (T-- != 0) {
			int m = s.nextInt();
			int n = s.nextInt();
			Node[] ns = new Node[n + 1];
			ns[0] = new Node(0, 0, 0);
			for (int i = 1; i <= n; i++) {
				int start = s.nextInt();
				int end = s.nextInt();
				int value = s.nextInt();
				ns[i] = new Node(start, end, value);
			}
			int[] dp = new int[1005];
			QuickSort.quickSort(ns);

			/*
			 * 动态规划方法2 dp[j] 代表第j天的收入 dp[j] = max{dp[j],dp[ns[i].s-1] +
			 * ns[i].value}
			 */

			for (int i = 1; i <= n; i++) {
				for (int j = m; j >= ns[i].e; j--) {
					if (dp[j] < dp[ns[i].s - 1] + ns[i].v) {
						dp[j] = dp[ns[i].s - 1] + ns[i].v;
					}
				}
			}
			System.out.println(dp[m]);

			/*
			 * 动态规划方法 dp[i] 代表前i个工作能挣的最多钱数 dp[i]
			 * =max{(max{dp[ns[1].end],dp[ns[1].start-1] +
			 * ns[1].value}),...,(max{dp[ns[i].end],dp[ns[i].start-1] +
			 * ns[i].value})} 超时
			 */
			/*
			 * for (int i = 1; i <= n; i++) { dp[ns[i].e] = max(dp[ns[i].e],
			 * dp[ns[i].s - 1] + ns[i].v); for (int j = ns[i].e + 1; j <= m;
			 * j++) { dp[j] = max(dp[j], dp[j - 1]); } }
			 * System.out.println(dp[m]);
			 */

			/*
			 * 贪心算法超时
			 * 
			 * } } int max = 0; for (int i = 0; i < n; i++) { Node temp = ns[i];
			 * if (temp.e <= m) { int value = temp.v; for (int j = i + 1; j < n;
			 * j++) { Node temp2 = ns[j]; if (temp2.s > temp.e && temp2.e <= m)
			 * { value += temp2.v; temp = temp2; } } if (value > max) { max =
			 * value; } } } System.out.println(max);
			 */
		}

	}

	static class Node implements Comparable<Node> {
		int s;
		int e;
		int v;

		@Override
		public int compareTo(Node o) {
			if (e - o.e != 0) {
                return e - o.e;
            } else {
                return o.v - v;
            }
		}

		public Node(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", s=" + s + ", v=" + v + "]";
		}
	}
}

class QuickSort {

	/**
	 * @Descirbe 选择枢纽元
	 * @Author Hope6537(赵鹏)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param left 左侧的索引游标
	 * @Params @param right 右侧的索引游标
	 * @Params @return
	 * @SignDate 2014-4-6下午04:04:12
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static <AnyType extends Comparable<? super AnyType>> AnyType median3(
			AnyType[] a, int left, int right) {
		// 找出中值点
		int center = (left + right) / 2;
		// 如果中心小于左定点 则互换
		if (a[center].compareTo(a[left]) < 0) {
			swapReferences(a, left, center);
		}
		// 如果右侧小于左侧 则互换
		if (a[right].compareTo(a[left]) < 0) {
			swapReferences(a, left, right);
		}
		// 如果右侧小于中心 则互换
		if (a[right].compareTo(a[center]) < 0) {
			swapReferences(a, center, right);
		}
		// 这样最后从小到大则是 left center right进行排列
		/*
		 * 将中心的数据 即枢纽元和右侧-1位置的游标进行交换 因为left center right是符合排序序列的
		 * 所以排序的主体是从left+1到right-2的
		 */

		swapReferences(a, center, right - 1);

		return a[right - 1];
	}

	private static final int CUTOFF = 3;

	private static <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a, int left, int right) {
		if (left + CUTOFF <= right) {
			// 如果左游标到右游标有三个元素
			// 那么说明枢纽元可用
			AnyType pivot = median3(a, left, right);
			// 将从左右边界开始进行遍历
			int i = left;
			int j = right - 1;
			for (;;) {
				// 进入循环
				while (a[++i].compareTo(pivot) < 0) {
					// 如果从左开始遇到的遍历的数比枢纽元的小 则接着遍历 直到遇到大于枢纽元的停止
				}
				while (a[--j].compareTo(pivot) > 0) {
					// 如果从右开始语调的遍历的数比枢纽元的大 则接着遍历 直到遇到小于枢纽元的停止
				}
				if (i < j) {
					// 如果i j的边界合法 则互换
					swapReferences(a, i, j);
				} else {
					// 如果边界不合法 则说明该数组已经排序完成 跳出
					break;
				}
			}
			// 将枢纽元换回来
			swapReferences(a, i, right - 1);
			// 同时再将两侧的S1 S2数据群进行分割排序
			quickSort(a, left, i - 1);
			quickSort(a, i, right);

		} else {
			// 最后分割成仅有3个元素时 那么插入排序走你,排好的同时递归返回
			insertionSort(a, left, right);
		}
	}

	/**
	 * @Descirbe 带边界的插入排序
	 * @Author Hope6537(赵鹏)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param left
	 * @Params @param right
	 * @SignDate 2014-4-6下午04:18:28
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param left
	 * @param right
	 */
	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(
			AnyType[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) {
			AnyType tmp = a[p];
			int j;

			for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * @Descirbe 交换元素
	 * @Author Hope6537(赵鹏)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param index1
	 * @Params @param index2
	 * @SignDate 2014-4-6下午01:42:56
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param index1
	 * @param index2
	 */
	public static <AnyType> void swapReferences(AnyType[] a, int index1,
			int index2) {
		AnyType tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	public static <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a) {
		quickSort(a, 0, a.length - 1);
	}

}
