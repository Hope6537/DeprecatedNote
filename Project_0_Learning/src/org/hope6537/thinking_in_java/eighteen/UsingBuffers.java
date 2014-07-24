package org.hope6537.thinking_in_java.eighteen;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @describe ͨ��ByteBuffer�����������ַ�����
 * @author Hope6537(����)
 * @signdate 2014��7��24������8:05:05
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class UsingBuffers {

	private static void symmetricScramble(CharBuffer buffer) {

		while (buffer.hasRemaining()) {
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);

		}
	}

	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());

	}

}
