package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @describe Executorִ������ʹ�� ��ѡ
 * @author Hope6537(����)
 * @signdate 2014��7��25������6:54:36
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class CachedThreadPool {

	public static void main(String[] args) {
		// ����һ��ִ����
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		// ��shutdown�ĵ��������ڷ�ֹ�µ������ύ����
		exec.shutdown();
	}
}

// ����Ҫע�����̳߳��� �����߳����п��ܵ�����£����ᱻ�Զ�����

/**
 * @describe ���޸����̳߳� ����ĳ������������
 * @author Hope6537(����)
 * @signdate 2014��7��25������7:17:03
 * @version 0.9
 * @company Changchun University&SHXT
 */
class FixedThreadPool {
	// ʹ�������޵��̼߳����ύ����
	public static void main(String[] args) {
		// �������
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			// ͨ�����л�ȡ�̶��߳�
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}

/**
 * @describe ��һ�̳߳� ����ִ���������е�����
 * @author Hope6537(����)
 * @signdate 2014��7��25������7:17:53
 * @version 0.9
 * @company Changchun University&SHXT
 */
class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			// ͨ�����л�ȡ�̶��߳� ���ڲ���һ�����ҵ��������
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
