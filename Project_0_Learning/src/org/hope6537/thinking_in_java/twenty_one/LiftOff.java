package org.hope6537.thinking_in_java.twenty_one;

/**
 * @describe ������߳�����
 * @author Hope6537(����)
 * @signdate 2014��7��25������6:28:29
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
			Thread.yield();//�̵߳����� ��ʾ���Ѿ�ִ��������Ҫ�Ĳ����ˣ����Խ�����Ȩ�ƽ�������߳�
		}
	};

}
