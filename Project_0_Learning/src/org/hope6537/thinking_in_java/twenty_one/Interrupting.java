package org.hope6537.thinking_in_java.twenty_one;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(300);
		} catch (Exception e) {
			System.out.println("Interrupting");
		}
		System.out.println("Exiting Sleep");
	}

}

class IOBlocked implements Runnable {
	private InputStream in;

	public IOBlocked(InputStream in) {
		this.in = in;

	}

	@Override
	public void run() {
		try {
			System.out.println("Waiting for Read");
			in.read();
		} catch (Exception e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupting from io");
			} else {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IO");
	}
}

class SynchronizedBlocked implements Runnable {
	// 这个方法永远不会放掉锁
	public synchronized void f() {
		while (true)
			Thread.yield();
	}

	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f();// 被这个线程死锁
			}
		}.start();
	}

	public void run() {
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}
}

public class Interrupting {

	private static ExecutorService exec = Executors.newCachedThreadPool();

	static void test(Runnable r) throws InterruptedException {
		// 执行exec中的单个线程
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting " + r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to" + r.getClass().getName());
	}

	public static void main(String[] args) throws InterruptedException {
		test(new SleepBlocked());
		test(new SynchronizedBlocked());
		test(new IOBlocked(System.in));
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0)");
		System.exit(0);
	}
}
