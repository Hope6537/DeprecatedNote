package org.hope6537.thinking_in_java.sixteen;

import org.hope6537.thinking_in_java.fifteen.Generator;

/**
 * @describe ���ɻ�����������
 * @author Hope6537(����)
 * @signdate 2014-7-22����02:57:03
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Generated {

	/**
	 * @descirbe ͨ����������Ȼ������������������䣬Ȼ�󷵻�
	 * @author Hope6537(����)
	 * @param <T>
	 * @param a
	 * @param gen
	 * @return
	 * @signDate 2014-7-22����02:59:52
	 * @version 0.9
	 */
	public static <T> T[] array(T[] a, Generator<T> gen) {
		return (new CollectionData<T>(gen, a.length)).toArray(a);
	}

	/**
	 * @descirbe �������ͺʹ�С������������Ȼ�����
	 * @author Hope6537(����)
	 * @param <T>
	 * @param type
	 * @param gen
	 * @param size
	 * @return
	 * @signDate 2014-7-22����03:03:19
	 * @version 0.9
	 */
	public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
		T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
		return (new CollectionData<T>(gen, size)).toArray(a);
	}

}
