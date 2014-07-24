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
 * @describe ��д�ļ��Ĺ�����
 * @author Hope6537(����)
 * @signdate 2014��7��24������10:19:51
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class TextFile extends ArrayList<String> {

	private static final long serialVersionUID = -7716867579398514830L;

	/**
	 * @descirbe ����ļ����ַ���
	 * @author Hope6537(����)
	 * @param filename
	 * @return
	 * @signDate 2014��7��24������10:20:01
	 * @version 0.9
	 */
	public static String read(String filename) {
		// �齨�ַ���
		StringBuilder sBuilder = new StringBuilder();
		try {
			// ����������
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					new File(filename).getAbsoluteFile()));
			try {
				String s;
				while ((s = bufferedReader.readLine()) != null) {
					sBuilder.append(s);
					sBuilder.append("\n");
				}
			} finally {
				// Ҫ��ֹ������ȷ�ر�
				bufferedReader.close();
			}
		} catch (IOException e) {
			System.err.println("===��ȡ�ļ��쳣===");
			e.printStackTrace();
		}
		// ��󷵻��ַ���
		return sBuilder.toString();
	}

	/**
	 * @descirbe ���ַ���д���ļ�
	 * @author Hope6537(����)
	 * @param filename
	 * @param text
	 * @return
	 * @signDate 2014��7��24������10:20:46
	 * @version 0.9
	 */
	public static boolean write(String filename, String text) {
		boolean status = true;
		try {
			// ��׼�����
			PrintWriter out = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				// ����ַ���д��
				out.write(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			status = false;
			System.out.println("===д���ļ�ʧ��===");
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * @describe ���췽����д
	 * @author Hope6537(����)
	 * @param filename
	 *            �����ļ�����
	 * @param splitter
	 *            ����ָ������
	 */
	public TextFile(String filename, String splitter) {
		super(Arrays.asList(read(filename).split(splitter)));
		// ���������ǵõ���һ�����շָ�����е�ArrayList ͨ��get(index)���ɵ���
		// ������һ���հ���
		if (get(0).equals("")) {
			remove(0);
		}
	}

	public TextFile(String filename) {
		this(filename, "\n");

	}

	/**
	 * @descirbe �����е�ArrayListд�뵽�ļ���ȥ �൱�ڸ���ճ��
	 * @author Hope6537(����)
	 * @param filename
	 * @signDate 2014��7��24������10:23:09
	 * @version 0.9
	 */
	public void write(String filename) {
		try {
			PrintWriter out = new PrintWriter(
					new File(filename).getAbsoluteFile());
			try {
				// �{�ñ���ArrayList�ĵ�����
				for (String item : this) {
					out.println(item);
				}

			} finally {
				out.close();
			}
		} catch (IOException e) {
			System.out.println("===д���ļ�ʧ��===");
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
