package org.hope6537.thinking_in_java.fifteen;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Apply {
	public static void main(String[] args) {
		try {
			ApplyTest.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Descirbe ���ø����������ж���ķ���
	 * @Author Hope6537(����)
	 * @Params @param <T>
	 * @Params @param <S>
	 * @Params @param seq ����
	 * @Params @param f ������
	 * @Params @param args ���󼯺�
	 * @SignDate 2014-7-20����03:03:57
	 * @Version 0.9
	 */
	public static <T, S extends Iterable<? extends T>> void apply(S seq,
			Method f, Object... args) {
		try {
			//ʵ�ֵ�������֤�����еĵ����ʹ��롣
			for (T t : seq) {
				f.invoke(t, args);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Shape {
	public void rotate() {
		System.out.println(this + " rotate");
	}

	public void resize(int newSize) {
		System.out.println(this + " resize " + newSize);
	}
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {
	/**
	 * @Describe
	 */
	private static final long serialVersionUID = 4545427235343725630L;

	public FilledList(Class<? extends T> type, int size) {
		try {
			for (int i = 0; i < size; i++) {
				add(type.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SimpleQueue<T> implements Iterable<T> {
	private LinkedList<T> storage = new LinkedList<T>();

	public void add(T t) {
		storage.offer(t);
	}

	public T get() {
		return storage.poll();
	}

	public Iterator<T> iterator() {
		return storage.iterator();
	}

}

class ApplyTest {
	public static void main(String[] args) throws Exception {
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < 10; i++) {
			shapes.add(new Shape());
		}
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		System.out.println("---------------------------------------------");
		Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
		System.out.println("---------------------------------------------");
		Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class
				.getMethod("rotate"));
	}
}
