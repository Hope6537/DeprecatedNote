package org.hope6537.thinking_in_java.fifteen;

import java.util.Iterator;

/**
 * @Describe ʹ��������ģʽ��쳲�����������
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����01:57:35
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
	private int n ;
	public IterableFibonacci(int count) {
		n = count;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public void remove() {
				System.out.println("Undefined");
			}
			
			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}
			
			@Override
			public boolean hasNext() {
				
				return n>0;
			}
		};
	}

}
