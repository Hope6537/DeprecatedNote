package org.hope6537.thinking_in_java.fifteen;

/**
 * @Describe ���鷺��ʵ��
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����03:46:00
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class GenericArray<T> {

	private T[] array;

	public GenericArray(int sz) {
		// ���ȶ���һ�������������飬Ȼ���Լ�����ǿ������ת��
		// ������Ч�����ǻ��ڱ����ڼ����
		array = (T[]) new Object[sz];
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
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		//����ֱ����쳣 ClassCastException:
		Integer [] ia = gai.rep();
		//������ֱ����쳣
		Object [] oa = gai.rep();
	}
}
