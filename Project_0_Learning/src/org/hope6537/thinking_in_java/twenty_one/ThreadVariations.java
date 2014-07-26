package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.*;

/**
 * @describe ��һ�ְ�װ���� ֱ�Ӽ̳�Thread�࣬������������ھ����� �޷����ؼ̳�
 * @author Hope6537(����)
 * @signdate 2014��7��26������12:53:37
 * @version 0.9
 * @company Changchun University&SHXT
 */
class InnerThread1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner extends Thread {
		Inner(String name) {
			super(name);
			start();//ֱ�ӵ���Start
		}

		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0)
						return;
					sleep(10);
				}
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
		}

		public String toString() {
			return getName() + ": " + countDown;
		}
	}
//	�ڹ��췽��������inner�߳��� ��inner��ֱ�Ӿͻ�ִ��start
	public InnerThread1(String name) {
		inner = new Inner(name);
	}
}

/**
 * @describe �����̶߳���t Ȼ�����ڲ����з���ʵ�֣��ֶ�����start�����߳�
 * @author Hope6537(����)
 * @signdate 2014��7��26������12:54:12
 * @version 0.9
 * @company Changchun University&SHXT
 */
class InnerThread2 {
	private int countDown = 5;
	private Thread t;

	public InnerThread2(String name) {
		t = new Thread(name) {
			public void run() {
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0)
							return;
						sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("sleep() interrupted");
				}
			}

			public String toString() {
				return getName() + ": " + countDown;
			}
		};
		t.start();
	}
}

/**
 * @describe �ڲ���ʵ��Runnable�ӿ� Ȼ���������������̶߳����ٵ���start����
 * @author Hope6537(����)
 * @signdate 2014��7��26������12:54:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
class InnerRunnable1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner implements Runnable {
		Thread t;

		Inner(String name) {
			t = new Thread(this, name);
			t.start();
		}

		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0)
						return;
					TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				System.out.println("sleep() interrupted");
			}
		}

		public String toString() {
			return t.getName() + ": " + countDown;
		}
	}

	public InnerRunnable1(String name) {
		inner = new Inner(name);
	}
}

/**
 * @describe tֱ������Thread Runnableʵ��
 * @author Hope6537(����)
 * @signdate 2014��7��26������12:55:18
 * @version 0.9
 * @company Changchun University&SHXT
 */
class InnerRunnable2 {
	private int countDown = 5;
	private Thread t;

	public InnerRunnable2(String name) {
		t = new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0)
							return;
						TimeUnit.MILLISECONDS.sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("sleep() interrupted");
				}
			}

			public String toString() {
				return Thread.currentThread().getName() + ": " + countDown;
			}
		}, name);
		t.start();
	}
}

/**
 * @describe ���̷߳�װ����������
 * @author Hope6537(����)
 * @signdate 2014��7��26������12:55:36
 * @version 0.9
 * @company Changchun University&SHXT
 */
class ThreadMethod {
	private int countDown = 5;
	private Thread t;
	private String name;

	public ThreadMethod(String name) {
		this.name = name;
	}

	/**
	 * @descirbe �÷����߳�ִ��֮ǰ����
	 */
	public void runTask() {
		if (t == null) {
			t = new Thread(name) {
				public void run() {
					try {
						while (true) {
							System.out.println(this);
							if (--countDown == 0)
								return;
							sleep(10);
						}
					} catch (InterruptedException e) {
						System.out.println("sleep() interrupted");
					}
				}

				public String toString() {
					return getName() + ": " + countDown;
				}
			};
			t.start();
		}
	}
}

/**
 * @describe �̵߳Ķ��ְ�װ����
 * @author Hope6537(����)
 * @signdate 2014��7��26������12:53:21
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class ThreadVariations {
	public static void main(String[] args) {
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
		new ThreadMethod("ThreadMethod").runTask();
	}
}
