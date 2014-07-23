package org.hope6537.datastructs.march;
//language : JAVA
/**
 * @Describe 数据结构作业 根据线程选猴王
 * @Author Hope6537(赵鹏 041240827)
 * @Signdate 2014-3-17下午07:48:25
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HomeWorkDemo {

	public static void main(String[] args) {
		//自制链表 源代码在MyLinkedlist类内 泛型为数字以表示猴子
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		//从1到13依次添加
		for (int i = 1; i < 13; i++) {
			list.add(i);
		}
		//Runnable 接口初始化 线程初始化 链表初始化
		ThreadsDemo td = new ThreadsDemo();
		ThreadsDemo.setList(list);
		Thread t = new Thread(td);
		//如果list内还有内容
		while(!ThreadsDemo.getLast()){
			try {
				//接着删除
				t.run();
				//然后等5000毫秒 即5秒
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadsDemo implements Runnable {
	//私有list变量
	private static MyLinkedList<Integer> list = new MyLinkedList<Integer>();
	//判断是否为最后一位
	private static boolean isLast = false;
	//run方法重写
	public void run() {
		//非空且为多个
		if (list != null && list.size() > 1) {
			//随机出一个索引
			int randomindex = (int) (Math.random() * (list.size()));
			System.out.println("要被移除的猴子是第" + (list.get(randomindex)) + "只");
			//删除这个节点
			list.remove(randomindex);

		} else if (list == null) {
			System.out.println("空表");
			isLast= true;
		} else {
			System.out.println("剩下的猴子是第" + list.get(0) + "只");
			isLast= true;
		}
	}

	public static MyLinkedList<Integer> getList() {
		return list;
	}

	public static void setList(MyLinkedList<Integer> list) {
		ThreadsDemo.list = list;
	}

	public static boolean getLast() {
		return isLast;
	}

	public static void setLast(boolean isLast) {
		ThreadsDemo.isLast = isLast;
	}
	
}
