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
		 * ���������¶���һ������ݹ� ���ڵݹ��һ��ʼ ���Ǹ���һ����� ����㿪ʼ �����������е�·�� Ȼ��õ���Щ·�����ܳ�
		 * �Ƚϲ��õ�һ��·����̵�ֵ ͬʱ��¼�����·����path
		 */
		// �������
		Node node = nodes[index];

		// ��ȡ������·���Ѿ��ߵ�ʱ��
		int thisTime = time;
		// ��ȡ������·���Ѿ��ߵ�·���������������ӵ�ʱ���� ��������ʾ
		int thisMin = min;
		// �����Ը�node����Ϊ��㣬�������������ٵ���ʱ���� �����Ҫ�ӵ�+thisMin��
		int tempMin = index + 1 < nodes.length ? Integer.MAX_VALUE : 0;
		// ��ʼѭ�� ��node��Ϊ��� ��i+1������߽�
		for (int i = 0; i < nodes.length; i++) {
			Node tempNode = nodes[i];
			if (!tempNode.visit && i != index) {
				int tempMin2 = 0;
				// ��ȡ����һ���ڵ��·��
				// Ȼ��ʼ��ʱ��
				thisTime += tempNode.c;
				// ������ֳ�ʱ��״��
				// Ȼ���ȡ�������temp�ڵ�Ϊ�������·��
				// ����tempMin2 ������temp�ڵ�Ϊ��㣬ֱ���ߵ�ͷ�����·�����ˡ�
				tempMin2 += f(i, thisTime, tempMin2, tempNode.index, step + 1);
				if (thisTime > tempNode.d) {
					// ��ô�����ӵ�ʱ�����ȥ
					tempMin2 = thisTime - node.d;
				}
				// ������tempMin2�����ڡ���һ���ڵ㡿����С���Ǹ�����ô��ֵ��ȥ
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
				 * 2014��5��15��19:01:26 Ӧ������deadLineʱ��������� ��������� ������Ҫ�ҵ���һ��Ҫ����
				 * Ȼ�������ҡ���֪���ҵ����Ҫ���� �����ݶ�̬�滮�������� ��������Ҫ������ �����ҵ�����������ġ�Ȼ���������ߣ�
				 * 2014��5��15��19:03:30 ����Ŀ���Ҫ������Ҫ����˳��������������ҵ��˳��
				 * ���Ի�������deadlineʱ��ĵ�����������Ϊ�� ������ߵ�deadLine��ͬ����ô��cӦ���������
				 * 2014��5��15��19:03:38 ����c������Ӧ������������С����ǰ�棿
				 * ʵ����ǣ�����������˼���ˡ���������ɶ�Ŀ�Ŀ�������Ǿ�����ʡʱ�䣿 ʵ����������ô����
				 * ����ҵ��ʱ�䶼����ͬ�ģ����Ҽ�����ͬ������û�б�Ҫ 2014��5��15��19:06:15
				 * 2014��5��15��19:24:07 ����ע�� ��Ҫ�����ֵ���������� ���Զ���indexҪ���յ���������
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
				 * 2014��5��15��19:08:35 ��һ������������������������� �������ν��в�����ͬʱ�������ʱ�䡣
				 * 
				 * int time = 0; int[] finished = new int[n]; for (int i = 0; i
				 * < n; i++) { Node node = nodes[i]; // �����֮ǰ�ͳ���ʱ�� if (node.d <
				 * time) { min += node.c; time += node.c; } // ���������Ҳ������ʱ�� else
				 * if (node.c + time <= node.d) { time += node.c; } // ��������˳���ʱ��
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
