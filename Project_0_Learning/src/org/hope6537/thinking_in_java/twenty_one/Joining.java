package org.hope6537.thinking_in_java.twenty_one;

class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}

	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. "
					+ "isInterrupted(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}

}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}

	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}

/**
 * @describe ����Join���� ��������
 *           ��������Sleeper�߳������������߳̽�������һ��ʱ��,�����ʱ���Joiner�߳��ڲ������sleeper
 *           .join()����������߳��У������Sleeper���� ������Joiner�߳̽���֮��
 *           �Ὣ����Ȩ���ظ�Sleeper,��ʱ���ǽ�����ִ��˯�߲�����ֱ��ʱ�䵽��������
 * @author Hope6537(����)
 * @signdate 2014��7��26������1:26:20
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class Joining {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500), grumpy = new Sleeper(
				"Grumpy", 1500);
		Joiner dopey = new Joiner("Dopey", sleepy), doc = new Joiner("Doc",
				grumpy);
		// ������� �Ӷ�ʹ֮���JoinerѸ����ɲ���
		grumpy.interrupt();
		// ����Sleeper���жϻ�����Ȼ����֮��JoinerҲ���Sleeperһͬ����
	}
}
