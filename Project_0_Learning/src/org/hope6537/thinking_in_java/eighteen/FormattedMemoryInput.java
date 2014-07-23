package org.hope6537.thinking_in_java.eighteen;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @describe ��ʽ�����ڴ�����
 * @author Hope6537(����)
 * @signdate 2014��7��23������6:01:11
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class FormattedMemoryInput {

	public static void main(String[] args) throws IOException {
		try {
			String path = "E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\thinking_in_java\\eighteen\\FormattedMemoryInput.java";
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(
					BufferedInputFile.read(path).getBytes()));
			while (in.available() != 0/* true */) {//���ַ����ж��Ƿ������һ��ֱ�ӵ��ã���һ�ֿ��쳣����
				System.out.print((char) in.readByte());
			}
		} catch (Exception e) {
			System.out.println("===============End Of File===============");
		}
	}
}
