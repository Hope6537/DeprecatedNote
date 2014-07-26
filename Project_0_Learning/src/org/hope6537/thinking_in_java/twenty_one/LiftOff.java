package org.hope6537.thinking_in_java.twenty_one;

/**
 * @describe 定义多线程任务
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月25日下午6:28:29
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class LiftOff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		super();
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();//线程调度器 表示我已经执行完最主要的部分了，可以将控制权移交给别的线程
		}
	};

}
