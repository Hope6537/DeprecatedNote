package org.hope6537.datastructs.Hash;

/**
 * @Describe ƽ��̽��ɢ�б�
 * @Author Hope6537(����)
 * @Signdate 2014-4-5����12:07:37
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <AnyType>
 */
public class QuadraticProbingHashTable<AnyType> {

	/**
	 * @Describe ɢ�б�Ľڵ�Ԫ��
	 * @Author Hope6537(����)
	 * @Signdate 2014-4-5����12:44:09
	 * @version 0.9
	 * @company Changchun University&SHXT
	 * @param <AnyType>
	 */
	private static class HashEntry<AnyType> {
		// ����
		public AnyType element;
		// �Ƿ����
		public boolean isActive;

		// ���췽��
		public HashEntry(AnyType x) {
			this(x, true);
		}

		public HashEntry(AnyType x, boolean isActive) {
			this.element = x;
			this.isActive = isActive;
		}
	}

	/**
	 * @Describe Ĭ�ϳ���
	 */
	private static final int DEFAULT_TABLE_SIZE = 11;

	/**
	 * @Describe װ�ؽڵ����������
	 */
	private HashEntry<AnyType>[] array;

	/**
	 * @Describe ��ǰ�ڵ������
	 */
	private int currentSize;

	/**
	 * @Describe Ĭ�Ϲ��췽��
	 * @Author Hope6537(����)
	 * @param
	 */
	public QuadraticProbingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	/**
	 * @Describe �������С�����Ĺ��췽��
	 * @Author Hope6537(����)
	 * @param @param size
	 */
	public QuadraticProbingHashTable(int size) {
		// ����HashEntry�ڵ����鲢���γ�ʼ��
		alocateArray(size);
		// ͬʱ�������
		makeEmpty();
	}

	/**
	 * @Descirbe ���ɢ�б������
	 * @Author Hope6537(����)
	 * @Params
	 * @SignDate 2014-4-5����12:45:57
	 * @Version 0.9
	 */
	public void makeEmpty() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		currentSize = 0;
	}

	/**
	 * @Descirbe ��ʼ����������
	 * @Author Hope6537(����)
	 * @Params @param arraySize
	 * @SignDate 2014-4-5����12:46:09
	 * @Version 0.9
	 * @param arraySize
	 */
	@SuppressWarnings("unchecked")
	private void alocateArray(int arraySize) {
		array = new HashEntry[arraySize];
	}

	/**
	 * @Descirbe ���ص�ǰpos������Ԫ�صĿ�����
	 * @Author Hope6537(����)
	 * @Params @param pos
	 * @Params @return
	 * @SignDate 2014-4-5����12:46:19
	 * @Version 0.9
	 * @param pos
	 * @return
	 */
	private boolean isActive(int pos) {
		// ��Ϊ��ͬʱ����ֵΪtrue ˵������
		return array[pos] != null && array[pos].isActive;

	}

	/**
	 * @Descirbe �ҵ�xԪ����ƽ��̽�ⷨ�����λ��
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-4-5����12:46:49
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	private int findPos(AnyType x) {
		int offset = 1; // Ĭ�ϳ�ʼλ��
		int pos = myHash(x); // ���Ƚ���ɢ�л�
		while (array[pos] != null && !array[pos].element.equals(x)) {// �����ǰpos�������ڿ���Ԫ��
																		// ͬʱ��ֵ��x��ͬ
			pos = pos + offset; // ��ô���ν�pos����
			offset += 2; // ͬʱ��������+2 ����� ֱ��Ѱ�ҵ��յ�������ѭ��
			if (pos >= array.length) {// ���Խ�� ��ô��MOD����
				pos -= array.length;
			}
		}
		return pos;// ��������ɢ��λ��
	}

	/**
	 * @Descirbe Hash����
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-4-5����12:47:13
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	private int myHash(AnyType x) {
		int hashVal = x.hashCode();

		hashVal %= array.length;
		if (hashVal < 0) {
			hashVal += array.length;
		}
		return hashVal;
	}

	/**
	 * @Descirbe Ѱ��xԪ���Ƿ���ɢ�б��д���
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-4-5����12:47:22
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	public boolean contains(AnyType x) {
		int pos = findPos(x);
		return isActive(pos);
	}

	/**
	 * @Descirbe ����Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @SignDate 2014-4-5����12:54:13
	 * @Version 0.9
	 * @param x
	 */
	public void insert(AnyType x) {
		int pos = findPos(x); // �ҵ�����posλ��
		if (isActive(pos)) {// ���������ͬԪ�� ֱ����ת
			return;
		}
		array[pos] = new HashEntry<AnyType>(x); // ����
		if (++currentSize > array.length / 2) {// ��� ��>0.5 ������
			rehash();
		}
	}

	/**
	 * @Descirbe ���������ϵ������0.5ʱ ����
	 * @Author Hope6537(����)
	 * @Params
	 * @SignDate 2014-4-5����12:59:13
	 * @Version 0.9
	 */
	private void rehash() {
		HashEntry<AnyType>[] oldLists = array;
		alocateArray(nextPrime(2 * oldLists.length));
		currentSize = 0;
		for (int i = 0; i < oldLists.length; i++) {
			if (oldLists[i] != null && oldLists[i].isActive) {
				insert(oldLists[i].element);
			}
		}
	}

	/**
	 * @Descirbe �õ�n֮�����һ������
	 * @Author Hope6537(����)
	 * @Params @param n
	 * @Params @return
	 * @SignDate 2014-4-3����07:42:07
	 * @Version 0.9
	 * @param n
	 * @return
	 */
	private static int nextPrime(int n) {
		if (n % 2 == 0) {// ���ȼ���Ƿ��ܱ�2����������ǵĻ���ֱ�Ӹ�+1
			n++;
		}

		for (; !isPrime(n); n += 2)
			// Ȼ������ѭ���� �������� ����Ļ���n+2����
			;

		return n;
	}

	/**
	 * @Descirbe ����Ƿ�������
	 * @Author Hope6537(����)
	 * @Params @param n
	 * @Params @return
	 * @SignDate 2014-4-3����07:42:18
	 * @Version 0.9
	 * @param n
	 * @return
	 */
	private static boolean isPrime(int n) {
		if (n == 2 || n == 3) {
			return true;
		}
		if (n == 1 || n % 2 == 0) {
			return false;
		}
		// ������̫����

		for (int i = 3; i * i <= n; i += 2) {// �۰�ѭ������,���ڹ�������sqrt n
												// ֮ǰ������ڵĻ����Ϳ��Խ�ʡһ��ʱ��
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
