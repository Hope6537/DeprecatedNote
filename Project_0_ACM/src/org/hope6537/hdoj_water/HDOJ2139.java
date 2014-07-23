package org.hope6537.hdoj_water;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class HDOJ2139 {

	public static void main(String[] args) throws IOException {

		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			long n = (long) in.nval;

			// (1/3)*(4n^3-n)
			out.println((n * (n + 1) * (n + 2)) / 6);
			out.flush();
		}

	}
}
