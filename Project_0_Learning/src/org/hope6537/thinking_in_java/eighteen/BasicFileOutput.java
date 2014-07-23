package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	static String file = "C:\\Users\\Zhaopeng-Rabook\\Desktop\\Google Download\\��������\\BasicFileOutput.out";
	static String path = "E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\thinking_in_java\\eighteen\\BasicFileOutput.java";

	/**
	 * @descirbe �������ļ����
	 * @author Hope6537(����)
	 * @param args
	 * @throws IOException
	 * @signDate 2014��7��23������6:12:52
	 * @version 0.9
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read(path)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				file)));
		int linecount = 1;
		String s;
		while ((s = in.readLine()) != null) {
			out.println(linecount++ + ": " + s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
