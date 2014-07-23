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
				 * �Ȱ����۷����ĸߵͽ������򣬷���һ����ʱ��Ͱ������������� Ȼ��ʹ�ͷ��ʼ����
				 * �������deadline��һ��û�б�������ҵռ�ã���ô��ֱ������һ�����Ϳ���
				 * ���򣬾���ǰ�ң��ҵ���һ����û�б�ռ�õģ�������һ������ �Ҳ����Ļ�����ֻ�ܱ��۷֡�
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
