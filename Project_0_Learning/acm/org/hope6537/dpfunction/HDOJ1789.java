package org.hope6537.dpfunction;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class HDOJ1789 {

	static Scanner s = new Scanner(new BufferedInputStream(System.in));

	private static class node {
		int deadline;
		int reduce;
		boolean isVisit;

		public node(int deadline, int reduce) {
			super();
			this.deadline = deadline;
			this.reduce = reduce;
			this.isVisit = false;
		}

		@Override
		public String toString() {
			return "node [deadline=" + deadline + ", reduce=" + reduce + "]";
		}

		public node() {
			super();
			this.isVisit = false;
		}

	}

	static int MAX = 1005;

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				node[] nodes = new node[n];
				for (int i = 0; i < n; i++) {
					nodes[i] = new node();
					nodes[i].deadline = s.nextInt();
				}
				for (int i = 0; i < n; i++) {
					nodes[i].reduce = s.nextInt();
				}
				// input done
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (nodes[i].reduce > nodes[j].reduce) {
							node temp = nodes[i];
							nodes[i] = nodes[j];
							nodes[j] = temp;
						} else if (nodes[i].reduce == nodes[j].reduce) {
							if (nodes[i].deadline < nodes[j].deadline) {
								node temp = nodes[i];
								nodes[i] = nodes[j];
								nodes[j] = temp;
							}

						}
					}
				}
				// sort done
				/*
				 * 先按所扣分数的高低降序排序，分数一样的时候就按日期升序排序 然后就从头开始做：
				 * 如果它的deadline那一天没有被其他作业占用，那么就直接在那一天做就可以
				 * 否则，就向前找，找到有一天是没有被占用的，就在那一天做。 找不到的话，就只能被扣分。
				 */

				node[] status = new node[MAX];
				int reduce = 0;
				for (int i = 0; i < n; i++) {
					boolean isfound = false;
					for (int j = nodes[i].deadline; j >= 1; j--) {
						if(status[j]==null){ 
							status[j] = nodes[i];
							isfound = true;
							break;
						}
					}
					if(!isfound){
						reduce += nodes[i].reduce;
					}
				}

				System.out.println(reduce);
			}
		}
	}

}
