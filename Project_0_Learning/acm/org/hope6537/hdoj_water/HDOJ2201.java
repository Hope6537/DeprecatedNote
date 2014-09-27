package org.hope6537.hdoj_water;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class HDOJ2201 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) in.nval;
			in.nextToken();
			int m = (int) in.nval;
			System.out.printf("%.2f\r\n", 1.0 / n);
		}
	}

}
