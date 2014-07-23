package org.hope6537.thinking_in_java.eighteen;

import java.io.File;
import java.io.IOException;

/**
 * @describe ��͸Ŀ¼�����ļ�����
 * @author Hope6537(����)
 * @signdate 2014��7��23������3:26:40
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class ProcessFiles {

	/**
	 * @describe ����ӿ� �����ļ��Ľӿ�
	 * @author Hope6537(����)
	 * @signdate 2014��7��23������3:26:51
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	public interface Strategy {
		/**
		 * @descirbe �����ļ�ʵ��
		 * @author Hope6537(����)
		 * @param file
		 * @signDate 2014��7��23������3:27:11
		 * @version 0.9
		 */
		void process(File file);
	}

	/**
	 * @describe һ����ʵ�����
	 */
	private Strategy strategy;
	/**
	 * @describe һ�����ļ���׺��
	 */
	private String ext;

	public ProcessFiles(Strategy strategy, String ext) {
		super();
		this.strategy = strategy;
		this.ext = ext;
	}

	/**
	 * @descirbe ������ʼ���� 
	 * @author Hope6537(����)
	 * @param args
	 * @signDate 2014��7��23������3:27:47
	 * @version 0.9
	 */
	public void start(String[] args) {
		try {
			//�������Ϊ�յĻ�����ô���Ӹõ㿪ʼ����
			if (args.length == 0) {
				processDirectoryTree(new File("."));
			} else {
				for (String arg : args) {
					//����ж��ؿ�ʼ��,���ν�����Ѱ��
					File fileArg = new File(arg);
					if (fileArg.isDirectory()) {
						//���ΪĿ¼�����ż���
						processDirectoryTree(fileArg);
					} else {
						//���Ϊ�ļ���������������ϸ�ʽ����Ӻ�׺����
						if (!arg.endsWith("." + ext)) {
							arg += "." + ext;
						}
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @descirbe ����Ŀ¼��
	 * @author Hope6537(����)
	 * @param root
	 * @throws IOException
	 * @signDate 2014��7��23������3:28:36
	 * @version 0.9
	 */
	public void processDirectoryTree(File root) throws IOException {
		//����һ�����ڵ�root 
		//Ȼ����������ڵ�ľ���·�������Դ˿�ʼ���±��� Treeinfo��ʵ�ֵ������� ʵ�ֵ���ʵ���ļ��ĵ�����
		//Ȼ�����θ�File���д���
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			//����Ľ���ǵ��ö����process����
			//�����ʵ����process���������ǽ����ӡ����
			strategy.process(file.getCanonicalFile());

		}
	}

	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy() {
			@Override
			public void process(File file) {
				System.out.println(file);
			}
		}, "java").start(args);
	}
}
