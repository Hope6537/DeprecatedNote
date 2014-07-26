package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable {
	private Thread[] threads = new Thread[10];

	@Override
	public void run() {
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new DaemonSpawn());
			threads[i].start();
			System.out.println("Daemon Spawn " + i + " started ");
		}
		for (int i = 0; i < threads.length; i++) {
			System.out.println("threads[" + i + "].isDaemon() = "
					+ threads[i].isDaemon());
		}
		while (true) {
			Thread.yield();
		}

	}
}

class DaemonSpawn implements Runnable {
	public void run() {
		while (true) {
			Thread.yield();
		}
	}
}

class ADaemon implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Start");
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ��̨���̲���������Finally
			System.out.println("RUN?");
		}
	}
}

class DaemonDontRunFinally {
	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}

/**
 * @describe ���һ����̨�̴߳������̣߳���ô�������������̶߳��Ǻ�̨�߳�
 * @author Hope6537(����)
 * @signdate 2014��7��26������11:24:15
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Daemons {
	public static void main(String[] args) throws Exception {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon() = " + d.isDaemon() + ",");
		TimeUnit.SECONDS.sleep(1);
	}
}
