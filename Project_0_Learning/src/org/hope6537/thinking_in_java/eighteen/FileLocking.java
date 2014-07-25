package org.hope6537.thinking_in_java.eighteen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @describe �ļ���������
 * @author Hope6537(����)
 * @signdate 2014��7��25������10:33:20
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
			//����ʱ���޸��ļ������[��һ����������ʹ�ô��ļ��������޷���������]
			fl.release();
			System.out.println("Released Lock");
		}
		out.close();
	}

}
