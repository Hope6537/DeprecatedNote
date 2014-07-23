package org.hope6537.thinking_in_java.seventeen;

import java.util.AbstractList;

/**
 * @describe ����List
 * @author Hope6537(����)
 * @signdate 2014-7-22����05:04:32
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class CountingIntegerList extends AbstractList<Integer> {

	private int size;

	public CountingIntegerList(int size) {
		this.size = size;
	}

	public static <T> T value(T obj) {
		System.out.println(obj.getClass().getSimpleName());
		return obj;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Integer get(int index) {
		return Integer.valueOf(index);
	}
	
	public static void main(String[] args) {
		//������Ѱ��ֵʱ get���������������Ԫģʽ����Ʒ���
		System.out.println(new CountingIntegerList(30));
	}
}
