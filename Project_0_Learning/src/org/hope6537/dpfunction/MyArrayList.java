package org.hope6537.dpfunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Describe ����������ʹ��˳��洢�ṹ�����Ա�
 * @Author Hope6537(����)
 * @Signdate 2014��5��8��10:15:22
 * @version 0.9
 * @company Changchun University&SHXT
 */
//�����ﶨ�巺�� �Ӷ������������� <AnyType>
public class MyArrayList<AnyType> implements Iterable<AnyType> {
	
	//Ĭ������Ϊ10
	private static final int DEFAULT_CAPACITY = 10; 
	//���ڵ����ݵĸ���
	private int theSize; 
	//���ݵĴ洢��������
	private AnyType [] theItems; 
	//Ĭ�Ϲ��췽��
	/**
	 * @Describe Ĭ�Ϲ��췽��
	 * @Author Hope6537(����)
	 * @param 
	 */
	public MyArrayList() {
		//���췽��ֱ����յ�ǰ�����ö���,���س�����ʱ����ʹ�õ���Ԫ����
		clear();	
	}
	/**
	 * @Descirbe �������������
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2014-5-8����10:17:11
	 * @Version 0.9
	 */
	public void clear(){
		//���ڵĴ�С��ֵ����
		theSize = 0; 
		//��Ϊѭ���Ǵ�0ѭ����0 ���Բ�����������
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	/**
	 * @Descirbe ���ص�ǰ�����ݸ���
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-5-8����10:17:27
	 * @Version 0.9
	 */
	public int size(){
		return theSize; //�������ڵĴ�С����ֵ
	}
	
	/**
	 * @Descirbe �ж��Ƿ�Ϊ��(����NULL)
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-5-8����10:17:36
	 * @Version 0.9
	 */
	public boolean isEmpty(){
		return size() == 0;//���ڵĴ�С����ֵ�Ƿ�Ϊ��
	}
	
	/**
	 * @Descirbe �����û��Ĺ�����չ�ռ�ķ���
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2014-5-8����10:17:49
	 * @Version 0.9
	 */
	public void trimToSize(){
		//�����ݽṹ��ʽ����������С
		ensureCapacity(size());
	}

	
	/**
	 * @Descirbe ��ȡindex�±��µ�Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param index �����±�
	 * @Params @return
	 * @SignDate 2014-5-8����10:18:08
	 * @Version 0.9
	 */
	public AnyType get(int index){
		if(index<0 || index>= size()){
			//�������ֵ���Ϸ� �׳�����Խ���쳣
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];
	}
	
	/**
	 * @Descirbe ���������������û��޸�index�±��µ�ֵ,�����ر��滻��ֵ
	 * @Author Hope6537(����)
	 * @Params @param index �±�
	 * @Params @param newValue ��ֵ
	 * @Params @return
	 * @SignDate 2014-5-8����10:18:55
	 * @Version 0.9
	 */
	public AnyType set(int index , AnyType newValue){//�滻���±��µ�����data
		if(index<0 || index>= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType old = theItems[index];
		theItems[index] = newValue;
		return old;
	} 
	
	/**
	 * @Descirbe ������������ݲ����������Ա����ӳ���
	 * @Author Hope6537(����)
	 * @Params @param newCapacity �µĳ���
	 * @SignDate 2014-5-8����10:19:49
	 * @Version 0.9
	 */
	public void ensureCapacity(int newCapacity){ 
		//���ǵ�����С������MyArrayList������
		if(newCapacity < theSize){
			return; //������ڵ����ݴ�С���ڲ�������Ԥ����ֵ ��ô���ǾͲ�����
		}
		AnyType [] old = theItems; //��ԭ�������ݱ���
		theItems = (AnyType[])new Object[newCapacity]; //����������
		for(int i = 0 ; i<size();i++){
			//Ȼ��ѭ�����������������data
			theItems[i] = old[i];
		}
	}
	
	/**
	 * @Descirbe ��index������һ���µ�Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param index ����λ��
	 * @Params @param x ��Ԫ�ض���
	 * @SignDate 2014-5-8����10:20:30
	 * @Version 0.9
	 */
	public void add(int index , AnyType x){// �������±�����һ��Ԫ��x
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
	
	/**
	 * @Descirbe β�巨
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-5-8����10:21:14
	 * @Version 0.9
	 */
	public boolean add(AnyType x){//ֱ���ڶ�β���롣
		add(size(),x);
		return true;
	}
	
	/**
	 * @Descirbe ɾ��ָ���±��µ�Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param index
	 * @Params @return
	 * @SignDate 2014-5-8����10:21:19
	 * @Version 0.9
	 */
	public AnyType remove(int index){
		//ɾ������ָ���±��Ԫ��
		AnyType removedItem = theItems[index];
		for(int i = index ; i < size() -1 ; i++){
			//��Ԫ��ǰ�����հ�
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return removedItem;
	}
	
	public Iterator<AnyType> iterator(){//��ȡ�Լ��ĵ�����
		return new ArrayListIterator(this);
	}
	
	public Iterator<AnyType> iterator_finish(){
		//��ȡ�û��Լ����Զ��������
		return new ArrayListIterator_Finish();
	}
	
	
	
	@Override
	public String toString() {
		return "MyArrayList [theItems="
				+ Arrays.toString(theItems) + "]";
	}



	/**
	 * @Describe ������Ƕ���� ��static �����޸İ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-5-8����11:14:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private static class ArrayListIterator<AnyType> implements Iterator<AnyType>{
		//�Ա�������ڲ���
		
		private int current = 0;//��������ǰ����
		
		private MyArrayList<AnyType> theList;
		
		public ArrayListIterator(MyArrayList<AnyType> list){
			theList = list;
		}
		
		public boolean hasNext(){//�Ƿ�����һ�� ͨ����ǰ������size�Ĵ�С���бȽ��ж�
			return current<theList.size();
		}
		@Override
		public AnyType next() {
			//�����һ�� 
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return (AnyType) theList.theItems[current++];
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
	 * @Signdate 2014-5-8����14:31:06
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	private class ArrayListIterator_Finish implements Iterator<AnyType>{
		
		
		private int current = 0;//��������ǰ����
		
		
		public boolean hasNext(){//�Ƿ�����һ�� ͨ����ǰ������size�Ĵ�С���бȽ��ж�
			return current<size();
		}
		@Override
		public AnyType next() {
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
	public static void main(String[] args) {
		//���� ��Ӳ����
		MyArrayList<String> arrayList = new MyArrayList<String>();
		arrayList.add("abc");
		arrayList.add("bcd");
		arrayList.add("def");
		for(int i = 0 ; i < arrayList.size() ; i++){
			System.out.println(arrayList.get(i));
		}
		//ɾ��Ԫ��
		arrayList.remove(1);
		System.out.println("-------");
		for(int i = 0 ; i < arrayList.size() ; i++){
			System.out.println(arrayList.get(i));
		}
		//�޸�ĳ��������Ԫ��
		arrayList.set(0, "xxx");
		System.out.println("-------");
		for(int i = 0 ; i < arrayList.size() ; i++){
			System.out.println(arrayList.get(i));
		}
	}
	
}
