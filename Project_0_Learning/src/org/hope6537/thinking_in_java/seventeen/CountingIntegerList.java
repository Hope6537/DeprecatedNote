package org.hope6537.thinking_in_java.seventeen;

import java.util.AbstractList;

/**
 * @describe 计数List
 * @author Hope6537(赵鹏)
 * @signdate 2014-7-22下午05:04:32
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
		//当我们寻找值时 get会产生他，这是享元模式的设计方法
		System.out.println(new CountingIntegerList(30));
	}
}
