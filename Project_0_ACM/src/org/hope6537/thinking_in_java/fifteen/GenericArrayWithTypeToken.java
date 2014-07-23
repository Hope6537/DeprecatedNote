package org.hope6537.thinking_in_java.fifteen;

import java.lang.reflect.Array;

/**
 * @Describe ���鷺��ʵ��3 ���ڳɹ�������
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����03:49:41
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class GenericArrayWithTypeToken<T> {

	private T[] array;

	/**
	 * @Describe ���ǽ�������Ϣ��������У��Ա����鱻������ָ�����
	 * @Author Hope6537(����)
	 * @param @param type
	 * @param @param sz
	 */
	public GenericArrayWithTypeToken(Class<T> type, int sz) {
		array = (T[]) Array.newInstance(type, sz);
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return array[index];
	}

	public T[] rep() {
		return array;
	}

	public static void main(String[] args) {
		GenericArrayWithTypeToken<Integer> arrayWithTypeToken = new GenericArrayWithTypeToken<Integer>(
				Integer.class, 10);
		Integer[] ia = arrayWithTypeToken.rep();
	}

}
