package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @describe 读取二进制文件
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月24日上午10:28:32
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class BinaryFile {

	public static byte[] read(File file) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				file));
		try {
			byte[] data = new byte[in.available()];
			in.read(data);
			return data;
		} finally {
			in.close();
		}
	}

	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile).getAbsoluteFile());
	}
}
