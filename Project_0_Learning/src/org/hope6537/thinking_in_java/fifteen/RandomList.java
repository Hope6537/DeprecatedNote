package org.hope6537.thinking_in_java.fifteen;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Describe �����ȡ˳���
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����01:17:31
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class RandomList<T> {
	private ArrayList<T> list = new ArrayList<T>();
	private Random rand = new Random(47);

	public void add(T item) {
		list.add(item);
	}

	public T select() {
		return list.get(rand.nextInt(list.size()));
	}

	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<String>();
		for (String s : "Can only iterate ove an array ro an instance of java lang Iterable"
				.split(" ")) {
			rs.add(s);
		}
		for (int i = 0; i < 11; i++) {
			System.out.print(rs.select() + " ");
		}
	}
}
