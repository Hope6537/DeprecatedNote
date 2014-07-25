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
				// �ϰ�����
				// Thread.sleep(100);
				// ����������ߵ��¼�����ʹ���¼��ܹ�����Ľ���
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			//�쳣�޷����̴߳��� ������Ҫ������λ�Լ����
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
