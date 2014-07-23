package org.hope6537.hdoj_water;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


public class HDOJ1555 {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int M = (int) in.nval;
			in.nextToken();
			int k = (int) in.nval;
			if (M == 0 && k == 0) {
				break;
			}
			int days = 0;
			while (M-- != 0) {
				days++;
				if (days % k == 0) {
					M++;
				}
			}
			out.println(days);
			out.flush();
		}
	}

}
