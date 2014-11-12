package org.hope6537.thinking_in_java.twenty_one;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;

/**
 * @describe 管道发送
 * @author Hope6537(赵鹏)
 * @signdate 2014年8月10日下午1:10:33
 * @version 0.9
 * @company Changchun University&SHXT
 */
class Sender implements Runnable {
	private Random rand = new Random(47);
	private PipedWriter out = new PipedWriter();

	/**
	 * @descirbe 返回输出管道
	 * @author Hope6537(赵鹏)
	 * @return
	 * @signDate 2014年8月10日下午1:12:30
	 * @version 0.9
	 */
	public PipedWriter getPipedWriter() {
		return out;
	}

	public void run() {
		try {
			while (true)
				for (char c = 'A'; c <= 'z'; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
		} catch (IOException e) {
			System.out.println(e + " Sender write exception");
		} catch (InterruptedException e) {
			System.out.println(e + " Sender sleep interrupted");
		}
	}
}

/**
 * @describe 管道获取
 * @author Hope6537(赵鹏)
 * @signdate 2014年8月10日下午1:10:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
class Receiver implements Runnable {
	// 注意获取类
	private PipedReader in;

	/**
	 * @describe 獲取輸出管道，至關重要
	 * @author Hope6537(赵鹏)
	 * @param sender
	 * @throws IOException
	 */
	public Receiver(Sender sender) throws IOException {
		in = new PipedReader(sender.getPipedWriter());
	}

	public void run() {
		try {
			while (true) {
				// Blocks until characters are there:
				System.out.println("Read: " + (char) in.read() + ", ");
			}
		} catch (IOException e) {
			System.out.println(e + " Receiver read exception");
		}
	}
}

public class PipedIO {
	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	}
} /*
 * Output: (65% match) Read: A, Read: B, Read: C, Read: D, Read: E, Read: F,
 * Read: G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M,
 * java.lang.InterruptedException: sleep interrupted Sender sleep interrupted
 * java.io.InterruptedIOException Receiver read exception
 */// :~
