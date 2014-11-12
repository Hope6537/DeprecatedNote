package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1257 {

	static Scanner s = new Scanner(System.in);

	private static class Node {
		int height;
		boolean isDie;

		@Override
		public String toString() {
			return "Node [height=" + height + ", isDie=" + isDie + "]";
		}

		public Node(int height, boolean isDie) {
			super();
			this.height = height;
			this.isDie = isDie;
		}

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			Node[] height = new Node[n];
			for (int i = 0; i < n; i++) {
				height[i] = new Node(s.nextInt(), false);
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (!height[i].isDie) {
					count++;
					height[i].isDie = true;
					for (int j = 0; j < n; j++) {
						if (!height[j].isDie) {
							if (height[i].height >= height[j].height) {
								height[j].isDie = true;
								height[i].height = height[j].height;
							}
						}

					}
				}

			}
			System.out.println(count);
		}

	}
}
