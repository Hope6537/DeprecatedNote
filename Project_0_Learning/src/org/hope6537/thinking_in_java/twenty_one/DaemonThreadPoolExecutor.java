package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @describe ÿ����̬��ExecutorService����������������Ϊ����һ��Factory���󣬶�������󽫻ᱻ���������µ��߳�
 * @author Hope6537(����)
 * @signdate 2014��7��26������11:06:13
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
	public DaemonThreadPoolExecutor() {
		// ��ôһ�����ӵĹ��췽������������ɶ���壿
		// ������ִ���̳߳صķ�����Ȼ���أ���һ��DaemonThreadFactory�����Ķ������̳߳ص�Ψһ����?
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new DaemonThreadFactory());

	}
}
