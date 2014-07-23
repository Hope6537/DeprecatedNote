package org.hope6537.datastructs.march;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class 链表和线性表的迭代器删除时间对比 {

	public static long returnTime(){
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list1.clear();
		list2.clear();
		
		for(int i = 0; i < 999999 ; i++){
			list1.add(i);
			list2.add(i);
		}
		//初始化完成
		
		ThreadDemo t = new ThreadDemo();
		t.run();
		long f = t.TIME;
		//start
		
		Iterator<Integer> itr = list2.iterator();
		
		while(itr.hasNext()){
			if(itr.next()%2 == 0){
				itr.remove();//在迭代器内移除元素必须使用迭代器方法，不然会异常
			}
		}
		//end
		t.run();
		long e = t.TIME;
		System.out.println(Math.abs(e-f)+"ms");
	}
	
}
