package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @describe ����ͨ�Ķ����ļ�
 * @author Hope6537(����)
 * @signdate 2014��7��23������5:52:59
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class BufferedInputFile {

	/**
	 * @descirbe �����ļ� �����ַ���
	 * @author Hope6537(����)
	 * @param filename
	 * @return
	 * @throws IOException
	 * @signDate 2014��7��23������5:53:09
	 * @version 0.9
	 */
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder builder = new StringBuilder();
		while ((s = in.readLine()) != null) {
			builder.append(s + "\n");
		}
		in.close();
		return builder.toString();
	}

	public static void main(String[] args) {
		try {
			String path2 = "C:\\Users\\Zhaopeng-Rabook\\Desktop\\Google Download\\��������\\mul.vhd";
			System.out.println(read(path2));
					//.println(read("E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\thinking_in_java\\eighteen\\BufferedInputFile.java"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
