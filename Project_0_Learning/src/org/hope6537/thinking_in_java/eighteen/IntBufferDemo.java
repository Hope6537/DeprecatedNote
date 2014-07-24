package org.hope6537.thinking_in_java.eighteen;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @describe ��ͼ������
 * @author Hope6537(����)
 * @signdate 2014��7��24������7:33:01
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class IntBufferDemo {

	private static final int BSIZE = 1024;

	public static void main(String[] args) {

		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();//ʹ�û����Int��ͼ��ȷ��int����
		ib.put(new int[] { 11, 42, 33, 55, 77, 99, 97 });
		System.out.println(ib.get(3));
		ib.put(3, 1444);
		ib.flip();
		while (ib.hasRemaining()) {
			int i = ib.get();
			System.out.println(i);
		}

	}

}
