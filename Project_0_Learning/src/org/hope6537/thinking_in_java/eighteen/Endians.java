package org.hope6537.thinking_in_java.eighteen;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @describe ͨ�����ģʽ�ı��ַ��е��ֽڴ���
 * @author Hope6537(����)
 * @signdate 2014��7��24������7:39:17
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Endians {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
		bb.asCharBuffer().put("abcdef");
		display(bb);
		bb.rewind();
		bb.order(ByteOrder.BIG_ENDIAN);// Ĭ��Ϊ��λ����
		bb.asCharBuffer().put("abcdef");
		display(bb);
		bb.rewind();
		bb.order(ByteOrder.LITTLE_ENDIAN); //��λ���ȴ洢
		bb.asCharBuffer().put("abcdef");
		display(bb);
	}

	static void display(ByteBuffer bb) {
		System.out.println(Arrays.toString(bb.array()));
	}
}
