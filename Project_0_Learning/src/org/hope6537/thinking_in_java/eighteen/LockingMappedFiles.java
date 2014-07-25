package org.hope6537.thinking_in_java.eighteen;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @describe ӳ���ļ��Ĳ��ּ���
 * @author Hope6537(����)
 * @signdate 2014��7��25������11:07:55
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class LockingMappedFiles {

	/**
	 * @describe �����С��ͨ�����ļ�
	 */
	static final int LENGTH = 0x8FFFFFF;
	static FileChannel fc;
	static final File file = new File("G:\\LockingMappedFiles.dat");

	public static void main(String[] args) throws Exception {
		// ����ͨ�����ͣ�ӳ�䷽ʽ��ͬʱд���ļ��������ò��ּ������췽��
		fc = new RandomAccessFile(file, "rw").getChannel();
		MappedByteBuffer out = fc
				.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for (int i = 0; i < LENGTH; i++) {
			out.put((byte) 'x');
		}
		new LockAndModify(out, 0, 0 + LENGTH / 3);
		new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
	}

	public static class LockAndModify extends Thread {
		// �����ﶨ����ͼ����ͼ��ȡ�Ŀ�ʼ���ͽ�����
		private ByteBuffer buff;
		private int start, end;

		public LockAndModify(ByteBuffer buff, int start, int end) {
			this.start = start;
			this.end = end;
			buff.limit(end);
			buff.position(start);
			// buff.slice()��ʲô��˼�� �������޸Ļ�����
			this.buff = buff.slice();
			// Ȼ��ֱ���߳�����
			start();
		}

		@Override
		public void run() {
			try {
				// �����ļ������������ֽ�ͬʱ��+1д���ȥ
				FileLock fl = fc.lock(start, end, false);
				System.out.println("Locked : " + start + " to " + end);
				while (buff.position() < buff.limit() - 1) {
					buff.put((byte) (buff.get() + 1));
				}
				fl.release();
				System.out.println("Release: " + start + " to " + end);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
