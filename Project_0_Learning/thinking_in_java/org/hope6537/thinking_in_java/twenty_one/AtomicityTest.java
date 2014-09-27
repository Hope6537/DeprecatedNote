package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.*;

/**
 * @describe 测试事务的原子性
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

class SerialNumberGenerator {
	private static volatile int serialNumber = 0;

	/**
	 * @descirbe Java的递增操作不是原子性的。涉及到一个读操作和一个写操作 我们看到了这个方法在没有同步的情况下对共享可变值进行了访问
	 * @author Hope6537(赵鹏)
	 * @return
	 * @signDate 2014年8月7日下午3:19:24
	 * @version 0.9
	 */
	
	public /* 加锁之后线程就安全了 不会出现重复的序列数 synchronized*/ static int nextSerialNumber() {
		return serialNumber++;
	}
}

