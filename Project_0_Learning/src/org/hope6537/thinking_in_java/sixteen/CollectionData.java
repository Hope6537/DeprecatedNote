package org.hope6537.thinking_in_java.sixteen;

import java.util.*;

import org.hope6537.thinking_in_java.fifteen.Generator;

/**
 * @describe ����һ��ͨ�������������������õ�Collection���� �^����ArrayList
 * @author Hope6537(����)
 * @signdate 2014-7-22����03:03:43
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {
	/**
	 * @describe
	 */
	private static final long serialVersionUID = 7831981403355543936L;

	public CollectionData(Generator<T> gen, int quantity) {
		for (int i = 0; i < quantity; i++)
			add(gen.next());
	}

	/**
	 * @descirbe ����һ��CollectionData���� �����˵�
	 * @author Hope6537(����)
	 * @param <T>
	 * @param gen
	 * @param quantity
	 * @return
	 * @signDate 2014-7-22����03:04:16
	 * @version 0.9
	 */
	public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
		return new CollectionData<T>(gen, quantity);
	}
} 
