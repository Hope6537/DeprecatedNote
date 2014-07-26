package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @describe ���̃��ȼ����
 * @author Hope6537(����)
 * @signdate 2014��7��26������9:51:30
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class SimplePriorities implements Runnable {
	private static int countDown = 5;
	private volatile double d;
	private int priority;

	public SimplePriorities(int priority) {
		super();
		this.priority = priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread() + ":" + countDown;
	}

	@Override
	public void run() {
		//���ȼ����߳�ִ��ʱ������ ���ڹ��췽��
		Thread.currentThread().setPriority(priority);
		while (true) {
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(this);
			if (--countDown == 0) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		//���ֻʹ��������
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
