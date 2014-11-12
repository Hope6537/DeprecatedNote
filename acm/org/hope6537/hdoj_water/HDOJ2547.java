package org.hope6537.hdoj_water;

import java.io.*;

public class HDOJ2547 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) in.nval;
			while (n-- != 0) {
				in.nextToken();
				int a = (int) in.nval;
				in.nextToken();
				int b = (int) in.nval;
				in.nextToken();
				int c = (int) in.nval;
				in.nextToken();
				int d = (int) in.nval;
				out.printf("%.1f\r\n", Math.sqrt(((a - c) * (a - c))
						+ ((b - d) * (b - d))));
				out.flush();
			}

		}
	}

}
