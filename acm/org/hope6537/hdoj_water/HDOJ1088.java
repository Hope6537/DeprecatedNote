package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1088 {

	static Scanner s = new Scanner(System.in);
	static String line = "--------------------------------------------------------------------------------";
	static String br = "\r\n";

	public static void main(String[] args) {
		String res = "";
		int linecount = 0;
		int hrflag = 0;
		int wordflag = 0;
		while (s.hasNext()) {
			String str = s.next();

			if (str.compareTo("") == 0) {
				continue;
			}
			if (str.equals("<br>")) {
				res += br;
				linecount = 0;
				wordflag = 0;
				System.out.print(res);
				res = "";
			} else if (str.equals("<hr>")) {
				wordflag = 0;
				if (hrflag == 0) {
					res += br + line + br;
					hrflag = 1;
				} else {
					res += br + line;
					hrflag = 0;
				}
				linecount = 0;

				System.out.print(res);
				res = "";
			} else {
				if (!str.isEmpty()) {
					linecount += str.length();
					if (linecount < 80) {
						if (linecount == 79) {
							res += str;
						} else {
							if (wordflag == 1) {
								res += " ";
							}
							res += str;
							wordflag = 1;
							linecount++;
						}
					} else {
						System.out.print(res);
						res = "";
						res += str;
						linecount = str.length() + 1;
					}
				}
			}
		}
		if (res.compareTo("") != 0) {
			System.out.print(res);
		}
		System.out.println();

	}

}
