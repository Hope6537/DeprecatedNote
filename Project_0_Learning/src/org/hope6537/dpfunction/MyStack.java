package org.hope6537.dpfunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @Describe ����������ʹ��˳��洢�ṹ�����Ա�ı���ɵ�ջ
 * @Author Hope6537(����)
 * @Signdate 2014��5��9��10:15:22
 * @version 0.9
 * @company Changchun University&SHXT
 */
// �����ﶨ�巺�� �Ӷ������������� <AnyType>
public class MyStack<AnyType> implements Iterable<AnyType> {

	// Ĭ������Ϊ10
	private static final int DEFAULT_CAPACITY = 10;
	// ���ڵ����ݵĸ���
	private int theSize;
	// ���ݵĴ洢��������
	private AnyType[] theItems;

	// Ĭ�Ϲ��췽��
	/**
	 * @Describe Ĭ�Ϲ��췽��
	 * @Author Hope6537(����)
	 * @param
	 */
	public MyStack() {
		// ���췽��ֱ����յ�ǰ�����ö���,���س�����ʱ����ʹ�õ���Ԫ����
		clear();
	}

	/**
	 * @Descirbe �����������ջ
	 * @Author Hope6537(����)
	 * @Params
	 * @SignDate 2014-5-8����10:17:11
	 * @Version 0.9
	 */
	public void clear() {
		// ���ڵĴ�С��ֵ����
		theSize = 0;
		// ��Ϊѭ���Ǵ�0ѭ����0 ���Բ�����������
		ensureCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * @Descirbe ���ص�ǰ�����ݸ���
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-5-8����10:17:27
	 * @Version 0.9
	 */
	public int size() {
		return theSize; // �������ڵĴ�С����ֵ
	}

	/**
	 * @Descirbe �ж��Ƿ�Ϊ��(����NULL)
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-5-8����10:17:36
	 * @Version 0.9
	 */
	public boolean isEmpty() {
		return size() == 0;// ���ڵĴ�С����ֵ�Ƿ�Ϊ��
	}

	/**
	 * @Descirbe �����û��Ĺ�����չ�ռ�ķ���
	 * @Author Hope6537(����)
	 * @Params
	 * @SignDate 2014-5-8����10:17:49
	 * @Version 0.9
	 */
	public void trimToSize() {
		// �����ݽṹ��ʽ����������С
		ensureCapacity(size());
	}

	/**
	 * @Descirbe ��ջ
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-5-9����10:42:55
	 * @Version 0.9
	 */
	public AnyType pop() {
		int index = size()-1;
		if (index < 0 || index >= size()) {
			// �������ֵ���Ϸ� �׳�����Խ���쳣
			throw new ArrayIndexOutOfBoundsException();
		}
		theSize = index;
		return theItems[index];

	}

	/**
	 * @Descirbe ������������ݲ����������Ա����ӳ���
	 * @Author Hope6537(����)
	 * @Params @param newCapacity �µĳ���
	 * @SignDate 2014-5-8����10:19:49
	 * @Version 0.9
	 */
	public void ensureCapacity(int newCapacity) {
		// ���ǵ�����С������MyArrayList������
		if (newCapacity < theSize) {
			return; // ������ڵ����ݴ�С���ڲ�������Ԥ����ֵ ��ô���ǾͲ�����
		}
		AnyType[] old = theItems; // ��ԭ�������ݱ���
		theItems = (AnyType[]) new Object[newCapacity]; // ����������
		for (int i = 0; i < size(); i++) {
			// Ȼ��ѭ�����������������data
			theItems[i] = old[i];
		}
	}

	/**
	 * @Descirbe ��index������һ���µ�Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param index ����λ��
	 * @Params @param x ��Ԫ�ض���
	 * @SignDate 2014-5-8����10:20:30
	 * @Version 0.9
	 */
	private void add(int index, AnyType x) {// �������±�����һ��Ԫ��x
		if (theItems.length == size()) {
			// �������ĳ����Ѿ�����size��С �Ǿ���˵��������
			ensureCapacity(size() * 2 + 1);
			// ��������Ҫ��������ķ���������
			// ע�� ��������Ĵ�С������Ĵ�С���������ݽṹ�ġ�
		}

		for (int i = theSize; i > index; i--) {
			// ���������ǽ���������������Ԫ�����κ�һλ������װ������
			theItems[i] = theItems[i - 1];
		}
		// ������װ��
		theItems[index] = x;
		// ͬʱsize�ĳ���+1
		theSize++;
	}

	/**
	 * @Descirbe ѹ���ݽ�ջ
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-5-8����10:21:14
	 * @Version 0.9
	 */
	public boolean push(AnyType x) {// ֱ���ڶ�β���롣
		add(size(), x);
		return true;
	}

	public Iterator<AnyType> iterator() {// ��ȡ�Լ��ĵ�����
		return new ArrayListIterator(this);
	}

	@Override
	public String toString() {
		return "MyArrayList [theItems=" + Arrays.toString(theItems) + "]";
	}

	/**
	 * @Describe ������Ƕ���� ��static �����޸İ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-5-8����11:14:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private static class ArrayListIterator<AnyType> implements
			Iterator<AnyType> {
		// �Ա�������ڲ���

		private int current = 0;// ��������ǰ����

		private MyStack<AnyType> theList;

		public ArrayListIterator(MyStack<AnyType> list) {
			theList = list;
		}

		public boolean hasNext() {// �Ƿ�����һ�� ͨ����ǰ������size�Ĵ�С���бȽ��ж�
			return current < theList.size();
		}

		@Override
		public AnyType next() {
			// �����һ��
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (AnyType) theList.theItems[current++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		// ���ԣ���ջ����ջ
		MyStack<String> stack = new MyStack<String>();
		stack.push("abc");
		stack.push("bcd");
		stack.push("def");
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		MyStack<Integer> stack2 = new MyStack<Integer>();
		while(num != 0){
			int in = num % 8;
			stack2.push(in);
			num = num/8;
		}
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop());
		}
		System.out.println();
		
	}

}
