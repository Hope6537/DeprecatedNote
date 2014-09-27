package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1074 {

	static Scanner s = new Scanner(System.in);

	private static class Node {
		int index;
		int d;
		int c;
		boolean visit;

		@Override
		public String toString() {
			return "Node [c=" + c + ", d=" + d + ", index=" + index + "]";
		}

		public Node(int index, int d, int c) {
			super();
			this.index = index;
			this.d = d;
			this.c = c;
		}

	}

	public static int f(int index, int time, int min, int stringindex, int step) {
		/*
		 * 我们来重新定义一下这个递归 对于递归的一开始 我们给他一个起点 从起点开始 依次搜索所有的路径 然后得到这些路径的总长
		 * 比较并得到一个路径最短的值 同时记录该最短路径的path
		 */
		// 定义起点
		Node node = nodes[index];

		// 获取到这条路径已经走的时间
		int thisTime = time;
		// 获取到这条路径已经走的路径长，即现在拖延的时间数 以正数表示
		int thisMin = min;
		// 这是以该node顶点为起点，它的拖延数最少的临时变量 最后需要加到+thisMin里
		int tempMin = index + 1 < nodes.length ? Integer.MAX_VALUE : 0;
		// 开始循环 以node点为起点 从i+1到数组边界
		for (int i = 0; i < nodes.length; i++) {
			Node tempNode = nodes[i];
			if (!tempNode.visit && i != index) {
				int tempMin2 = 0;
				// 获取到下一个节点的路径
				// 然后开始加时间
				thisTime += tempNode.c;
				// 如果出现超时的状况
				// 然后获取到以这个temp节点为起点的最短路径
				// 这样tempMin2 就是以temp节点为起点，直到走到头的最短路径长了。
				tempMin2 += f(i, thisTime, tempMin2, tempNode.index, step + 1);
				if (thisTime > tempNode.d) {
					// 那么将拖延的时间加上去
					tempMin2 = thisTime - node.d;
				}
				// 如果这个tempMin2是现在【下一个节点】中最小的那个，那么赋值过去
				if (tempMin2 < tempMin) {
					tempMin = tempMin2;
					steps[step + 1] = i;
				} else if (tempMin == min) {
					if (tempNode.index > stringindex) {
						tempMin = tempMin2;
						steps[step + 1] = i;
					}
				}
			}
		}
		node.visit = true;
		return tempMin + thisMin;
	}

	static Node[] nodes;
	static String[] names;
	static int[] steps;
	static int[] mins;

	public static void main(String[] args) {

		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {
				int n = s.nextInt();
				nodes = new Node[n];
				names = new String[n];
				steps = new int[n];
				mins = new int[n];
				for (int i = 0; i < n; i++) {
					names[i] = s.next();
					int d = s.nextInt();
					int c = s.nextInt();
					nodes[i] = new Node(i, d, c);
				}
				// input done
				/*
				 * 2014年5月15日19:01:26 应当按照deadLine时间进行排序 正常情况下 我们需要找到第一个要做的
				 * 然后找找找……知道找到最好要做的 而根据动态规划的鸟蛋尿性 经常我们要反着想 我们找到最晚能做完的。然后再往回走？
				 * 2014年5月15日19:03:30 但题目输出要求是需要进行顺序输出，即完成作业的顺序，
				 * 所以还是依照deadline时间的递增进行排序为好 如果两者的deadLine相同？那么对c应该如何排序？
				 * 2014年5月15日19:03:38 对于c的排序？应该是升序排序？小的排前面？
				 * 实际上牵扯到对问题的思考了。尽可能完成多的科目？或者是尽量节省时间？ 实际上无论怎么排序
				 * 做作业的时间都是相同的，而且减分相同，所以没有必要 2014年5月15日19:06:15
				 * 2014年5月15日19:24:07 但是注意 需要按照字典序进行排列 所以对于index要按照递增来排序
				 */
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (nodes[i].d < nodes[j].d) {
							Node temp = nodes[i];
							nodes[i] = nodes[j];
							nodes[j] = temp;
						}
						if (nodes[i].d == nodes[j].d) {
							if (nodes[i].index < nodes[j].index) {
								Node temp = nodes[i];
								nodes[i] = nodes[j];
								nodes[j] = temp;
							}
						}
					}
				}
				// sort done
				/*
				 * int min = 0;
				 * 
				 * 2014年5月15日19:08:35 第一步，先找最紧急的事情来做， 接着依次进行操作，同时计算溢出时间。
				 * 
				 * int time = 0; int[] finished = new int[n]; for (int i = 0; i
				 * < n; i++) { Node node = nodes[i]; // 如果做之前就超出时间 if (node.d <
				 * time) { min += node.c; time += node.c; } // 如果做完了也不超出时间 else
				 * if (node.c + time <= node.d) { time += node.c; } // 如果做完了超出时间
				 * else { int leftT = (node.c + time) - node.d; time +=
				 * (node.c); min += leftT; } finished[i] = node.index; }
				 */
				System.out.println(f(0, nodes[0].c, 0, nodes[0].index, 0));
				for (int i = 0; i < n; i++) {
					System.out.println(names[steps[i]]);
				}
				/*
				 * for (int i = 0; i < n; i++) {
				 * System.out.println(names[finished[i]]); }
				 */
			}

		}

	}

}
