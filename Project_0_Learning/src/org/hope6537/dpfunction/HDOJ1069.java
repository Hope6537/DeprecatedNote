package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1069 {

	static Scanner s;

	static {
		s = new Scanner(System.in);
	}

	private static class square {
		int x;
		int y;
		int z;
		int s;

		public square() {
			// TODO Auto-generated constructor stub
		}

		public square(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.s = x * y;
		}

		@Override
		public String toString() {
			return "square [s=" + s + ", x=" + x + ", y=" + y + ", z=" + z
					+ "]";
		}

	}

	public static int max(int a, int b) {
		return a - b >= 0 ? a : b;
	}

	public static int min(int a, int b) {
		return a - b >= 0 ? b : a;
	}

	static square[] squares;
	static int[] maxs;

	public static int f(int index) {
		square benti = squares[index];
		int max = benti.z;
		int maxH = 0;
		for (int i = index + 1; i < squares.length; i++) {
			square temp = squares[i];
			boolean isOk = temp.x > benti.x && temp.y > benti.y;
			if (isOk) {
				int tempH = 0;
				if (maxs[i] != -1) {
					tempH = maxs[i];
				} else {
					tempH = f(i);
				}
				if (tempH > maxH) {
					maxH = tempH;
					maxs[i] = tempH;
				}
			}
		}
		return maxH + max;
	}

	public static void main(String[] args) {
		int time = 1;
		while (s.hasNext()) {
			int type = s.nextInt();
			if (type == 0) {
				break;
			}
			int indexs = 3 * type;
			squares = new square[indexs];
			maxs = new int[indexs];
			for (int i = 0; i < maxs.length; i++) {
				maxs[i] = -1;
			}
			for (int i = 0; i < 3 * type; i += 3) {
				int x = s.nextInt();
				int y = s.nextInt();
				int z = s.nextInt();
				squares[i] = new square(max(x, y), min(x, y), z);
				squares[i + 1] = new square(max(y, z), min(y, z), x);
				squares[i + 2] = new square(max(x, z), min(x, z), y);
			}
			// input done
			for (int i = 0; i < indexs; i++) {
				for (int j = 0; j < indexs; j++) {
					if (squares[i].s < squares[j].s) {
						square temp = squares[i];
						squares[i] = squares[j];
						squares[j] = temp;
						if (squares[i].x < squares[j].x) {
							square temp1 = squares[i];
							squares[i] = squares[j];
							squares[j] = temp1;
						}
						if (squares[i].x == squares[j].x) {
							if (squares[i].y < squares[j].y) {
								square temp1 = squares[i];
								squares[i] = squares[j];
								squares[j] = temp1;
							}
						}
					}
				}
			}
			int maxHeight = 0;
			for (int i = 0; i < squares.length; i++) {
				int res = f(i);
				if (res > maxHeight) {
					maxHeight = res;
				}
			}
			// sort done
			System.out.println("Case " + time + ": maximum height = "
					+ maxHeight);
			time++;
		}
	}

}
