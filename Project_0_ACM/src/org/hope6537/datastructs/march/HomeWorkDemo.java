package org.hope6537.datastructs.march;
//language : JAVA
/**
 * @Describe ���ݽṹ��ҵ �����߳�ѡ����
 * @Author Hope6537(���� 041240827)
 * @Signdate 2014-3-17����07:48:25
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HomeWorkDemo {

	public static void main(String[] args) {
		//�������� Դ������MyLinkedlist���� ����Ϊ�����Ա�ʾ����
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		//��1��13�������
		for (int i = 1; i < 13; i++) {
			list.add(i);
		}
		//Runnable �ӿڳ�ʼ�� �̳߳�ʼ�� �����ʼ��
		ThreadsDemo td = new ThreadsDemo();
		ThreadsDemo.setList(list);
		Thread t = new Thread(td);
		//���list�ڻ�������
		while(!ThreadsDemo.getLast()){
			try {
				//����ɾ��
				t.run();
				//Ȼ���5000���� ��5��
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadsDemo implements Runnable {
	//˽��list����
	private static MyLinkedList<Integer> list = new MyLinkedList<Integer>();
	//�ж��Ƿ�Ϊ���һλ
	private static boolean isLast = false;
	//run������д
	public void run() {
		//�ǿ���Ϊ���
		if (list != null && list.size() > 1) {
			//�����һ������
			int randomindex = (int) (Math.random() * (list.size()));
			System.out.println("Ҫ���Ƴ��ĺ����ǵ�" + (list.get(randomindex)) + "ֻ");
			//ɾ������ڵ�
			list.remove(randomindex);

		} else if (list == null) {
			System.out.println("�ձ�");
			isLast= true;
		} else {
			System.out.println("ʣ�µĺ����ǵ�" + list.get(0) + "ֻ");
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
