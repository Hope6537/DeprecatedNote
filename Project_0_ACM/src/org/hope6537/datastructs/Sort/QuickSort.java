package org.hope6537.datastructs.Sort;

/**
 * @Describe ��������
 * @Author Hope6537(����)
 * @Signdate 2014-4-6����04:00:12
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class QuickSort {

	/**
	 * @Descirbe ѡ����ŦԪ
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param left ���������α�
	 * @Params @param right �Ҳ�������α�
	 * @Params @return
	 * @SignDate 2014-4-6����04:04:12
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static <AnyType extends Comparable<? super AnyType>> AnyType median3(
			AnyType[] a, int left, int right) {
		// �ҳ���ֵ��
		int center = (left + right) / 2;
		// �������С���󶨵� �򻥻�
		if (a[center].compareTo(a[left]) < 0) {
			swapReferences(a, left, center);
		}
		// ����Ҳ�С����� �򻥻�
		if (a[right].compareTo(a[left]) < 0) {
			swapReferences(a, left, right);
		}
		// ����Ҳ�С������ �򻥻�
		if (a[right].compareTo(a[center]) < 0) {
			swapReferences(a, center, right);
		}
		// ��������С�������� left center right��������
		/*
		 * �����ĵ����� ����ŦԪ���Ҳ�-1λ�õ��α���н��� ��Ϊleft center right�Ƿ����������е�
		 * ��������������Ǵ�left+1��right-2��
		 */

		swapReferences(a, center, right - 1);

		return a[right - 1];
	}

	private static final int CUTOFF = 3;

	private static <AnyType extends Comparable<? super AnyType>> void quickSort(
			AnyType[] a, int left, int right) {
		if (left + CUTOFF <= right) {
			// ������α굽���α�������Ԫ��
			// ��ô˵����ŦԪ����
			AnyType pivot = median3(a, left, right);
			//�������ұ߽翪ʼ���б���
			int i = left;
			int j = right - 1; 
			for (;;) {
				//����ѭ�� 
				while (a[++i].compareTo(pivot) < 0) {
					//�������ʼ�����ı�����������ŦԪ��С ����ű��� ֱ������������ŦԪ��ֹͣ
				}
				while (a[--j].compareTo(pivot) > 0) {
					//������ҿ�ʼ����ı�����������ŦԪ�Ĵ� ����ű��� ֱ������С����ŦԪ��ֹͣ
				}
				if (i < j) {
					//���i j�ı߽�Ϸ� �򻥻�
					swapReferences(a, i, j);
				} else {
					//����߽粻�Ϸ� ��˵���������Ѿ�������� ����
					break;
				}
			}
			//����ŦԪ������
			swapReferences(a, i, right - 1);
			//ͬʱ�ٽ������S1 S2����Ⱥ���зָ����� 
			quickSort(a, left, i - 1);
			quickSort(a, i, right);

		} else {
			//���ָ�ɽ���3��Ԫ��ʱ ��ô������������,�źõ�ͬʱ�ݹ鷵��
			insertionSort(a, left, right);
		}
	}

	/**
	 * @Descirbe ���߽�Ĳ�������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param left
	 * @Params @param right
	 * @SignDate 2014-4-6����04:18:28
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param left
	 * @param right
	 */
	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(
			AnyType[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) {
			AnyType tmp = a[p];
			int j;

			for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * @Descirbe ����Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param index1
	 * @Params @param index2
	 * @SignDate 2014-4-6����01:42:56
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param index1
	 * @param index2
	 */
	public static <AnyType> void swapReferences(AnyType[] a, int index1,
			int index2) {
		AnyType tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType [] a){
		quickSort(a, 0, a.length-1);
	}

}
