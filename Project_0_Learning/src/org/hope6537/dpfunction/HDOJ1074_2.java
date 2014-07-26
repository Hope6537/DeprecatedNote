package org.hope6537.dpfunction;

import java.util.Scanner;
import java.util.Stack;

public class HDOJ1074_2 {

	static Scanner s = new Scanner(System.in);

	/**
	 * @Describe 这是实体模型
	 * @Author Hope6537(赵鹏)
	 * @Signdate 2014-5-16上午11:18:57
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private static class Node {
		String name;
		int d;
		int c;

		public Node(String name, int d, int c) {
			super();
			this.name = name;
			this.d = d;
			this.c = c;

		}

		@Override
		public String toString() {
			return "Node [c=" + c + ", d=" + d + ", name=" + name + "]";
		}

	}

	private static class Status {
		int runTime;
		int reduceTime;
		int preStatus;
		int lastIndex;

		@Override
		public String toString() {
			return "Status [上一个索引=" + lastIndex + ", 前驱状态="
					+ Integer.toBinaryString(preStatus) + ", 浪费的时间=" + reduceTime + ", 运行时间="
					+ runTime + "]";
		}

		public Status(int runTime, int reduceTime, int preStatus, int lastIndex) {
			super();
			this.runTime = runTime;
			this.reduceTime = reduceTime;
			this.preStatus = preStatus;
			this.lastIndex = lastIndex;
		}

	}

	static Node[] nodes;
	static Status[] status;

	/**
	 * @Descirbe 状态转移方程
	 * @Author Hope6537(赵鹏)
	 * @Params @param n
	 * @SignDate 2014-5-16下午12:08:26
	 * @Version 0.9
	 */
	public static void Dp(int n) {
		//前一个状态的索引标志
		int preStatus = 0;
		//表示扣除的分数
		int reduce = 0;
		/*
		 * 左移位 代表当前n个数据下会出现几种状态方程
		 */
		int maxStatus = 1 << n;
		// 状态集合 因为每一种状态都是唯一的，所以符合动态规划的重叠子问题的特点，使用表来装
		status = new Status[maxStatus];
		//对于第一个状态的初始化，初态设置为0，上一个状态为-1;
		status[0] = new Status(0, 0, -1, 0);
		//从第一个状态开始遍历，直到最后一个状态，即为状态为11111111 八门作业都写完的状态为止
		for (int i = 1; i < maxStatus; i++) {
			if (status[i] == null) {
				status[i] = new Status(0, 0, -1, 0);
			}
			//将初始时间设为最大值
			status[i].reduceTime = 0x7fffffff;
			//使用栈结构就是从后向前，这样在状态相同时，我们获取到的是按照正确字典序的状态排列
			for (int j = n - 1; j >= 0; j--) {
				// 获得这个作业的一个状态编号
				int temp = 1 << j;
				if ((i & temp) != 0) {
					// 如果状态i中11110 里 10出现 即写完了第二个作业
					// 那么找到他的前一个状态 即11110 - 10 = 11100 写完了3 4 5的作业的状态对象
					preStatus = i - temp;
					//获取到这个状态对象的写作业流逝的时间并加上这个第二个作业写的时间 
					reduce = status[preStatus].runTime + nodes[j].c
							- nodes[j].d;
					//再减去deadLine看超时的时间
					if (reduce < 0) {
						//如果不超时,合法化下
						reduce = 0;
					}
					/*
					 * 如果状态11110 即写完了第二个作业的拖延时间大于现在刚刚计算完的时间
					 * 如果这里表达的不清楚 那么意思就是
					 * 对于状态11110:
					 * 11100 + 10 3、4、5 写完 写第二个
					 * 10110 + 1000 2、3、5 写完 写第四个
					 * 01110 + 10000 2、3、4写完 写第五个
					 * 这几种情况出现，每一种的情况的拖延时间都不同，所以存储拖延时间最少的哪一组
					 * 来作为接下来状态深入的标准。
					 * 这样我们才能得到最优解
					 */
					//即获取到了更优的解法。那么我们就更改路径
					if (status[i].reduceTime > status[preStatus].reduceTime
							+ reduce) {
						//赋值
						status[i].reduceTime = status[preStatus].reduceTime
								+ reduce;
						//将前驱改为j 即以第二个作业为主
						status[i].lastIndex = j;
						status[i].preStatus = preStatus;
						status[i].runTime = status[preStatus].runTime
								+ nodes[j].c;
					}
					//DP完成
				}
			}
		}
	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			while (T-- != 0) {

				int n = s.nextInt();

				nodes = new Node[n];

				for (int i = 0; i < n; i++) {
					String name = s.next();
					int d = s.nextInt();
					int c = s.nextInt();
					nodes[i] = new Node(name, d, c);
				}
				// 现在按照字典序排列 是有序的
				Dp(n);
				// 然后开始输出
				Stack<Integer> stack = new Stack<Integer>();
				int tempState = (1 << n) - 1;
				int tempCourse = 0;
				System.out.println(status[tempState].reduceTime);
				while (tempState != 0) {
					tempCourse = status[tempState].lastIndex;
					stack.push(tempCourse);
					tempState = status[tempState].preStatus;
				}
				while (!stack.empty()) {
					tempCourse = stack.pop();
					System.out.println(nodes[tempCourse].name);
				}

			}
		}
	}
}
