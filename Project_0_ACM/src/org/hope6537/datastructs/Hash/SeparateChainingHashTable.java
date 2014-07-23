package org.hope6537.datastructs.Hash;

import java.util.LinkedList;
import java.util.List;

/**
 * @Describe �������ӷ�ɢ�б�
 * @Author Hope6537(����)
 * @Signdate 2014-4-3����07:29:27
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class SeparateChainingHashTable<AnyType> {
	/**
	 * @Describe ��ĳ�ʼ����
	 */
	private static final int DEFAULT_TABLE_SIZE = 100;

	/**
	 * @Describe ɢ�б�����ΪԪ�ش��ڵ���������鼯��
	 */
	private List<AnyType>[] theLists;

	/**
	 * @Describe ��ǰɢ�б���Ԫ�صĸ���
	 */
	private int currentSize;

	/**
	 * @Descirbe ���ɸõ�ԪԪ�ص�Hashֵ�����ڴ洢
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-3����07:31:59
	 * @Version 0.9
	 * @return
	 */
	private int myHash(AnyType x) {
		int hashVal = x.hashCode();
		hashVal %= theLists.length;
		if (hashVal < 0) {
			hashVal += theLists.length;
		}
		return hashVal;
	}

	/**
	 * @Descirbe ��ո�ɢ�б���㷨
	 * @Author Hope6537(����)
	 * @Params
	 * @SignDate 2014-4-3����07:35:41
	 * @Version 0.9
	 */
	public void makeEmpty() {
		for (int i = 0; i < theLists.length; i++) {
			theLists[i].clear();
		}
		currentSize = 0;
	}

	public SeparateChainingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {
		theLists = new LinkedList[nextPrime(size)];//����һ����������
		for (int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<AnyType>();//��ÿ��������г�ʼ�� 
		}
	}
	
	

	/**
	 * @Descirbe �õ�n֮�����һ������
	 * @Author Hope6537(����)
	 * @Params @param n
	 * @Params @return
	 * @SignDate 2014-4-3����07:42:07
	 * @Version 0.9
	 * @param n
	 * @return
	 */
	private static int nextPrime(int n) {
		if (n % 2 == 0) {//���ȼ���Ƿ��ܱ�2����������ǵĻ���ֱ�Ӹ�+1
			n++;
		}

		for (; !isPrime(n); n += 2)//Ȼ������ѭ���� �������� ����Ļ���n+2����
			;

		return n;
	}
	
	/**
	 * @Descirbe ����Ƿ�������
	 * @Author Hope6537(����)
	 * @Params @param n
	 * @Params @return
	 * @SignDate 2014-4-3����07:42:18
	 * @Version 0.9
	 * @param n
	 * @return
	 */
	private static boolean isPrime(int n) {
		if (n == 2 || n == 3){
			return true;
		}
		if (n == 1 || n % 2 == 0){
			return false;
		}
		//������̫����

		for (int i = 3; i * i <= n; i += 2){//�۰�ѭ������,���ڹ�������sqrt n ֮ǰ������ڵĻ����Ϳ��Խ�ʡһ��ʱ��
			if (n % i == 0){
				return false;
			}	
		}

		return true;
	}
	
	/**
	 * @Descirbe ����xԪ����ɢ�б����Ƿ����
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-4-3����07:46:29
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	public boolean contains(AnyType x){
		List<AnyType>whichList = theLists[myHash(x)];
		return whichList.contains(x);
	}
	/**
	 * @Descirbe ��x��ӽ�ɢ�б�
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @SignDate 2014-4-3����07:48:48
	 * @Version 0.9
	 * @param x
	 */
	public void insert(AnyType x){
		List<AnyType> whichList = theLists[myHash(x)];
		if(!whichList.contains(x)){
			whichList.add(x);
		}
		if(++currentSize>theLists.length){
			rehash();
		}
		
	}
	
	/**
	 * @Descirbe ɢ�б��ڿռ䲻��ʱ���¹��첢hash��
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2014-4-3����07:50:55
	 * @Version 0.9
	 */
	@SuppressWarnings("unchecked")
	private void rehash() {
		List<AnyType> [] oldLists = theLists;
		theLists = new List[nextPrime(2*theLists.length)];
		for(int j = 0 ; j < theLists.length ; j++ ){
			theLists[j] = new LinkedList<AnyType>();
		}
		currentSize = 0;
		
		for(int i = 0 ; i < oldLists.length ; i++){
			for(AnyType x : oldLists[i]){
				insert(x);
			}
		}
	}
	
	/**
	 * @Descirbe ��ɢ�б���ɾ����x
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @SignDate 2014-4-3����07:51:41
	 * @Version 0.9
	 * @param x
	 */
	public void remove(AnyType x){
		List<AnyType> whichList = theLists[myHash(x)];
		if(!whichList.contains(x)){
			whichList.remove(x);
			currentSize--;
		}
	}
}
