package org.hope6537.thinking_in_java.twenty_one;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @describe 线程本地存储 意义即为在部不同的线程中，面对相同的变量时，生成不同的存储，他们可以使得你可以将状态和线程关联起来
 * @author Hope6537(赵鹏)
 * @signdate 2014年8月7日下午5:54:54
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class ThreadLocalVariableHolder {
	// 通常用作静态域存储
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random rand = new Random(47);

		protected synchronized Integer initialValue() {
			return rand.nextInt(1000);
		}
	};

	// 在ThreadLocal中，只能使用set或者get来访问对象 他是线程安全的，不需要上锁，不会出现竞争条件
	public static void increment() {
		value.set(value.get() + 1);
	}

	public static Integer get() {
		return value.get();
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}

class Accessor implements Runnable {
	private final int id;

	public Accessor(int idn) {
		id = idn;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		return "#" + id + " : " + ThreadLocalVariableHolder.get();
	}
}
