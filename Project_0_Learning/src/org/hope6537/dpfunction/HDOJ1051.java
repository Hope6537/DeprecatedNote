package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1051 {
	static Scanner s = new Scanner(System.in);

	private static class Node {
		int w;
		int l;
		boolean visit;

		@Override
		public String toString() {
			return "Node [l=" + l + ", w=" + w + "]";
		}

		public Node(int w, int l) {
			super();
			this.w = w;
			this.l = l;
			visit = false;
		}

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int T = s.nextInt();
			if (T == 0) {
				break;
			}
			while (T-- != 0) {
				int n = s.nextInt();
				if (n == 0) {
					System.out.println(0);
				} else {
					Node[] nodes = new Node[n];
					for (int i = 0; i < n; i++) {
						int w = s.nextInt();
						int l = s.nextInt();
						nodes[i] = new Node(w, l);
					}
					// input done
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							boolean isOk = (nodes[i].w < nodes[j].w || nodes[i].w == nodes[j].w)
									&& (nodes[i].l < nodes[j].l || nodes[i].l == nodes[j].l);
							if (isOk) {
								Node temp = nodes[i];
								nodes[i] = nodes[j];
								nodes[j] = temp;
							}
						}
					}
					int i = 0;
					int minutes = 0;
					int counts = 0;

					while (counts < n) {
						Node node = nodes[i];
						if (!node.visit) {
							counts += 1;
							minutes += 1;
							i += 1;
							node.visit = true;
							for (int i1 = i; i1 < n; i1++) {
								Node temp = nodes[i1];

								// 注意这个表达式
								boolean isOk = (temp.l > node.l || temp.l == node.l)
										&& (temp.w > node.w || temp.w == node.w);
								if (isOk && temp.visit == false) {
									// 如果符合条件
									counts++;
									temp.visit = true;
									node = temp;
								} else {
									continue;
								}

							}

						} else {
							i++;
						}
					}
					System.out.print(minutes + "\r\n");
				}
			}
		}
	}
}
