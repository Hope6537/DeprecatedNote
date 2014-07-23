package org.hope6537.datastructs.march;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Describe �Ա�LinkedList
 * @Author Hope6537(����)
 * @Signdate 2013-10-27����07:26:32
 * @version 0.9
 * @company Changchun University&SHXT
 */
@SuppressWarnings("hiding")
public class MyLinkedList<Object> implements Iterable<Object> {
	
	private int theSize;
	
	private int modCount = 0;
	
	/**
	 * @Describe ͷ��� ����ʶ�𲢴�ͷ����
	 */
	private Node<Object> beginMarker;
	
	/**
	 * @Describe β��� ����ʶ�𲢴�β����
	 */
	private Node<Object> endMarker;
	
	/**
	 * @Describe �ڲ���Node �ڵ�Ľṹ
	 * @Author Hope6537(����)
	 * @Signdate 2013-10-27����07:26:42
	 * @version 0.9
	 * @company Changchun University&SHXT
	 * @param <Object>
	 */
	private static class Node<Object>{
		
		/**
		 * @Describe ���췽�� �ֱ��Ϊ������
		 * @Author Hope6537(����)
		 * @param @param d ����
		 * @param @param p ǰָ��
		 * @param @param n ��ָ��
		 */
		public Node (Object d , Node<Object> p , Node<Object> n) {
			data = d;
			prev = p;
			next = n;
		}
		public Object data;
		public Node<Object> prev;
		public Node<Object> next;
	}

	public MyLinkedList() {
		clear();
	}
	
	/**
	 * @Descirbe �������
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2013-10-27����07:27:18
	 * @Version 0.9
	 */
	public void clear(){
		beginMarker = new Node<Object>(null, null, null);
		endMarker = new Node<Object>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount ++ ;
	}
	
	/**
	 * @Descirbe �������� 
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2013-10-27����07:27:30
	 * @Version 0.9
	 * @return
	 */
	public int size(){
		return theSize;		
	}
	/**
	 * @Descirbe ���������ж��Ƿ�Ϊ��  
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2013-10-27����07:27:39
	 * @Version 0.9
	 * @return
	 */
	public boolean isEmpty(){
		return size()==0;
	}
	/**
	 * @Descirbe ֱ�Ӵ�ƨ�ɺ������ 
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2013-10-27����07:27:58
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	public boolean add(Object x){
		add(size(),x);
		return true;
	}
	/**
	 * @Descirbe ������λ�ý�ԭ�ڵ���һ��Ȼ�����������
	 * @Author Hope6537(����)
	 * @Params @param index
	 * @Params @param x
	 * @SignDate 2013-10-27����07:28:12
	 * @Version 0.9
	 * @param index
	 * @param x
	 */
	public void add(int index , Object x){
		addBefore(getNode(index),x);
	}
	
	/**
	 * @Descirbe ��������� �Ӹýڵ��ǰ�� 
	 * @Author Hope6537(����)
	 * @Params @param p
	 * @Params @param x
	 * @SignDate 2013-10-27����07:28:41
	 * @Version 0.9
	 * @param p
	 * @param x
	 */
	private void addBefore(Node<Object> p , Object x){
		//��Ŀ��֮ǰ�����µ�������Ŀ
		Node<Object> newNode = new Node<Object>(x, p.prev, p);
		//���ȴ���һ���µĽڵ� p��Ҫ����ĵط��ľɽڵ㣬λ���½ڵ�֮������������x��ǰ�ڵ�p��ԭ����ǰ�ڵ㣬��ڵ���p
		newNode.prev.next = newNode;
		//Ȼ���½ڵ��ǰ�ڵ�Ҳ����ԭ��p��ǰ�ڵ�ĺ�ָ��ָ���½ڵ㡣
		p.prev = newNode;
		//Ȼ��p�ڵ��ǰָ��ָ���ڵ㡣
		theSize++;//��С+1
		modCount++;//�������+1
	}
	/**
	 * @Descirbe ͨ�������õ��ڵ�ķ���
	 * @Author Hope6537(����)
	 * @Params @param index
	 * @Params @return
	 * @SignDate 2013-10-27����07:29:00
	 * @Version 0.9
	 * @param index
	 * @return
	 */
	private Node<Object> getNode(int index){
		//�����ڲ���˽�еĵõ��ڵ�ķ���
		Node<Object> p;
		if(index<0||index>size()){
			//�������Խ��
			throw new IndexOutOfBoundsException();
		}
		if(index < size()/2 ){
			//���������ǰ�벿��,�ʹ�ͷ��ʼ����
			p = beginMarker.next;
			for(int i = 0 ; i < index ; i++){
				p = p.next;
			}
		}
		else{
			//��������Ӻ�벿�֣��ʹ�β����ʼ����
			p = endMarker;
			for(int i = size() ; i> index ; i--){
				p = p.prev;
			}
		}
		return p;
	}
	
	/**
	 * @Descirbe ���ڵ�p���������Ƴ�,�����ظ��������
	 * @Author Hope6537(����)
	 * @Params @param p
	 * @Params @return
	 * @SignDate 2013-10-27����07:29:57
	 * @Version 0.9 
	 * @param p
	 * @return
	 */
	private Object remove(Node<Object> p){
		//p�ĺ�ڵ��ǰָ��ָ��p��ǰһ��
		p.next.prev = p.prev;
		//p��ǰ�ڵ�ĺ�ָ��ָ��p�ĺ�һ��
		p.prev.next = p.next;
		theSize--;
		modCount--;
		
		return p.data;
	}
	
	
	/**
	 * @Descirbe ͨ��������������
	 * @Author Hope6537(����)
	 * @Params @param index
	 * @Params @return
	 * @SignDate 2013-10-27����07:32:30
	 * @Version 0.9
	 * @param index
	 * @return
	 */
	public Object get(int index){
		return getNode(index).data;
	}
	
	/**
	 * @Descirbe ͨ������ֵ�����ĵ�ǰ�ڵ������ 
	 * @Author Hope6537(����)
	 * @Params @param index
	 * @Params @param newValue
	 * @Params @return
	 * @SignDate 2013-10-27����07:33:39
	 * @Version 0.9
	 * @param index
	 * @param newValue
	 * @return
	 */
	public Object set(int index,Object newValue){
		Node<Object> p = getNode(index);
		Object oldValue = p.data;
		p.data = newValue;
		return oldValue;
	}
	
	public Object remove(int index){
		return remove(getNode(index));
	}

	@Override
	public Iterator<Object> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Object>{
		
		
		private Node<Object> current = beginMarker.next;
		
		private int expectedModCount = modCount;
		
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			//�������ָ��ָ��������β��㡣��ô�Ƿ���û����һ����
			return current != endMarker;
			
		}

		@Override
		public Object next() {
			if(modCount != expectedModCount){
				//�������ĸ��Ĵ����͵�ǰ�������ڼ�¼�Ĳ����ϣ���ô˵����������Ч
				throw new ConcurrentModificationException();
			}
			if(!hasNext()){
				//���û����һ����
				throw new NoSuchElementException();
			}
			//��ȡ��ǰ������ָ���ָ��Ľ�������
			Object nextItem = current.data;
			//ͬʱ��������
			current = current.next;
			//ͬʱ������������Ѿ����ƶ���ͷ���֮���ˣ����Ա��Ƴ�
			okToRemove = true;
			//��������
			return nextItem;
			
		}

		@Override
		public void remove() {	
			
			if(modCount != expectedModCount){
				//�������ĸ��Ĵ����͵�ǰ�������ڼ�¼�Ĳ����ϣ���ô˵����������Ч
				throw new ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			//ע������Ϊ�β���current�����ԭ����Ϊ��ʱ����ָ���Ѿ���Ϊnext�������ˣ������ǿ�����������ָ��ǰ��֮ǰ�����ݣ�����Ҫprev 
			MyLinkedList.this.remove(current.prev);
			okToRemove=false;
			expectedModCount++;
		
		}
		
	}
	
}
