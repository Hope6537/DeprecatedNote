package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @describe ��̨�̹߳�������ʵ��
 * @author Hope6537(����)
 * @signdate 2014��7��26������11:03:27
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class DaemonFromFactory implements Runnable {
	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(200);
				System.out.println(Thread.currentThread() + ":" + this);
			}
		} catch (Exception e) {
			System.out.println("Out");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// �����ɹ���ģʽ����������ִ����
		ExecutorService exec = Executors
				.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 10; i++) {
			exec.execute(new DaemonFromFactory());
		}
		System.out.println("All Daemons are started");
		TimeUnit.MILLISECONDS.sleep(2000);
		// Ȼ��������ѭ��̨�̶߳���
	}
}
