package org.hope6537.datastructs;

import java.util.Scanner;

/**
 * javadoc
 * @Describe AC自动机,多模字符串匹配,搜索引擎,HDOJ2222
 * @From : http://www.cppblog.com/mythit/archive/2009/04/21/80633.html 感激不尽
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-8下午4:05:11
 * @version 0.9
 * @company Changchun University&SHXT
 */

public class HDOJ2222 {
	
	private final static int tire = 26;// 最多仅有26个英文字母 字典树的节点个数

	/**
	 * @Describe 定义序列节点
	 * @Author Hope6537(赵鹏)
	 * @Signdate 2014-6-8下午4:43:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	static class Node {
		Node fail; // 失败搜寻指针
		Node[] next; // Tire每个节点的26个子节点（最多26个字母）
		int count; // 是否为该单词的最后一个子节点

		/**
		 * @Describe 构造方法
		 * @Author Hope6537(赵鹏)
		 * @param
		 */
		public Node() {
			fail = null;
			count = 0;// false
			next = new Node[tire];
		}

	}
	
	/**
	 * @Describe 单词序队列 方便广度优先搜索的构造失败指针
	 */
	static Node[] q;
	/**
	 * @Describe 输入
	 */
	static Scanner s = new Scanner(System.in);
	/**
	 * @Describe 队列的类实现方法
	 */
	// static Queue<Node> q = new LinkedList<Node>();
	/**
	 * @Describe 构造关键字
	 */
	static String keyWord; // 将要输入的关键字
	/**
	 * @Describe 文本
	 */
	static String str;
	/**
	 * @Describe 队列头尾部
	 */
	static int head, tail;

	/**
	 * @Descirbe 构造字典树
	 * @Author Hope6537(赵鹏)
	 * @param str
	 * @param root
	 * @SignDate 2014-6-8下午4:08:54
	 * @Version 0.9
	 */
	static void insertTire(String str, Node root) {
		//首先接受字典树的树根和关键字的字符串
		Node p = root;
		int i = 0, index = -1;
		while (i < str.length() && str.charAt(i) != ' ') {
			//对每个字符进行分析，计算所处位置
			index = str.charAt(i) - 'a';
			//如果当前字典树节点的后续子节点没有这个字符
			if (p.next[index] == null) {
				//创建之
				p.next[index] = new Node();
			}
			//并赋值，同时i++遍历下一个字符
			p = p.next[index];
			i++;
		}
		//相当于true
		p.count++;// 在单词的最后一个节点count+1，代表一个单词的长度
	}

	/**
	 * @Descirbe 构造自动AC机~
	 * @Author Hope6537(赵鹏)
	 * @param root
	 * @SignDate 2014-6-8下午4:19:09
	 * @Version 0.9
	 */
	static void ac_atuomation(Node root) {
		//索引标志，外放。
		int i;
		//定义搜索失败指针
		root.fail = null;
		//将当前的树根推入队列中
		// q.add(root);
		q[head++] = root;
		//如果队列内还有元素
		while (head != tail/* !q.isEmpty() */) {
			//弹出队列
			// Node temp = q.poll();
			Node temp = q[tail++];
			//并获取元素，p代表当前节点的失败指针
			Node p = null;
			//对整个字典树进行遍历搜索
			for (i = 0; i < 26; i++) {
				//如果当前节点有该字符的节点，即有i代表的字符char，不为空，说明可以搜索
				if (temp.next[i] != null) {
					//如果当前节点是本身的树根，那么指向自己
					if (temp == root) {
						temp.next[i].fail = root;
					} else {
						//如果是正常的数据
						p = temp.fail;
						//p指向失败指针
						while (p != null) {
							//如果p不是空就接着循环搜索（广搜）
							if (p.next[i] != null) {
								//如果p的后继节点还匹配到字典树里另外的相同的char的节点，那么将当前（temp）的失败指针指向他
								temp.next[i].fail = p.next[i];
								//同时跳出
								break;
							}
							//否则就接着搜素
							p = p.fail;
						}
						//如果搜素到最后都没找到相同的子串
						if (p == null) {
							//指向树根
							temp.next[i].fail = root;
						}

					}
					//将子串加入队列
					q[head++] = temp.next[i];
					// q.add(temp.next[i]);
				}
			}
		}
	}

	/**
	 * @Descirbe 多模匹配例程
	 * @Author Hope6537(赵鹏)
	 * @param root
	 * @return
	 * @SignDate 2014-6-8下午4:24:19
	 * @Version 0.9
	 */
	static int query(Node root) {
		//i循环下表，cnt是匹配字符串的子串个数，index代表字符索引，len代表字符串长度
		int i = 0, cnt = 0, index = -1, len = str.length();
		//引出个指针
		Node p = root;
		//对字符串进行循环遍历
		while (i < str.length() && str.charAt(i) != ' ') {
			//并计算为止
			index = str.charAt(i) - 'a';
			//如果搜索p的子字符到此为止，同时p还不是树根，而是数据处
			while (p.next[index] == null && p != root) {
				//则搜索p的失败指针，即字典树的另一块相同char的地方
				p = p.fail;
			}
			//直到找到为止，或者没找到返回了树根
			p = p.next[index];
			p = (p == null ? root : p);
			//同时设定引用给temp
			Node temp = p;
			while (temp != root && temp.count != -1) {
				//如果temp不是数根而是实际的数据，而且count!=1表示该串未被搜索过，如果为1还表示我们完全匹配该串，说明我们正在匹配队列中
				cnt += temp.count;
				//个数+1 因为count是1，如果不是完全匹配个数+0 因为此时count不是1而是0
				temp.count = -1;
				//赋搜索过
				temp = temp.fail;
			}
			//下一个子串
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
