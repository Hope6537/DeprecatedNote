package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2539 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {

			int i = Integer.parseInt(s.nextLine());
			if (i == 0) {
				break;
			}
			int times = i % 2 == 0 ? i / 2 : i / 2 + 1;
			int aScore = 0;
			int bScore = 0;
			int[] Ateam = new int[times];
			int[] Bteam = new int[times];
			for (int j = 0; j < i; j++) {
				String str = s.nextLine();
				if (str.substring(str.length()-8).equals(" no good")) {
					if (j % 2 == 0) {
						Ateam[j / 2] = -1;
					} else {
						Bteam[j / 2] = -1;
					}
				} else {
					if (j % 2 == 0) {
						aScore++;
						Ateam[j / 2] = 1;
					} else {
						bScore++;
						Bteam[j / 2] = 1;
					}
				}
			}

			for (int j = 1; j <= times; j++) {
				System.out.print(j + " ");
			}
			System.out.print("Score");
			System.out.println();
			for (int j = 0; j < times; j++) {
				System.out.print(Ateam[j] != 0 ? (Ateam[j] > 0 ? "O " : "X ")
						: "- ");

			}
			System.out.print(aScore);
			System.out.println();
			for (int j = 0; j < times; j++) {
				System.out.print(Bteam[j] != 0 ? (Bteam[j] > 0 ? "O " : "X ")
						: "- ");

			}
			System.out.print(bScore);
			System.out.println();
		}
	}
}
