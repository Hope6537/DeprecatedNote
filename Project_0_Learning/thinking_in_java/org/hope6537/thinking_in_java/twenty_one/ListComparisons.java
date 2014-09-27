package org.hope6537.thinking_in_java.twenty_one;

//: concurrency/ListComparisons.java
//{Args: 1 10 10} (Fast verification check during build)
//Rough comparison of thread-safe List performance.
import java.util.concurrent.*;
import java.util.*;

import org.hope6537.thinking_in_java.seventeen.CountingIntegerList;

abstract class ListTest extends Tester<List<Integer>> {
	ListTest(String testId, int nReaders, int nWriters) {
		super(testId, nReaders, nWriters);
	}

	class Reader extends TestTask {
		long result = 0;

		void test() {
			for (long i = 0; i < testCycles; i++)
				for (int index = 0; index < containerSize; index++)
					result += testContainer.get(index);
		}

		void putResults() {
			readResult += result;
			readTime += duration;
		}
	}

	class Writer extends TestTask {
		void test() {
			for (long i = 0; i < testCycles; i++)
				for (int index = 0; index < containerSize; index++)
					testContainer.set(index, writeData[index]);
		}

		void putResults() {
			writeTime += duration;
		}
	}

	void startReadersAndWriters() {
		for (int i = 0; i < nReaders; i++)
			exec.execute(new Reader());
		for (int i = 0; i < nWriters; i++)
			exec.execute(new Writer());
	}
}

class SynchronizedArrayListTest extends ListTest {
	List<Integer> containerInitializer() {
		return Collections.synchronizedList(new ArrayList<Integer>(
				new CountingIntegerList(containerSize)));
	}

	SynchronizedArrayListTest(int nReaders, int nWriters) {
		super("Synched ArrayList", nReaders, nWriters);
	}
}

class CopyOnWriteArrayListTest extends ListTest {
	List<Integer> containerInitializer() {
		return new CopyOnWriteArrayList<Integer>(new CountingIntegerList(
				containerSize));
	}

	CopyOnWriteArrayListTest(int nReaders, int nWriters) {
		super("CopyOnWriteArrayList", nReaders, nWriters);
	}
}

/**
 * @describe 乐观锁和传统锁的实例测试
 * @author Hope6537(赵鹏)
 * @signdate 2014年8月16日下午6:40:28
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class ListComparisons {
	public static void main(String[] args) {
		Tester.initMain(args);
		new SynchronizedArrayListTest(10, 0);
		new SynchronizedArrayListTest(9, 1);
		new SynchronizedArrayListTest(5, 5);
		new CopyOnWriteArrayListTest(10, 0);
		new CopyOnWriteArrayListTest(9, 1);
		new CopyOnWriteArrayListTest(5, 5);
		Tester.exec.shutdown();
	}
}
