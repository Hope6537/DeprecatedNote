package org.hope6537.datastructs.march;

import java.util.Arrays;

import org.hope6537.datastructs.Sort.BogoSort;
import org.hope6537.datastructs.Sort.HeapSort;
import org.hope6537.datastructs.Sort.MergeSort;
import org.hope6537.datastructs.Sort.QuickSort;
import org.hope6537.datastructs.Sort.Sort;


public class TimeDemo {

	public static long returnTime() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {

		/*
		 * LinkedList<Integer> list1 = new LinkedList<Integer>();
		 * ArrayList<Integer> list2 = new ArrayList<Integer>(); int [] a1 = new
		 * int [100000]; list1.clear(); list2.clear();
		 * 
		 * for(int i = 0; i < 100000 ; i++){ list1.add(i); list2.add(i); a1[i] =
		 * i; }
		 */
		/*
		 * //��ʼ����� Dictionary d = new Dictionary(); List<String> list = new
		 * ArrayList<String>(); for(int i = 65 ; i < 85 ; i++){ for(int j = 65 ;
		 * j < 85 ; j++){ for(int k = 65 ; k < 85 ; k++){ for(int n = 65 ; n <
		 * 85 ; n++){ list.add((char)i+"K"+(char)i+(char)j+(char)k+(char)n); } }
		 * 
		 * }
		 * 
		 * }
		 */
		Integer a[] = new Integer[10000000];
		for (int i = 9999999; i >= 0; i--) {
			a[i] = Integer.valueOf(i);
		}
		Sort s = new Sort();
		HeapSort hs = new HeapSort();
		BogoSort bs = new BogoSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		ThreadDemo t = new ThreadDemo();

		t.run();
		Arrays.sort(a);
		long f = t.TIME;
		// start

		// s.insertionSort(a); /*�������� 100000��Ԫ�� ���� ʱ��Ϊ 36581ms */
		// s.shellsort(a);/* ϣ������ 10000000��Ԫ�� ������ ʱ��Ϊ 3053ms */
		// hs.heapSort(a); //������ 10000000��Ԫ�� ������ ʱ��Ϊ 3784ms */
		ms.mergeSort(a); // �鲢���� 10000000��Ԫ�� ������ ʱ��Ϊ 2499ms */
		/* qs.quickSort(a); �������� 10000000��Ԫ�� ������ ʱ��Ϊ 2181ms */
		/* s.BooSort(a); ð������ 100000��Ԫ�� ������ ʱ��Ϊ 45180ms */
		/* bs.bogoSort(a); �������� 10��Ԫ�� ���� ʱ��Ϊ��Զ */
		// end
		t.run();
		long e = t.TIME;
		System.out.println("---------------");
		System.out.println(Math.abs(e - f) + "ms");

		/*
		 * for(int i = 0 ; i<a.length ; i++){ System.out.println(a[i]); }
		 */
		/*
		 * for(int x : a1){ System.out.println(" "+x); }
		 */

	}
}

class ThreadDemo implements Runnable {

	public long TIME;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		TIME = TimeDemo.returnTime();
	}

}
