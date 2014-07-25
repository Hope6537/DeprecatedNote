package org.hope6537.thinking_in_java.twenty_one;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @describe ʹ��Callable��Ϊ�߳�����
 * @author Hope6537(����)
 * @signdate 2014��7��25������7:32:26
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class CallableDemo {

	public static void main(String[] args) {
		// ����һ�����ӳ�
		ExecutorService exec = Executors.newCachedThreadPool();
		// Future��Callable���ؽ�����ض����ͽ����˲�����
		// ����ʹ��isDone������ѯFuture�Ƿ��Ѿ���� ��������ɺ� �����һ��������get()���յ���һ�����
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskResult(i)));
		}
		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} catch (Exception e) {
				System.out.println(e);
				return;
			} finally {
				exec.shutdown();
			}
		}
	}

}

class TaskResult implements Callable<String> {

	private int id;

	public TaskResult(int id) {
		super();
		this.id = id;
	}

	// �������в�������ֵ
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult" + id;
	}

}