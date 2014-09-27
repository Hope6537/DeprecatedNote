package org.hope6537.hdoj_water;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class HDOJ2101 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int a = (int) in.nval;
			in.nextToken();
			int b = (int) in.nval;
			out.println((a + b) % 86 == 0 ? "yes" : "no");
			out.flush();
		}
	}

}
