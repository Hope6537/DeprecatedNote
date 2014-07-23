package org.hope6537.thinking_in_java.fifteen;

/**
 * @Describe ʹ������������쳲���������
 * @Author Hope6537(����)
 * @Signdate 2014-7-19����01:55:10
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Fibonacci implements Generator<Integer> {
	private int count = 0;

	@Override
	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2) {
			return 1;
		}
		return fib(n - 2) + fib(n - 1);
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(fibonacci.next()+ " ");
		}
	}
}
