package org.hope6537.datastructs.Heap;

/**
 * @Describe �������
 * @Author Hope6537(����)
 * @Signdate 2014-4-5����08:12:18
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <AnyType>
 */
public class BinomialQueue<AnyType extends Comparable<? super AnyType>> {

	public static class Node<AnyType> {
		AnyType element; // �ڵ�Ԫ��
		Node<AnyType> leftChild; // �ڵ�������
		Node<AnyType> nextSibling; // �ڵ����ֵ�

		Node(AnyType x, Node<AnyType> l, Node<AnyType> r) {
			element = x;
			leftChild = l;
			nextSibling = r;
		}

		Node(AnyType x) {
			this(x, null, null);
		}
	}

	/**
	 * @Describe Ĭ�϶����������������
	 */
	private static final int DEFAULT_TREES = 1;

	private int currentSize;

	private Node<AnyType>[] theTrees;

	/**
	 * @Describe Ĭ�Ϲ��췽��
	 * @Author Hope6537(����)
	 * @param
	 */
	@SuppressWarnings("unchecked")
	public BinomialQueue() {
		theTrees = new Node[DEFAULT_TREES];
		makeEmpty();
	}

	/**
	 * @Descirbe �����Ƿ�Ϊ��
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����08:22:49
	 * @Version 0.9
	 * @return
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/**
	 * @Descirbe ��ն�������е�Ԫ��
	 * @Author Hope6537(����)
	 * @Params
	 * @SignDate 2014-4-5����08:22:55
	 * @Version 0.9
	 */
	public void makeEmpty() {
		currentSize = 0;
		for (int i = 0; i < theTrees.length; i++) {
			theTrees[i] = null;
		}
	}

	/**
	 * @Describe Ĭ�Ϲ��췽�� ������
	 * @Author Hope6537(����)
	 * @param @param item
	 */
	@SuppressWarnings("unchecked")
	public BinomialQueue(AnyType item) {
		currentSize = 1;
		theTrees = new Node[1];
		theTrees[0] = new Node<AnyType>(item, null, null);
	}

	/**
	 * @Descirbe �������е�������ȣ�
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����08:20:37
	 * @Version 0.9
	 * @return
	 */
	private int capacity() {
		return (1 << theTrees.length) - 1;
	}

    /**
     * @Descirbe �ҵ���С��
     * @Author Hope6537(����)
     * @Params @return
     * @SignDate 2014-4-6����12:13:26
     * @Version 0.9
     * @return
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) ){
           return null;
        }

        return theTrees[ findMinIndex( ) ].element;
    }

	
	/**
	 * @Descirbe ���ض����������С����������
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����08:19:40
	 * @Version 0.9
	 * @return
	 */
	private int findMinIndex() {
		int i = 0;
		int minIndex = 0;
		for (i = 0; theTrees[i] == null; i++) {
			;
		}
		for (minIndex = i; i < theTrees.length; i++) {
			if (theTrees[i] != null
					&& theTrees[i].element
							.compareTo(theTrees[minIndex].element) < 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	/**
	 * @Descirbe �ϲ�����ͬ����С�Ķ�����������
	 * @Author Hope6537(����)
	 * @Params @param t1
	 * @Params @param t2
	 * @Params @return
	 * @SignDate 2014-4-5����08:27:20
	 * @Version 0.9
	 * @param t1
	 * @param t2
	 * @return
	 */
	private Node<AnyType> combineTrees(Node<AnyType> t1, Node<AnyType> t2) {
		/*
		 * �ܶ���֮ �ǽ��ϴ�����ĸ��½�һ�� ��Ϊ��С����������� ���t1��t2Ҫ�� ��ת����
		 */
		if (t1.element.compareTo(t2.element) > 0) {
			return combineTrees(t2, t1);
		}
		// ����С�����������뵽�ϴ������������
		t2.nextSibling = t1.leftChild;
		// ��ͬʱ���ϴ������ԭ����t1�������t2�������뵽t1����� ��Ϊt1������Ӵ���
		t1.leftChild = t2;
		// �������ɵĸ� t1����
		return t1;
	}

	/**
	 * @Descirbe �ϲ�����������е�����
	 * @Author Hope6537(����)
	 * @Params @param rhs ��������Ϊ�ϲ������һ���������
	 * @SignDate 2014-4-5����08:51:28
	 * @Version 0.9
	 * @param rhs
	 */
	public void merge(BinomialQueue<AnyType> rhs) {
		// �������������� ֱ�ӷ���
		if (this == rhs) {
			return;
		}
		// ������������
		// ��ô�������size�ͺϲ������
		currentSize += rhs.currentSize;
		if (currentSize > capacity()) {
			// �����������������ɲ��� ��ô���¹����µĶ������
			int maxLength = Math.max(theTrees.length, rhs.theTrees.length)+1;
			// �����µ����洢����
			expandTheTrees(maxLength);
		}
		// ������һ�βμӺϲ������������� ��Ϊi+1����
		Node<AnyType> carry = null;
		/*
		 * �ȴ�0��ʼ ��j���ڵ��������1��ʼ һ��j������������Ӧ������ ���� ͬʱ��i��������++ ��j�����ĸ���������j*2�ķ�ʽ����
		 * ����j���о���ʽ �ǰ���B0 B1 B2 .. Bi�Ľڵ������������ ���ڶ�����е������� ����b0 Ϊ����һ���ڵ�ĵ����� ��b1 =
		 * 2 b2 = 4 b3 = 8 ���ڵ� ����i����ǰ�����Ľ��� ��j����ý��м����ڵ� ������ײ�ʱ ֹͣѭ��
		 */
		for (int i = 0, j = 1; j < currentSize; i++, j = j * 2) {
			// ��ȡ��Ϊi��������������е�����
			Node<AnyType> t1 = theTrees[i];
			// �и����ĵ�У��
			Node<AnyType> t2 = i < rhs.theTrees.length ? rhs.theTrees[i] : null;
			// ���������Ϊ�� ����+1
			int whichCase = t1 == null ? 0 : 1;
			// �ϲ�����Ϊ�� ��ô����+2
			whichCase += t2 == null ? 0 : 2;
			// ��Ϊi+1������Ϊ�� ��ô����+4
			whichCase += carry == null ? 0 : 4;
			// ��ʼ����ѡ��
			switch (whichCase) {
			case 0:
			case 1:
				// ���û�������߽��б��� ���׽���
				break;
			case 2:
				// ������������
				theTrees[i] = t2;
				// ��ô����������뵱ǰ�׵Ķ����� ͬʱ����������ĸ� ������
				rhs.theTrees[i] = null;
				break;
			case 4:
				// ���������������Ϊi+1���� ��ô��Ӽ���
				theTrees[i] = carry;
				carry = null;
				break;
			case 3:
				// ����ڱ����� ����t1 �� t2����ͬ����С�Ķ�����
				carry = combineTrees(t1, t2);
				// ��ô�ϲ�֮�� �����ȵ���� �����ӳٴ��� ������һ�ε�ѭ�� �����ϲ�Դ���ݹ���
				theTrees[i] = rhs.theTrees[i] = null;
				break;
			case 5:
				// ͬcase3 ��������б��������ӳ���������ͬ
				carry = combineTrees(t1, carry);
				// ���ٴκϲ� ͬʱ�����ɵ��������ֱ�� �����ӳٴ��� �����ϲ�Դ���ݹ���
				theTrees[i] = null;
				break;
			case 6:
				// ͬcase 5
				carry = combineTrees(t2, carry);
				rhs.theTrees[i] = null;
				break;
			case 7:
				/*
				 * ���������ֵ��� t1 t2 �� �ӳ���������ͬһ������ ��ô���Ƚ��ӳ���������ǰ�ȡ���Ϊ�������ǺϷ���
				 */
				theTrees[i] = carry;
				// ��Ϊt1 �� t2 �ϲ��� �Ȼ��� �����ӳ���ֱ�Ӹ�����ǰ�������û������
				carry = combineTrees(t1, t2);
				// Ȼ�������ɵ��ӳ�������ѭ����ȥ �����ϲ�Դ���ݹ���
				rhs.theTrees[i] = null;
				break;
			}
		}
		// Ȼ��ɾ���ⲿ�Ķ������
		for (int k = 0; k < rhs.theTrees.length; k++) {
			rhs.theTrees[k] = null;
		}
		rhs.currentSize = 0;
		// ���� �ϲ��������
	}

	/**
	 * @Descirbe ��������и��ݲ��������ع�������
	 * @Author Hope6537(����)
	 * @Params @param newNumTrees
	 * @SignDate 2014-4-5����08:40:40
	 * @Version 0.9
	 * @param newNumTrees
	 */
	@SuppressWarnings("unchecked")
	private void expandTheTrees(int newNumTrees) {
		// �õ��������ĸ��ڵ�ļ���
		Node<AnyType>[] old = theTrees;
		// ����������������
		int oldNumTrees = theTrees.length;
		// ���������Ĵ�С
		theTrees = new Node[newNumTrees];
		// Ȼ���0��ʼ���� �������ĳ������ν�ԭֵ����
		for (int i = 0; i < oldNumTrees; i++) {
			theTrees[i] = old[i];
		}
		// ������ĩβ��ʼ�������ĵط� ����
		for (int i = oldNumTrees; i < newNumTrees; i++) {
			theTrees[i] = null;
		}
	}

	/**
	 * @Descirbe ����������е���С�ڵ�����
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����09:46:54
	 * @Version 0.9
	 * @return
	 */
	public AnyType deleteMin() {
		if (isEmpty()) {
			//��������ǿյ� ��ôֱ�ӷ���null
			return null;
		}
		//���� �ҵ���������о�����С�����������
		int minIndex = findMinIndex();
		//�ҵ������� ֱ�ӻ�ȡ����Ԫ�ؾͿ����� ��Ϊÿ���������϶�������
		AnyType min = theTrees[minIndex].element;
		//Ȼ���ȡ����ǰ��ժ���ĸ���������
		Node<AnyType> deletedTree = theTrees[minIndex].leftChild;
		//�����µĶ������
		BinomialQueue<AnyType> deletedQueue = new BinomialQueue<AnyType>();
		//���������Ķ�����д�С���ĳ�(������С�����)������+1 ������һλ
		deletedQueue.expandTheTrees(minIndex + 1);
		//Ȼ���޸��µĶ�����еĴ�С 
		deletedQueue.currentSize = (1 << minIndex) - 1;
		//���������ڵ�ȥ���� ��ɢ��������ɵ��¶������
		 for( int j = minIndex - 1; j >= 0; j-- )
	        {
	            deletedQueue.theTrees[ j ] = deletedTree;
	            deletedTree = deletedTree.nextSibling;
	            deletedQueue.theTrees[ j ].nextSibling = null;
	        }
		//���ǽ�������С����ȥ�����ԭ������������ڵ�Ȩֵ �����Ȩֵ�����������NULL
		theTrees[minIndex] = null;
		//Ȼ�󽫶�����������������޸�
		currentSize = currentSize - (deletedQueue.currentSize + 1);
		//������к�ȥ�����ڵ����ɢ��������ɵ�С���кϲ�
		merge(deletedQueue);
		//������Сֵ
		return min;

	}
	
	public void insert(AnyType x){
		 merge(new BinomialQueue<AnyType>(x));
	}

	public static void main(String[] args) {
        int numItems = 10000;
        BinomialQueue<Integer> h  = new BinomialQueue<Integer>( );
        BinomialQueue<Integer> h1 = new BinomialQueue<Integer>( );
        int i = 37;

        System.out.println( "Starting check." );

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            if( i % 2 == 0 )
                h1.insert( i );
            else
                h.insert( i );

        h1.merge(h);

       for(int i2 = 0 ; i2 <h1.currentSize ; i2++){
    	   System.out.println(h1.deleteMin());
       }
 
        System.out.println( "Check done." );
    }
}
