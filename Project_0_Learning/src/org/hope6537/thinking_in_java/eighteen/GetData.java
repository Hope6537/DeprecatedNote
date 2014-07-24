package org.hope6537.thinking_in_java.eighteen;

import java.nio.ByteBuffer;

public class GetData {

	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while (i++ < buffer.limit()) {
			if (buffer.get() != 0) {
				System.out.println("nonZero");
			}
		}
		System.out.println("i= " + i);
		buffer.rewind();
		buffer.asCharBuffer().put("Howdy?!");
		char c;
		while ((c = buffer.getChar()) != 0) {
			System.out.print(c + " ");
		}
		System.out.println();
		// ÿһ�ε�rewind���Ƿ��ص����ݿ�ʼ����
		buffer.rewind();
		buffer.asShortBuffer().put((short) 1234);
		System.out.println(buffer.getShort());
		buffer.rewind();
		// ����ľͲ������� asClassBuffer().put(Class value);
		// Ȼ����� .getClass() ���rewind
		
	}
}
