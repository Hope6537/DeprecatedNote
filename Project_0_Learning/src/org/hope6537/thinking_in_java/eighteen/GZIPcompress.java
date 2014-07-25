package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @describe 使用GZIP模式进行压缩
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月25日下午12:48:24
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class GZIPcompress {

	public static void main(String[] args) throws IOException {

		Pcompress(new String[] { "G:\\Article.txt" });
	}

	public static void Pcompress(String[] args) throws IOException {

		File file = new File("G:\\Test.gz");
		if (args.length == 0) {
			System.out.println("No Args");
			System.exit(1);
		}
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream(file)));
		System.out.println("Writing File");
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
		System.out.println("Reading File");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream(file))));
		String s;
		while ((s = in2.readLine()) != null) {
			System.out.println(s);
		}

	}
}
