package org.hope6537.thinking_in_java.fifteen;

class Generic<T> {
}

class ArrayOfGenericRefenerce {
	static Generic<Integer>[] gia;
}

/**
 * @Describe ���鷺�� ʹ�ó��ж���ķ�ʽ
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����03:31:19
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// �����ű�����Ч��
		gia = (Generic<Integer>[]) new Generic[SIZE];
		// ���������������
		gia[0] = new Generic<Integer>();
	}
}
