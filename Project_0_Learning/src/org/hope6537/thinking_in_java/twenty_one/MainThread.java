package org.hope6537.thinking_in_java.twenty_one;

/**
 * @describe ���иղŵĶ��������
 * @author Hope6537(����)
 * @signdate 2014��7��25������6:33:29
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class MainThread {
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
	}
}

/**
 * @describe �̵߳ı�׼������ʽ
 * @author Hope6537(����)
 * @signdate 2014��7��25������6:35:55
 * @version 0.9
 * @company Changchun University&SHXT
 */
class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		// startѸ�پͷ����� �������ǿ��Կ�������������������߳�ִ��
		System.out.println("Waiting for LiftOff");
	}
}

class MoreBasicThreads {
	public static void main(String[] args) {
		// �ַ��߳� ��Ϊ�̵߳��Ȼ����ǲ�ȷ���� ���Կ��ܻᵼ�������ͬ
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new LiftOff());
			t.start();
		}
		System.out.println("5 Rockets are ready to launch");
	}
}
