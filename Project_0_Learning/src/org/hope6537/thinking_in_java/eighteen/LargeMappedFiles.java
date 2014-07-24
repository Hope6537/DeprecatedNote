package org.hope6537.thinking_in_java.eighteen;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @describe ģ����ļ���д
 * @author Hope6537(����)
 * @signdate 2014��7��24������8:15:42
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class LargeMappedFiles {

	static int length = 0x8FFFFFF;

	public static void main(String[] args) throws Exception {
		String filename = "G:\\Data.dat";
		// ������RandomAccessFile����ļ��ϵ�ͨ����Ȼ�����map��MappedByteBuffer,����һ���������͵�ֱ�ӻ�����
		// ָ��ӳ���ļ��ĳ�ʼλ�úͳ��ȣ������ǿ��Ի�ø��ļ���������Ҫ�Ľ�С��һ����
		MappedByteBuffer out = new RandomAccessFile(filename, "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			out.put((byte) 'x');
		}
		System.out.println("finish writing");
		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.println((char) (out.get(i)));
		}

	}

}
