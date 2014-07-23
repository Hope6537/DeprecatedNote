package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
	static String file = "C:\\Users\\Zhaopeng-Rabook\\Desktop\\Google Download\\��������\\FileOutputShortcut.out";
	static String path = "E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\thinking_in_java\\eighteen\\FileOutputShortcut.java";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read(path)));
		PrintWriter out = new PrintWriter(file);
		int linecount = 1;
		String s;
		while ((s = in.readLine()) != null) {
			out.println(linecount++ + ": " + s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
