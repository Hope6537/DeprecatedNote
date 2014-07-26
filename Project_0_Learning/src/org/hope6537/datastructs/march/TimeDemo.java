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

	@SuppressWarnings({ "rawtypes", "unused" })
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
		 * //初始化完成 Dictionary d = new Dictionary(); List<String> list = new
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

		// s.insertionSort(a); /*插入排序 100000个元素 最坏情况 时间为 36581ms */
		// s.shellsort(a);/* 希尔排序 10000000个元素 按最坏情况 时间为 3053ms */
		// hs.heapSort(a); //堆排序 10000000个元素 按最坏情况 时间为 3784ms */
		ms.mergeSort(a); // 归并排序 10000000个元素 按最坏情况 时间为 2499ms */
		/* qs.quickSort(a); 快速排序 10000000个元素 按最坏情况 时间为 2181ms */
		/* s.BooSort(a); 冒泡排序 100000个元素 按最坏情况 时间为 45180ms */
		/* bs.bogoSort(a); 猴子排序 10个元素 最坏情况 时间为永远 */
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
