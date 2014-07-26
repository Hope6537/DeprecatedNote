package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.ThreadFactory;

/**
 * @describe ��̨�̹߳��� ���Դ��ݸ�ִ������ִ��
 * @author Hope6537(����)
 * @signdate 2014��7��26������10:58:45
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class DaemonThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}
