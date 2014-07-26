package org.hope6537.hdoj_water;

import java.util.*;
import java.io.*;

public class HDOJ1001 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int i, n;
		while (sc.hasNext()) {

			int sum = 0;
			n = sc.nextInt();
			for (i = 1; i <= n; i++) {
				sum += i;
			}
			System.out.println(sum);
			System.out.println();
		}

	}

}
