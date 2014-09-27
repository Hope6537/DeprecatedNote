package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @describe 璇诲彇浜岃繘鍒舵枃浠�
 * @author Hope6537(璧甸箯)
 * @signdate 2014骞�鏈�4鏃ヤ笂鍗�0:28:32
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
