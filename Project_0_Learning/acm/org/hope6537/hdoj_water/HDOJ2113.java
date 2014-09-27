package org.hope6537.hdoj_water;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class HDOJ2113 {

	public static void main(String[] args) throws IOException {

		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int flag = 0;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (flag == 1) {
				System.out.println();
			}
			flag = 1;
			long n = (long) in.nval;
			String str = n + "";
			int sum = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (((int) ch - 48) % 2 == 0) {
					sum += (int) ch - 48;
				}
			}
			System.out.println(sum);
		}

	}

}
