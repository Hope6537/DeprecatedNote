package org.hope6537.dpfunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @Describe 带迭代器的使用顺序存储结构的线性表改编而成的栈
 * @Author Hope6537(赵鹏)
 * @Signdate 2014年5月9日10:15:22
 * @version 0.9
 * @company Changchun University&SHXT
 */
// 在这里定义泛型 从而决定容器类型 <AnyType>
public class MyStack<AnyType> implements Iterable<AnyType> {

	// 默认容量为10
	private static final int DEFAULT_CAPACITY = 10;
	// 现在的数据的个数
	private int theSize;
	// 数据的存储容器数组
	private AnyType[] theItems;

	// 默认构造方法
	/**
	 * @Describe 默认构造方法
	 * @Author Hope6537(赵鹏)
	 * @param
	 */
	public MyStack() {
		// 构造方法直接清空当前被调用对象,返回出来的时候是使用的无元素体
		clear();
	}

	/**
	 * @Descirbe 用于清空整个栈
	 * @Author Hope6537(赵鹏)
	 * @Params
	 * @SignDate 2014-5-8上午10:17:11
	 * @Version 0.9
	 */
	public void clear() {
		// 现在的大小数值清零
		theSize = 0;
		// 因为循环是从0循环到0 所以不存在数据了
		ensureCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * @Descirbe 返回当前的数据个数
	 * @Author Hope6537(赵鹏)
	 * @Params @return
	 * @SignDate 2014-5-8上午10:17:27
	 * @Version 0.9
	 */
	public int size() {
		return theSize; // 返回现在的大小的数值
	}

	/**
	 * @Descirbe 判断是否为空(不是NULL)
	 * @Author Hope6537(赵鹏)
	 * @Params @return
	 * @SignDate 2014-5-8上午10:17:36
	 * @Version 0.9
	 */
	public boolean isEmpty() {
		return size() == 0;// 现在的大小的数值是否为零
	}

	/**
	 * @Descirbe 给予用户的公共拓展空间的方法
	 * @Author Hope6537(赵鹏)
	 * @Params
	 * @SignDate 2014-5-8上午10:17:49
	 * @Version 0.9
	 */
	public void trimToSize() {
		// 将数据结构格式化到参数大小
		ensureCapacity(size());
	}

	/**
	 * @Descirbe 出栈
	 * @Author Hope6537(赵鹏)
	 * @Params @return
	 * @SignDate 2014-5-9上午10:42:55
	 * @Version 0.9
	 */
	public AnyType pop() {
		int index = size()-1;
		if (index < 0 || index >= size()) {
			// 如果索引值不合法 抛出数组越界异常
			throw new ArrayIndexOutOfBoundsException();
		}
		theSize = index;
		return theItems[index];

	}

	/**
	 * @Descirbe 对数组进行扩容操作以让线性表增加长度
	 * @Author Hope6537(赵鹏)
	 * @Params @param newCapacity 新的长度
	 * @SignDate 2014-5-8上午10:19:49
	 * @Version 0.9
	 */
	public void ensureCapacity(int newCapacity) {
		// 这是调整大小并复制MyArrayList的内容
		if (newCapacity < theSize) {
			return; // 如果现在的数据大小大于参数给的预备数值 那么我们就不受理
		}
		AnyType[] old = theItems; // 将原来的数据备份
		theItems = (AnyType[]) new Object[newCapacity]; // 声明新数组
		for (int i = 0; i < size(); i++) {
			// 然后循环迭代这里面的数据data
			theItems[i] = old[i];
		}
	}

	/**
	 * @Descirbe 在index处插入一个新的元素
	 * @Author Hope6537(赵鹏)
	 * @Params @param index 插入位置
	 * @Params @param x 新元素对象
	 * @SignDate 2014-5-8上午10:20:30
	 * @Version 0.9
	 */
	private void add(int index, AnyType x) {// 从索引下表处插入一个元素x
		if (theItems.length == size()) {
			// 如果数组的长度已经等于size大小 那就是说不够用了
			ensureCapacity(size() * 2 + 1);
			// 所以我们要调用上面的方法来扩容
			// 注意 我们扩大的大小是数组的大小，不是数据结构的。
		}

		for (int i = theSize; i > index; i--) {
			// 接下来就是讲从索引处到最后的元素依次后串一位，用来装新数据
			theItems[i] = theItems[i - 1];
		}
		// 新数据装入
		theItems[index] = x;
		// 同时size的长度+1
		theSize++;
	}

	/**
	 * @Descirbe 压数据进栈
	 * @Author Hope6537(赵鹏)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-5-8上午10:21:14
	 * @Version 0.9
	 */
	public boolean push(AnyType x) {// 直接在队尾插入。
		add(size(), x);
		return true;
	}

	public Iterator<AnyType> iterator() {// 获取自己的迭代器
		return new ArrayListIterator(this);
	}

	@Override
	public String toString() {
		return "MyArrayList [theItems=" + Arrays.toString(theItems) + "]";
	}

	/**
	 * @Describe 迭代器嵌套类 有static 第三修改版
	 * @Author Hope6537(赵鹏)
	 * @Signdate 2014-5-8下午11:14:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private static class ArrayListIterator<AnyType> implements
			Iterator<AnyType> {
		// 自编迭代器内部类

		private int current = 0;// 迭代器当前索引

		private MyStack<AnyType> theList;

		public ArrayListIterator(MyStack<AnyType> list) {
			theList = list;
		}

		public boolean hasNext() {// 是否有下一个 通过当前索引和size的大小进行比较判断
			return current < theList.size();
		}

		@Override
		public AnyType next() {
			// 输出下一个
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (AnyType) theList.theItems[current++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		// 测试，入栈并出栈
		MyStack<String> stack = new MyStack<String>();
		stack.push("abc");
		stack.push("bcd");
		stack.push("def");
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		MyStack<Integer> stack2 = new MyStack<Integer>();
		while(num != 0){
			int in = num % 8;
			stack2.push(in);
			num = num/8;
		}
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop());
		}
		System.out.println();
		
	}

}
