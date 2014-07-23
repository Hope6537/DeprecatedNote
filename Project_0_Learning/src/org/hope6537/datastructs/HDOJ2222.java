package org.hope6537.datastructs;

import java.util.Scanner;

/**
 * javadoc
 * @Describe AC�Զ���,��ģ�ַ���ƥ��,��������,HDOJ2222
 * @From : http://www.cppblog.com/mythit/archive/2009/04/21/80633.html �м�����
 * @Author Hope6537(����)
 * @Signdate 2014-6-8����4:05:11
 * @version 0.9
 * @company Changchun University&SHXT
 */

public class HDOJ2222 {
	
	private final static int tire = 26;// ������26��Ӣ����ĸ �ֵ����Ľڵ����

	/**
	 * @Describe �������нڵ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-6-8����4:43:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	static class Node {
		Node fail; // ʧ����Ѱָ��
		Node[] next; // Tireÿ���ڵ��26���ӽڵ㣨���26����ĸ��
		int count; // �Ƿ�Ϊ�õ��ʵ����һ���ӽڵ�

		/**
		 * @Describe ���췽��
		 * @Author Hope6537(����)
		 * @param
		 */
		public Node() {
			fail = null;
			count = 0;// false
			next = new Node[tire];
		}

	}
	
	/**
	 * @Describe ��������� ���������������Ĺ���ʧ��ָ��
	 */
	static Node[] q;
	/**
	 * @Describe ����
	 */
	static Scanner s = new Scanner(System.in);
	/**
	 * @Describe ���е���ʵ�ַ���
	 */
	// static Queue<Node> q = new LinkedList<Node>();
	/**
	 * @Describe ����ؼ���
	 */
	static String keyWord; // ��Ҫ����Ĺؼ���
	/**
	 * @Describe �ı�
	 */
	static String str;
	/**
	 * @Describe ����ͷβ��
	 */
	static int head, tail;

	/**
	 * @Descirbe �����ֵ���
	 * @Author Hope6537(����)
	 * @param str
	 * @param root
	 * @SignDate 2014-6-8����4:08:54
	 * @Version 0.9
	 */
	static void insertTire(String str, Node root) {
		//���Ƚ����ֵ����������͹ؼ��ֵ��ַ���
		Node p = root;
		int i = 0, index = -1;
		while (i < str.length() && str.charAt(i) != ' ') {
			//��ÿ���ַ����з�������������λ��
			index = str.charAt(i) - 'a';
			//�����ǰ�ֵ����ڵ�ĺ����ӽڵ�û������ַ�
			if (p.next[index] == null) {
				//����֮
				p.next[index] = new Node();
			}
			//����ֵ��ͬʱi++������һ���ַ�
			p = p.next[index];
			i++;
		}
		//�൱��true
		p.count++;// �ڵ��ʵ����һ���ڵ�count+1������һ�����ʵĳ���
	}

	/**
	 * @Descirbe �����Զ�AC��~
	 * @Author Hope6537(����)
	 * @param root
	 * @SignDate 2014-6-8����4:19:09
	 * @Version 0.9
	 */
	static void ac_atuomation(Node root) {
		//������־����š�
		int i;
		//��������ʧ��ָ��
		root.fail = null;
		//����ǰ���������������
		// q.add(root);
		q[head++] = root;
		//��������ڻ���Ԫ��
		while (head != tail/* !q.isEmpty() */) {
			//��������
			// Node temp = q.poll();
			Node temp = q[tail++];
			//����ȡԪ�أ�p����ǰ�ڵ��ʧ��ָ��
			Node p = null;
			//�������ֵ������б�������
			for (i = 0; i < 26; i++) {
				//�����ǰ�ڵ��и��ַ��Ľڵ㣬����i������ַ�char����Ϊ�գ�˵����������
				if (temp.next[i] != null) {
					//�����ǰ�ڵ��Ǳ������������ôָ���Լ�
					if (temp == root) {
						temp.next[i].fail = root;
					} else {
						//���������������
						p = temp.fail;
						//pָ��ʧ��ָ��
						while (p != null) {
							//���p���ǿվͽ���ѭ�����������ѣ�
							if (p.next[i] != null) {
								//���p�ĺ�̽ڵ㻹ƥ�䵽�ֵ������������ͬ��char�Ľڵ㣬��ô����ǰ��temp����ʧ��ָ��ָ����
								temp.next[i].fail = p.next[i];
								//ͬʱ����
								break;
							}
							//����ͽ�������
							p = p.fail;
						}
						//������ص����û�ҵ���ͬ���Ӵ�
						if (p == null) {
							//ָ������
							temp.next[i].fail = root;
						}

					}
					//���Ӵ��������
					q[head++] = temp.next[i];
					// q.add(temp.next[i]);
				}
			}
		}
	}

	/**
	 * @Descirbe ��ģƥ������
	 * @Author Hope6537(����)
	 * @param root
	 * @return
	 * @SignDate 2014-6-8����4:24:19
	 * @Version 0.9
	 */
	static int query(Node root) {
		//iѭ���±�cnt��ƥ���ַ������Ӵ�������index�����ַ�������len�����ַ�������
		int i = 0, cnt = 0, index = -1, len = str.length();
		//������ָ��
		Node p = root;
		//���ַ�������ѭ������
		while (i < str.length() && str.charAt(i) != ' ') {
			//������Ϊֹ
			index = str.charAt(i) - 'a';
			//�������p�����ַ�����Ϊֹ��ͬʱp�������������������ݴ�
			while (p.next[index] == null && p != root) {
				//������p��ʧ��ָ�룬���ֵ�������һ����ͬchar�ĵط�
				p = p.fail;
			}
			//ֱ���ҵ�Ϊֹ������û�ҵ�����������
			p = p.next[index];
			p = (p == null ? root : p);
			//ͬʱ�趨���ø�temp
			Node temp = p;
			while (temp != root && temp.count != -1) {
				//���temp������������ʵ�ʵ����ݣ�����count!=1��ʾ�ô�δ�������������Ϊ1����ʾ������ȫƥ��ô���˵����������ƥ�������
				cnt += temp.count;
				//����+1 ��Ϊcount��1�����������ȫƥ�����+0 ��Ϊ��ʱcount����1����0
				temp.count = -1;
				//��������
				temp = temp.fail;
			}
			//��һ���Ӵ�
			i++;
		}
		return cnt;

	}

	public static void main(String[] args) {
		q = new Node[500005];
		int T = s.nextInt();
		while (T-- != 0) {
			Node root = new Node();
			int n = s.nextInt();
			while (n-- != 0) {
				keyWord = s.next();
				insertTire(keyWord, root);
			}
			ac_atuomation(root);
			str = s.next();
			System.out.println(query(root));
		}
	}
}
