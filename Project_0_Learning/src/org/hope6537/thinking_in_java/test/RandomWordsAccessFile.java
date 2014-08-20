package org.hope6537.thinking_in_java.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counting implements Runnable {
	private static int seconds;

	@Override
	public void run() {
		System.out.println("Running");
		while (!Thread.interrupted()) {
			System.out.println("Now Running at " + seconds + "seconds");
			try {
				TimeUnit.SECONDS.sleep(10);
				seconds += 10;
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Stop");
	}
}

class Exec implements Runnable {
	private volatile File file;
	private volatile static ArrayList<String> list;

	public synchronized void write() {
		try {
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());
			try {
				// 調用本身ArrayList的迭代器
				for (String item : list) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			System.out.println("===写入文件失败===");
			e.printStackTrace();
		}
	}

	public Exec(File file, ArrayList<String> list) {
		super();
		Exec.list = list;
		this.file = file;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static final String[] objects = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", " ", " ", " ", " ", " ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
			" ", " ", " ", " ", "\r\n", "\r\n", "\r\n", "\r\n", "\r\n", "\r\n",
			"\r\n", "\r\n", "\r\n", "\r\n", };

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			synchronized (file) {
				Random rand = new Random(47);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 10000; i++) {
					sb.append(objects[rand.nextInt(97)]);
				}
				list.add(sb.toString());
			}
		}
		write();
		System.out.println("Write Finished");
	}
}

public class RandomWordsAccessFile {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Exec(new File("G:\\Test" + i + ".txt"), list));
		}
		exec.execute(new Counting());
		TimeUnit.SECONDS.sleep(7);
		exec.shutdownNow();
	}
}
