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
			 * ��̬�滮����2 dp[j] �����j������� dp[j] = max{dp[j],dp[ns[i].s-1] +
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
			 * ��̬�滮���� dp[i] ����ǰi���������������Ǯ�� dp[i]
			 * =max{(max{dp[ns[1].end],dp[ns[1].start-1] +
			 * ns[1].value}),...,(max{dp[ns[i].end],dp[ns[i].start-1] +
			 * ns[i].value})} ��ʱ
			 */
			/*
			 * for (int i = 1; i <= n; i++) { dp[ns[i].e] = max(dp[ns[i].e],
			 * dp[ns[i].s - 1] + ns[i].v); for (int j = ns[i].e + 1; j <= m;
			 * j++) { dp[j] = max(dp[j], dp[j - 1]); } }
			 * System.out.println(dp[m]);
			 */

			/*
			 * ̰���㷨��ʱ
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
	 * @Descirbe ѡ����ŦԪ
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param left ���������α�
	 * @Params @param right �Ҳ�������α�
	 * @Params @return
	 * @SignDate 2014-4-6����04:04:12
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static <AnyType extends Comparable<? super AnyType>> AnyType median3(
			AnyType[] a, int left, int right) {
		// �ҳ���ֵ��
		int center = (left + right) / 2;
		// �������С���󶨵� �򻥻�
		if (a[center].compareTo(a[left]) < 0) {
			swapReferences(a, left, center);
		}
		// ����Ҳ�С����� �򻥻�
		if (a[right].compareTo(a[left]) < 0) {
			swapReferences(a, left, right);
		}
		// ����Ҳ�С������ �򻥻�
		if (a[right].compareTo(a[center]) < 0) {
			swapReferences(a, center, right);
		}
		// ��������С�������� left center right��������
		/*
		 * �����ĵ����� ����ŦԪ���Ҳ�-1λ�õ��α���н��� ��Ϊleft center right�Ƿ����������е�
		 * ��������������Ǵ�left+1��right-2��
		 */

		swapReferences(a, center, right - 1);

		return a[right - 1];
	}

	private static final int CUTOFF = 3;

	private static <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a, int left, int right) {
		if (left + CUTOFF <= right) {
			// ������α굽���α�������Ԫ��
			// ��ô˵����ŦԪ����
			AnyType pivot = median3(a, left, right);
			// �������ұ߽翪ʼ���б���
			int i = left;
			int j = right - 1;
			for (;;) {
				// ����ѭ��
				while (a[++i].compareTo(pivot) < 0) {
					// �������ʼ�����ı�����������ŦԪ��С ����ű��� ֱ������������ŦԪ��ֹͣ
				}
				while (a[--j].compareTo(pivot) > 0) {
					// ������ҿ�ʼ����ı�����������ŦԪ�Ĵ� ����ű��� ֱ������С����ŦԪ��ֹͣ
				}
				if (i < j) {
					// ���i j�ı߽�Ϸ� �򻥻�
					swapReferences(a, i, j);
				} else {
					// ����߽粻�Ϸ� ��˵���������Ѿ�������� ����
					break;
				}
			}
			// ����ŦԪ������
			swapReferences(a, i, right - 1);
			// ͬʱ�ٽ������S1 S2����Ⱥ���зָ�����
			quickSort(a, left, i - 1);
			quickSort(a, i, right);

		} else {
			// ���ָ�ɽ���3��Ԫ��ʱ ��ô������������,�źõ�ͬʱ�ݹ鷵��
			insertionSort(a, left, right);
		}
	}

	/**
	 * @Descirbe ���߽�Ĳ�������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param left
	 * @Params @param right
	 * @SignDate 2014-4-6����04:18:28
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
	 * @Descirbe ����Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param index1
	 * @Params @param index2
	 * @SignDate 2014-4-6����01:42:56
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
