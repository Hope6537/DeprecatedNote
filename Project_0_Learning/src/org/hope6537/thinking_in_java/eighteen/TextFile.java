package org.hope6537.thinking_in_java.eighteen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @describe 读写文件的工具类
 * @author Hope6537(赵鹏)
 * @signdate 2014年7月24日上午10:19:51
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class TextFile extends ArrayList<String> {

	private static final long serialVersionUID = -7716867579398514830L;

	/**
	 * @descirbe 获得文件的字符串
	 * @author Hope6537(赵鹏)
	 * @param filename
	 * @return
	 * @signDate 2014年7月24日上午10:20:01
	 * @version 0.9
	 */
	public static String read(String filename) {
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

	/**
	 * @descirbe 将字符串写入文件
	 * @author Hope6537(赵鹏)
	 * @param filename
	 * @param text
	 * @return
	 * @signDate 2014年7月24日上午10:20:46
	 * @version 0.9
	 */
	public static boolean write(String filename, String text) {
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

	/**
	 * @describe 构造方法重写
	 * @author Hope6537(赵鹏)
	 * @param filename
	 *            定义文件名称
	 * @param splitter
	 *            定义分割号名称
	 */
	public TextFile(String filename, String splitter) {
		super(Arrays.asList(read(filename).split(splitter)));
		// 紧接着我们得到了一个按照分割符排列的ArrayList 通过get(index)即可调用
		// 消除第一个空白行
		if (get(0).equals("")) {
			remove(0);
		}
	}

	public TextFile(String filename) {
		this(filename, "\n");

	}

	/**
	 * @descirbe 将持有的ArrayList写入到文件中去 相当于复制粘贴
	 * @author Hope6537(赵鹏)
	 * @param filename
	 * @signDate 2014年7月24日上午10:23:09
	 * @version 0.9
	 */
	public void write(String filename) {
		try {
			PrintWriter out = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				// 調用本身ArrayList的迭代器
				for (String item : this) {
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

	public static void main(String[] args) {
		String sourcename = "E:\\(WorkSpace04)GitHub\\Project_00_Learning\\Project_0_Learning\\src\\org\\hope6537\\thinking_in_java\\eighteen\\TextFile.java";
		String filename = "G:\\Data2.txt";
		String filename2 = "G:\\Data3.txt";
		String file = read(sourcename);
		write(filename, file);
		TextFile textFile = new TextFile(filename);
		textFile.write(filename);
		TreeSet<String> words = new TreeSet<String>(new TextFile(sourcename,
				"\\W+"));
		System.out.println(words.headSet("a"));
	}
}
