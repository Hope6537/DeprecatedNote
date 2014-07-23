package org.hope6537.datastructs.Heap;


/**
 * @Describe ���ֶ�
 * @Author Hope6537(����)
 * @Signdate 2014-4-5����01:12:45
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <AnyType>
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
	private static final int DEFAULT_CAPACITY = 10;

	private int currentSize;

	private AnyType[] array;

	/**
	 * @Describe Ĭ��Ϊ�յĹ��캯��
	 * @Author Hope6537(����)
	 * @param
	 */
	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * @Describe ����С�Ĺ��캯�� ����Ϊ��
	 * @Author Hope6537(����)
	 * @param @param capacity
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {
		currentSize = 0;
		array = (AnyType[]) new Comparable[capacity + 1];
	}
	
	
	/**
	 * @Descirbe ��Ԫ��x��������� ���˲���
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @SignDate 2014-4-5����01:21:29
	 * @Version 0.9
	 * @param x
	 */
	public void insert(AnyType x){
		if(currentSize == array.length-1){
			enlargeArray(array.length * 2+1); // ����������� ��ô�ع�
		}
		int hole = ++currentSize;//ͬʱ��currentSize+1��ȷ����Ŀ��ͬʱ��hole����Ϊβ����������ǰԪ������
		for(;hole>1&&x.compareTo(array[hole/2])<0;hole = hole/2){
			 //��x��array[hole/2]���жԱ� ����x��ÿ��λ��������ĸ��ڵ����Compare�Ƚ�
			array[hole] = array[hole/2];
			//���xС�ڸ��ڵ㣬������ 
		}
		//��ʱѭ������ ��˵���ҵ�λ�� ����play~ ���׳�����
		array[hole] = x;
	}

	/**
	 * @Descirbe ��������ع�
	 * @Author Hope6537(����)
	 * @Params @param newSize
	 * @SignDate 2014-4-5����01:16:26
	 * @Version 0.9
	 * @param newSize
	 */
	@SuppressWarnings("unchecked")
	private void enlargeArray(int newSize) {
		AnyType[] old = array;
		array = (AnyType[]) new Comparable[newSize];
		for (int i = 0; i < old.length; i++)
			array[i] = old[i];
	}
	
	/**
	 * @Descirbe ����
	 * @Author Hope6537(����)
	 * @Params @param hole
	 * @SignDate 2014-4-5����03:27:46
	 * @Version 0.9
	 * @param hole
	 */
	private void percolateDown(int hole){
		int child; // ����child ������ӽڵ������
		AnyType tmp = array[hole]; //����ǰhole�ڵ�����ݱ������� ��ԭʼ����lastԪ�ص�ֵ
		
		for(;hole*2<=currentSize;hole = child){//���hole���ӽڵ����
			child = hole * 2;//�����ѭ�� ͬʱ��child��ֵ
			if(child!=currentSize && array[child+1].compareTo(array[child])<0){
				//���child���ҽڵ�ͬʱ�ҽڵ�С����ڵ�
				child ++;
				//��ô����ֵ�仯 ����Ҷ��ӽڵ� 
			}
			if(array[child].compareTo(tmp)<0){
				//������ӽڵ�С�ڸ��ڵ� �����ڵ㻻���� ���ӽڵ���Ϊ�µĸ�
				array[hole] = array[child];
			}
			else{
				//������ͬ���߸���С�ڶ��ӵĻ����� 
				break;
			}
		}
		array[hole] = tmp;
	}
	
	/**
	 * @Descirbe ��ǰ������Ƿ�Ϊ��
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����03:37:58
	 * @Version 0.9
	 * @return
	 */
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	/**
	 * @Descirbe ��������Сֵȡ�� ͬʱ����������������
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����03:30:50
	 * @Version 0.9
	 * @return
	 */
	public AnyType deleteMin(){
		if(isEmpty()){
			//���Ϊ�� ֱ�ӷ���null
			return null;
		}
		//���� �ҵ���ǰ����������������
		AnyType minItem = findMin();
		//��array�����ڵ���ڸ���
		array[1] = array[currentSize--];
		//Ȼ��������˲��� ʵ���Ͼ����Ѿ�ȡ���˸� �������������кϲ�
		percolateDown(1);
		//������С�ڵ�
		return minItem;
	}

	/**
	 * @Descirbe ���ص�ǰ���ȶ��У��ѣ������� ����˵������
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����03:30:30
	 * @Version 0.9
	 * @return
	 */
	private AnyType findMin() {
		if( isEmpty( ) ){
            return null;
		}
        return array[ 1 ];
	}
	
	/**
	 * @Descirbe ����ÿ�����ӽڵ�Ľڵ� ���ж�������
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2014-4-5����04:00:35
	 * @Version 0.9
	 */
	private void buildHeap(){
		for(int i = currentSize/2 ; i>0 ; i-- ){
			percolateDown(i);
		}
	}
	
	/**
	 * @Describe ����ԭ���������ݵ�x�Ĺ��췽��
	 * @Author Hope6537(����)
	 * @param @param x
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap(AnyType [] x){
		currentSize += x.length;
		array = (AnyType []) new Comparable[(currentSize+2)*11/10];
		//��������ͳ���
		//��Ϊ�������Ǵ�1��ʼ�� 1��Ϊ�����ѵĸ��ڵ�
		int i = 1;
		for(AnyType item : x){
			array[i++] = item;
		}
		buildHeap();
	}

}
