package org.hope6537.thinking_in_java.eighteen;

import java.io.IOException;
import java.io.StringReader;

/**
 * @describe ���ڴ�����
 * @author Hope6537(����)
 * @signdate 2014��7��23������6:00:23
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class MemoryInput {

	public static void main(String[] args) throws IOException {
		String path = "E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\thinking_in_java\\eighteen\\MemoryInput.java";
		StringReader in = new StringReader(
				BufferedInputFile.read(path));
		int c;
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
	}

}
