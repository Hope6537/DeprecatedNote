package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.*;

/**
 * @describe 测试事务的完整性
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月26日下午8:34:11
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class AtomicityTest implements Runnable {
	private int i = 0;

	public int getValue() {
		return i;
	}

	private synchronized void evenIncrement() {
		i++;
		i++;
	}

	public void run() {
		while (true)
			evenIncrement();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while (true) {
			int val = at.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
