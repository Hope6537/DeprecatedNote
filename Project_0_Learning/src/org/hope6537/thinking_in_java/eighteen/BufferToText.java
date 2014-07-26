package org.hope6537.thinking_in_java.eighteen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		File file = new File("G:\\Data.txt").getAbsoluteFile();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		FileChannel fc = new FileOutputStream(file).getChannel();

		fc.write(ByteBuffer.wrap("Some Text".getBytes("UTF-8")));
		fc.close();
		fc = new FileInputStream(file).getChannel();

		fc.read(buffer);
		buffer.flip(); // 涓嶅ソ浣�
		System.out.println(buffer.asCharBuffer());

		buffer.rewind();

		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoding using " + encoding + " : "
				+ Charset.forName(encoding).decode(buffer));
		// 鎵�互闇�瑙ｇ爜
		fc = new FileOutputStream(file).getChannel();
		// 鍙湁UTF-16BE濂戒娇
		fc.write(ByteBuffer.wrap("Some Text".getBytes("UTF-16BE")));
		fc.close();
		// 鎺ヤ笅鏉ュ啀璇讳竴娆�
		fc = new FileInputStream(file).getChannel();
		// clear鐐簉ead鍋氭簴鍌�
		buffer.clear();
		fc.read(buffer); // flip涓簑rite鍋氬噯澶�
		buffer.flip();
		System.out.println(buffer.asCharBuffer()); // 浣嗚繕鏄笉濂戒娇

		fc = new FileOutputStream(file).getChannel();
		buffer = ByteBuffer.allocate(24);
		buffer.asCharBuffer().put("Some Text");
		fc.write(buffer);
		fc.close();
		fc = new FileInputStream(file).getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());

	}

}
