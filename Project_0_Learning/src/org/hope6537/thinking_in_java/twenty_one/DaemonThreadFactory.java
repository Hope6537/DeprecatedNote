package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.ThreadFactory;

/**
 * @describe 后台线程工厂 可以传递给执行器来执行
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月26日上午10:58:45
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
