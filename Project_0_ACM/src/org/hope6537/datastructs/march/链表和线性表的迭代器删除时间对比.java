package org.hope6537.datastructs.march;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class ��������Ա�ĵ�����ɾ��ʱ��Ա� {

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
		//��ʼ�����
		
		ThreadDemo t = new ThreadDemo();
		t.run();
		long f = t.TIME;
		//start
		
		Iterator<Integer> itr = list2.iterator();
		
		while(itr.hasNext()){
			if(itr.next()%2 == 0){
				itr.remove();//�ڵ��������Ƴ�Ԫ�ر���ʹ�õ�������������Ȼ���쳣
			}
		}
		//end
		t.run();
		long e = t.TIME;
		System.out.println(Math.abs(e-f)+"ms");
	}
	
}
