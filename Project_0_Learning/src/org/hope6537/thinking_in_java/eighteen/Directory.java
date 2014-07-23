package org.hope6537.thinking_in_java.eighteen;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @describe ��ӡ�ļ�Ŀ¼��
 * @author Hope6537(����)
 * @signdate 2014��7��23������2:28:20
 * @version 0.9
 * @company Changchun University&SHXT
 */
public final class Directory {
	/**
	 * @descirbe ���ص�ǰdir�µĵ�һ��Ŀ¼
	 * @author Hope6537(����)
	 * @param dir
	 * @param regex
	 * @return
	 * @signDate 2014��7��23������3:08:39
	 * @version 0.9
	 */
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(/**
		 * @describe
		 *           ���ɵ���һ���ڲ�FilenameFilter��ʵ���࣬���ཫ����list()�����ص�accept����������ƥ��
		 * @author Hope6537(����)
		 * @signdate 2014��7��23������3:08:53
		 * @version 0.9
		 * @company Changchun University&SHXT
		 */
		new FilenameFilter() {
			/**
			 * @describe ��Ϊ�ڲ���Ҫʹ��regex ���Ա���final
			 */
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}

	/**
	 * @descirbe local����������
	 * @author Hope6537(����)
	 * @param path
	 * @param regex
	 * @return
	 * @signDate 2014��7��23������3:09:57
	 * @version 0.9
	 */
	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}

	/**
	 * @describe һ��Ŀ¼����ʵ��
	 * @author Hope6537(����)
	 * @signdate 2014��7��23������3:10:39
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	public static class TreeInfo implements Iterable<File> {
		/**
		 * @describe ��List�����ļ�
		 */
		public List<File> files = new ArrayList<File>();
		/**
		 * @describe ��List����Ŀ¼
		 */
		public List<File> dirs = new ArrayList<File>();

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Iterable#iterator() ���ɹ���Ŀ¼�ļ��ĵ�����
		 * 
		 * @author:Hope6537(����)
		 */
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}

		/**
		 * @descirbe �������һ��Ŀ¼������ӵ�����
		 * @author Hope6537(����)
		 * @param other
		 * @signDate 2014��7��23������3:11:33
		 * @version 0.9
		 */
		void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString() ��ʽ�����
		 * 
		 * @author:Hope6537(����)
		 */
		@Override
		public String toString() {
			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: "
					+ PPrint.pformat(files);
		}

	}

	/**
	 * @descirbe �ݹ��������ǰstartDir�µ�����File�ļ��������շ�������Ŀ¼��
	 * @author Hope6537(����)
	 * @param startDir
	 * @param regex
	 * @return
	 * @signDate 2014��7��23������3:12:05
	 * @version 0.9
	 */
	static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();
		// ��startDir����list������Ŀ¼���б���
		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				// �����Ŀ¼����ô��ӽ�Ŀ¼List
				result.dirs.add(item);
				// ͬʱ���Ž���Ŀ¼��ʼ�ı���֮���TreeInfo�ٺϲ�
				result.addAll(recurseDirs(item, regex));
			} else {
				// ������ļ���ֱ����ӽ��ļ�List(ǰ�ᣬ�������������ʽ)
				if (item.getName().matches(regex)) {
					result.files.add(item);
				}
			}
		}
		// ���շ���Ŀ¼��
		return result;
	}

	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) {
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(File start) {
		return recurseDirs(start, ".*");
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	/**
	 * @descirbe ������������������
	 * @author Hope6537(����)
	 * @param args
	 * @signDate 2014��7��23������3:15:59
	 * @version 0.9
	 */
	public static void start(String[] args) {

		if (args.length == 0) {
			System.out.println(walk("."));
		} else {
			for (String arg : args) {
				System.out.println(walk(arg));
			}
		}

	}

	public static void main(String[] args) {
		start(new String[] { "D:\\Materials" });
	}
}
