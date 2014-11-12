package org.hope6537.thinking_in_java.eighteen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @describe 文件加锁机制
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月25日上午10:33:20
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class FileLocking {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		FileOutputStream out = new FileOutputStream("G:\\FileLocking.txt");
		FileLock fl = out.getChannel().tryLock();
		if (fl != null) {
			System.out.println("Locked File");
			TimeUnit.MILLISECONDS.sleep(10000);
			//锁定时候修改文件会出现[另一个程序正在使用此文件，进程无法访问字样]
			fl.release();
			System.out.println("Released Lock");
		}
		out.close();
	}

}
