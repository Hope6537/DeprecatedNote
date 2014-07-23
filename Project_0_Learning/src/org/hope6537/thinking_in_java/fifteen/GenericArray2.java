package org.hope6537.thinking_in_java.fifteen;

/**
 * @Describe ��������ʵ��2
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����03:41:46
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class GenericArray2<T> {

	private Object[] array;

	public GenericArray2(int size) {
		this.array = new Object[size];
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return (T) array[index];
	}

	public T[] rep() {
		return (T[]) array;
	}

	public static void main(String[] args) {
		GenericArray2<Integer> gai = new GenericArray2<Integer>(10);
		for (int i = 0; i < 10; i++) {
			gai.put(i, i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(gai.get(i) + " ");
		}
		System.out.println();
		try{
			//���ǻ��ǻ���Ԥ�ڲ����쳣
			Integer [] ia = gai.rep();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
