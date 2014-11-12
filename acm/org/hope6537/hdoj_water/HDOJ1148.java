package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1148 {

	final static String ROCK = "rock";
	final static String SCISSORS = "scissors";
	final static String PAPER = "paper";

	private static class User {
		int id;
		int matchs;
		int wins;
		int loses;
		String what;
		double avg;

		public User(int id, int matchs) {
			this.matchs = matchs;
			this.wins = 0;
			this.loses = 0;
			this.avg = 0.000;
			this.what = "";
		}
	}

	public static char compare(String a, String b) {
		if (a.equals(ROCK) && b.equals(SCISSORS)) {
			return 'w';
		} else if (a.equals(ROCK) && b.equals(PAPER)) {
			return 'l';
		} else if (a.equals(SCISSORS) && b.equals(PAPER)) {
			return 'w';
		} else if (a.equals(SCISSORS) && b.equals(ROCK)) {
			return 'l';
		} else if (a.equals(PAPER) && b.equals(ROCK)) {
			return 'w';
		} else if (a.equals(PAPER) && b.equals(SCISSORS)) {
			return 'l';
		} else {
			return 'p';
		}
	}

	static int flag = 0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {

			if (flag == 1) {
				System.out.println();
			}
			flag = 1;
			int n = s.nextInt(); // n位选手参加k场
			if (n == 0) {
				flag = 0;
				break;

			}
			int k = s.nextInt(); // k场比赛
			int matchs = (k * n * (n - 1)) / 2;
			User user[] = new User[n + 1];
			for (int i = 1; i <= n; i++) {
				user[i] = new User(i, matchs);
			}
			for (int i = 0; i < matchs; i++) {
				// 每场比赛
				int[] no = new int[2];
				// 两个选手的编号
				for (int k1 = 0; k1 < 2; k1++) {
					// 数据的输入
					int number = s.nextInt();
					String what = s.next();
					no[k1] = number;
					user[number].what = what;
				}
				// 开始比较
				String a = user[no[0]].what;
				String b = user[no[1]].what;
				char res = compare(a, b);
				if (res == 'w') {
					user[no[0]].wins++;
					user[no[1]].loses++;
				} else if (res == 'l') {
					user[no[1]].wins++;
					user[no[0]].loses++;
				} else {
					;
				}
			}
			// 比赛结束 开始统计胜率
			for (int i = 1; i <= n; i++) {
				User u = user[i];
				if (u.wins + u.loses == 0) {
					u.avg = -1;
				} else {
					u.avg = (u.wins) / ((u.wins) * 1.0 + u.loses);
				}
			}
			// 胜率统计完毕
			for (int i = 1; i <= n; i++) {
				User u = user[i];
				if (u.avg == -1) {
					System.out.println("-");
				} else {
					System.out.printf("%1.3f\r\n", u.avg);
				}
			}

		}

	}

}
