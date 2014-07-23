package org.hope6537.datastructs.march;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Describe �Լ���ArrayList��
 * @Author Hope6537(����)
 * @Signdate 2014-3-3����09:09:08
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class MyArrayList implements Iterable<Serializable> {

	
	private static final int DEFAULT_CAPACITY = 10; //Ĭ������Ϊ10
	
	private int theSize; // ���ڵĴ�С
	
	private Serializable [] theItems; // ���� �� data
	
	public MyArrayList() {
		clear();	//���췽��ֱ����յ�ǰ�����ö���,���س�����ʱ����ʹ�õ���Ԫ����
	}
	
	
	public void clear(){
		theSize = 0; //���ڵĴ�С��ֵ����
		ensureCapacity(DEFAULT_CAPACITY);//��Ϊѭ���Ǵ�0ѭ����0 ���Բ�����������
	}
	
	public int size(){
		return theSize; //�������ڵĴ�С����ֵ
	}
	
	public boolean isEmpty(){
		return size() == 0;//���ڵĴ�С����ֵ�Ƿ�Ϊ��
	}
	
	public void trimToSize(){
		//�����ݽṹ��ʽ����������С
		ensureCapacity(size());
	}

	
	public Serializable get(int index){
		if(index<0 || index>= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];
	}
	
	public Serializable set(int index , Serializable newValue){//�滻���±��µ�����data
		if(index<0 || index>= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		Serializable old = theItems[index];
		theItems[index] = newValue;
		return old;
	} 
	
	public void ensureCapacity(int newCapacity){ //���ǵ�����С������MyArrayList������
		if(newCapacity < theSize){
			return; //������ڵ����ݴ�С���ڲ�������Ԥ����ֵ ��ô���ǾͲ�����
		}
		Serializable [] old = theItems; //��ԭ�������ݱ���
		theItems = (Serializable [])new Object[newCapacity]; //��������
		for(int i = 0 ; i<size();i++){
			//Ȼ��ѭ�����������������data
			theItems[i] = old[i];
		}
	}
	
	public void add(int index , Serializable x){// �������±�����һ��Ԫ��x
		if(theItems.length == size()){
			//�������ĳ����Ѿ�����size��С �Ǿ���˵��������
			ensureCapacity(size()*2+1);
			//��������Ҫ��������ķ���������
			//ע�� ��������Ĵ�С������Ĵ�С���������ݽṹ�ġ�
		}
		
		for(int i = theSize ; i> index ; i--){
		//���������ǽ���������������Ԫ�����κ�һλ������װ������
			theItems[i] = theItems[i-1];
		}
		//������װ��
		theItems[index] = x;
		//ͬʱsize�ĳ���+1
		theSize++;
	}
	
	public boolean add(Serializable x){//ֱ���ڶ�β���롣
		add(size(),x);
		return true;
	}
	
	public Serializable remove(int index){
		//ɾ������ָ���±��Ԫ��
		Serializable removedItem = theItems[index];
		for(int i = index ; i < size() -1 ; i++){
			//��Ԫ��ǰ�����հ�
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return removedItem;
	}
	
	public Iterator<Serializable> iterator(){//��ȡ�Լ��ĵ�����
		return new ArrayListIterator(this);
	}
	
	public Iterator<Serializable> iterator_finish(){//��ȡ�Լ��ĵ�����2
		return new ArrayListIterator_Finish();
	}
	
	/**
	 * @Describe ������Ƕ���� ��static �����޸İ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-3-3����10:24:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private static class ArrayListIterator implements Iterator<Serializable>{
		//�Ա�������ڲ���
		
		private int current = 0;//��������ǰ����
		
		private MyArrayList theList;
		
		public ArrayListIterator(MyArrayList list){
			theList = list;
		}
		
		public boolean hasNext(){//�Ƿ�����һ�� ͨ����ǰ������size�Ĵ�С���бȽ��ж�
			return current<theList.size();
		}
		@Override
		public Serializable next() {
			//�����һ�� 
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return theList.theItems[current++];
		}
		@Override
		public void remove() {
			//��ArrayList��remove��������,����this��Ϊ��ȷ��ʹ�õ��ǵ�ǰ����
			theList.remove(--current);
		}
		
		
	}
	
	/**
	 * @Describe ��������Ϊһ����ʽ�ķ����࣬�������������ⲿ�࣬���ⲿ���Ƿ��͵ġ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-3-3����10:31:06
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private class ArrayListIterator_Finish implements Iterator<Serializable>{
		
		
		private int current = 0;//��������ǰ����
		
		
		public boolean hasNext(){//�Ƿ�����һ�� ͨ����ǰ������size�Ĵ�С���бȽ��ж�
			return current<size();
		}
		@Override
		public Serializable next() {
			//�����һ�� 
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return theItems[current++];
		}
		@Override
		public void remove() {
			//��ArrayList��remove��������,����this��Ϊ��ȷ��ʹ�õ��ǵ�ǰ����
			MyArrayList.this.remove(--current);
		}
		
		
	}
	
	
}
