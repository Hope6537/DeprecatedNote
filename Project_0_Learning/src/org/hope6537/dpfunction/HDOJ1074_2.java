package org.hope6537.dpfunction;

import java.util.Scanner;
import java.util.Stack;

public class HDOJ1074_2 {

	static Scanner s = new Scanner(System.in);

	/**
	 * @Describe ����ʵ��ģ��
	 * @Author Hope6537(����)
	 * @Signdate 2014-5-16����11:18:57
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
			return "Status [��һ������=" + lastIndex + ", ǰ��״̬="
					+ Integer.toBinaryString(preStatus) + ", �˷ѵ�ʱ��=" + reduceTime + ", ����ʱ��="
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
	 * @Descirbe ״̬ת�Ʒ���
	 * @Author Hope6537(����)
	 * @Params @param n
	 * @SignDate 2014-5-16����12:08:26
	 * @Version 0.9
	 */
	public static void Dp(int n) {
		//ǰһ��״̬��������־
		int preStatus = 0;
		//��ʾ�۳��ķ���
		int reduce = 0;
		/*
		 * ����λ ����ǰn�������»���ּ���״̬����
		 */
		int maxStatus = 1 << n;
		// ״̬���� ��Ϊÿһ��״̬����Ψһ�ģ����Է��϶�̬�滮���ص���������ص㣬ʹ�ñ���װ
		status = new Status[maxStatus];
		//���ڵ�һ��״̬�ĳ�ʼ������̬����Ϊ0����һ��״̬Ϊ-1;
		status[0] = new Status(0, 0, -1, 0);
		//�ӵ�һ��״̬��ʼ������ֱ�����һ��״̬����Ϊ״̬Ϊ11111111 ������ҵ��д���״̬Ϊֹ
		for (int i = 1; i < maxStatus; i++) {
			if (status[i] == null) {
				status[i] = new Status(0, 0, -1, 0);
			}
			//����ʼʱ����Ϊ���ֵ
			status[i].reduceTime = 0x7fffffff;
			//ʹ��ջ�ṹ���ǴӺ���ǰ��������״̬��ͬʱ�����ǻ�ȡ�����ǰ�����ȷ�ֵ����״̬����
			for (int j = n - 1; j >= 0; j--) {
				// ��������ҵ��һ��״̬���
				int temp = 1 << j;
				if ((i & temp) != 0) {
					// ���״̬i��11110 �� 10���� ��д���˵ڶ�����ҵ
					// ��ô�ҵ�����ǰһ��״̬ ��11110 - 10 = 11100 д����3 4 5����ҵ��״̬����
					preStatus = i - temp;
					//��ȡ�����״̬�����д��ҵ���ŵ�ʱ�䲢��������ڶ�����ҵд��ʱ�� 
					reduce = status[preStatus].runTime + nodes[j].c
							- nodes[j].d;
					//�ټ�ȥdeadLine����ʱ��ʱ��
					if (reduce < 0) {
						//�������ʱ,�Ϸ�����
						reduce = 0;
					}
					/*
					 * ���״̬11110 ��д���˵ڶ�����ҵ������ʱ��������ڸոռ������ʱ��
					 * ���������Ĳ���� ��ô��˼����
					 * ����״̬11110:
					 * 11100 + 10 3��4��5 д�� д�ڶ���
					 * 10110 + 1000 2��3��5 д�� д���ĸ�
					 * 01110 + 10000 2��3��4д�� д�����
					 * �⼸��������֣�ÿһ�ֵ����������ʱ�䶼��ͬ�����Դ洢����ʱ�����ٵ���һ��
					 * ����Ϊ������״̬����ı�׼��
					 * �������ǲ��ܵõ����Ž�
					 */
					//����ȡ���˸��ŵĽⷨ����ô���Ǿ͸���·��
					if (status[i].reduceTime > status[preStatus].reduceTime
							+ reduce) {
						//��ֵ
						status[i].reduceTime = status[preStatus].reduceTime
								+ reduce;
						//��ǰ����Ϊj ���Եڶ�����ҵΪ��
						status[i].lastIndex = j;
						status[i].preStatus = preStatus;
						status[i].runTime = status[preStatus].runTime
								+ nodes[j].c;
					}
					//DP���
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
				// ���ڰ����ֵ������� �������
				Dp(n);
				// Ȼ��ʼ���
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
