package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

import org.hope6537.thinking_in_java.eighteen.Directory.TreeInfo;

public class EncodingUtil {

	public static void main(String[] args) {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\");
			TreeInfo tree = Directory
					.walk(stringBuilder.append("\\thinking_in_java\\seventeen").toString());
			List<File> fileList = tree.files;
			for (File file : fileList) {
				GBKtoUTF(file.getAbsolutePath());
				System.out.println(file.getName() + "Finished!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final int BSIZE = 4096;

	/**
	 * @descirbe 将GBK编码文件转化为UTF-8;
	 * @author Hope6537(赵鹏)
	 * @param source
	 * @param target
	 * @signDate 2014年7月26日下午2:00:37
	 * @version 0.9
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("resource")
	public static String GBKtoUTF(String source) throws IOException,
			InterruptedException {
		File folder = new File("G:\\Java");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File sourceFile = new File(source).getAbsoluteFile();
		File targetFile = new File(folder.getAbsoluteFile() + "\\"
				+ sourceFile.getName()).getAbsoluteFile();
		@SuppressWarnings("unused")
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		FileChannel fc = new FileOutputStream(targetFile).getChannel();
		// 只有UTF-16BE好使
		ByteBuffer messages = ByteBuffer
				.wrap(read(sourceFile.getAbsolutePath()).getBytes("UTF-8"));
		fc.write(messages);
		return targetFile.getAbsolutePath();
	}

	public static void rename(String source) {
		File file = new File(source);
		File newFile = new File(source.split(".tmp")[0]);
		if (newFile.exists()) {
			newFile.delete();
		}
		file.renameTo(newFile);
	}

	/**
	 * @descirbe 获得文件的字符串
	 * @author Hope6537(赵鹏)
	 * @param filename
	 * @return
	 * @signDate 2014年7月26日下午2:04:58
	 * @version 0.9
	 */
	private static String read(String filename) {
		// 组建字符串
		StringBuilder sBuilder = new StringBuilder();
		try {
			// 缓冲区读入
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					new File(filename).getAbsoluteFile()));
			try {
				String s;
				while ((s = bufferedReader.readLine()) != null) {
					sBuilder.append(s);
					sBuilder.append("\n");
				}
			} finally {
				// 要防止意外正确关闭
				bufferedReader.close();
			}
		} catch (IOException e) {
			System.err.println("===读取文件异常===");
			e.printStackTrace();
		}
		// 最后返回字符串
		return sBuilder.toString();
	}

	@SuppressWarnings("unused")
	private static boolean write(String filename, String text) {
		boolean status = true;
		try {
			// 标准输出流
			PrintWriter out = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				// 逐个字符串写入
				out.write(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			status = false;
			System.out.println("===写入文件失败===");
			e.printStackTrace();
		}
		return status;
	}
}
