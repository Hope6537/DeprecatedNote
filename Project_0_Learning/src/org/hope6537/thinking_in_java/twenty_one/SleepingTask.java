package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

	@Override
	public void run() {
		try {
			while (countDown-- > 0) {
				System.out.println(status());
				// 老版休眠
				// Thread.sleep(100);
				// 正是这段休眠的事件所以使得事件能够有序的进行
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			//异常无法跨线程传递 所以需要各个单位自己解决
			System.out.println("Crashed!");
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
