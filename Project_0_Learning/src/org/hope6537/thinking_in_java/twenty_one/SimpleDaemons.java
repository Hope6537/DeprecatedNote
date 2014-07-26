package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.TimeUnit;

/**
 * @describe 后台线程实验
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月26日上午9:58:15
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class SimpleDaemons implements Runnable {
	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " : " + this);
			}
		} catch (Exception e) {
			System.out.println("Sleeping");
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All Daemons Started");
		TimeUnit.MILLISECONDS.sleep(2000);
		//一旦睡眠时间结束，主线程终止，那么后台线程也将被迫终止
	}
}
