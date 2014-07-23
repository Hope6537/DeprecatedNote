package org.hope6537.thinking_in_java.seventeen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @describe ʲô��������δ��֧�ֲ�����
 * @author Hope6537(����)
 * @signdate 2014��7��23������10:54:05
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Unsupported {
	static void test(String msg, List<String> list) {
		System.out.println("=====" + msg + "=====");
		Collection<String> c = list;
		Collection<String> subList = list.subList(1, 8);
		Collection<String> c2 = new ArrayList<String>();
		try {
			c.retainAll(c2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A B C D E F G H J K L M N O P Q"
				.split(" "));
		test("Copy", new ArrayList<String>(list));
		test("Arrays.asList()",list);//��ΪArrays.asList����֧�ֲ���Ӱ�������С�Ĳ���
		test("unmodififableList()",Collections.unmodifiableList(new ArrayList<String>(list)));//����һ�������޸ĵ��б�
	}
}
