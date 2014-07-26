package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.TimeUnit;

/**
 * @describe ��̨�߳�ʵ��
 * @author Hope6537(����)
 * @signdate 2014��7��26������9:58:15
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
		//һ��˯��ʱ����������߳���ֹ����ô��̨�߳�Ҳ��������ֹ
	}
}
