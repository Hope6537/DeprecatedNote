package org.hope6537.datastructs.Heap;


/**
 * @Describe ��ʽ��
 * @Author Hope6537(����)
 * @Signdate 2014-4-5����04:24:19
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <AnyType>
 */
public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {
	
	/**
	 * @Describe ��ʽ�ѽڵ�
	 * @Author Hope6537(����)
	 * @Signdate 2014-4-5����04:25:18
	 * @version 0.9
	 * @company Changchun University&SHXT
	 * @param <AnyType>
	 */
	private static class Node<AnyType>{
		AnyType element;
		Node<AnyType> left;
		Node<AnyType> right;
		/**
		 * @Describe ��·���� 
		 */
		int npl;
		
		public Node(AnyType x){
			this(x,null,null);
		}
		public Node(AnyType x , Node<AnyType> lf , Node<AnyType> rf) {
			this.element = x;
			this.left = lf;
			this.right = rf;
			this.npl = 0;
		}
	}
	
	/**
	 * @Describe ���ڵ�
	 */
	private Node<AnyType> root;
	
	/**
	 * @Descirbe ����Ƿ�Ϊ��  
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-4-5����04:44:57
	 * @Version 0.9
	 * @return
	 */
	public boolean isEmpty(){
		return root == null;
	}
	
	/**
	 * @Descirbe �����ʽ��
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2014-4-5����04:45:07
	 * @Version 0.9
	 */
	public void makeEmpty(){
	 	root = null;
	}
	
	/**
	 * @Descirbe �ϲ����̵�һ��
	 * @Author Hope6537(����)
	 * @Params @param rhs �������
	 * @SignDate 2014-4-5����04:53:55
	 * @Version 0.9
	 * @param rhs
	 */
	public void merge(LeftistHeap<AnyType> rhs){
		//���������Ҫ�ϲ�������ͬ 
		if(this == rhs){
			//��ֱ����ת
			return;
		}
		//��ȡ�ϲ�������� ���ڵ��������������
		root = merge(root,rhs.root);
		//��������
		rhs.root = null;
	}

	/**
	 * @Descirbe �ϲ����̵ڶ��� �����ڵ���� 
	 * @Author Hope6537(����)
	 * @Params @param h1
	 * @Params @param h2
	 * @Params @return
	 * @SignDate 2014-4-5����04:53:51
	 * @Version 0.9
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
		//�������������һ��Ϊ�� ��ô��һ�ž��Ǻϲ����
		if(h1 == null){
			return h2;
		}
		if(h2 == null){
			return h1;
		}
		//�������Ϊ��
		if(h1.element.compareTo(h2.element)<0){
			//ͬʱ����������С�ںϲ��� ��ֱ�Ӵ�ֵ
			return merge2(h1,h2);
			//���ص��������ϲ����µ����� 
		}
		else{
			//���� ����С����һ������Ϊ���� ����
			return merge(h2, h1);
		}
		
	}

	/**
	 * @Descirbe �ϲ����̵����� 
	 * @Author Hope6537(����)
	 * @Params @param h1 ����Ϊ��ֵС������
	 * @Params @param h2 ����Ϊ���ִ������
	 * @Params @return
	 * @SignDate 2014-4-5����04:57:04
	 * @Version 0.9
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node<AnyType> merge2(Node<AnyType> h1, Node<AnyType> h2) {
		//��� h1����ڵ�Ϊ��  ��h1�Ǹ������ӻ����޶��ӽڵ�
		if(h1.left == null){
			//��ôh2��ͬ����ֱ�Ӳ��뵽h1�����
			h1.left = h2;
		}
		else{
			/*
			 * ���h1����һ�����ڵ� ��h1��С������������h2���бȽϹ鲢�Ƚ�
			 * ����ڵݹ��� ��һ������������ؽ�ʣ�µ��ڵ� ��ʱ�ݹ����ʱ �ߵ�������if
			 * ���� �ͽ�����ɢ������ϲ���һ�����ˡ�
			 * ��ԭ��H1 H2�����γ����µĽṹ
			 * ���ڵݹ������ ���ٽ��бȽ� ֱ�����ĳ�����ڵ�û���Ҷ���
			 * ���� ��H2'�ϲ������������H1���Ҷ����� �����ϲ���� 
			 */
			h1.right = merge(h1.right,h2);
			
			if(h1.left.npl<h1.right.npl){
				/*
				 * �ںϲ��Ĺ����� �����ڵ�����С���ҽڵ�����
				 * ��ô�ýڵ�������������
				 */
				swapChildren(h1);
			}
			/*
			 * �ںϲ��ɹ��������� ���ϲ�����������������������+1
			 */
			h1.npl = h1.right.npl+1;
		}
		return h1;
	}

	private static <AnyType> void swapChildren( Node<AnyType> t )
    {
		Node<AnyType> tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }
	
	public void insert(AnyType x){
		root = merge(new Node<AnyType>(x), root);
	}
	
	public AnyType deleteMin(){
		 if(isEmpty()){
			 return null;
		 }
		 AnyType min = root.element;
		 root = merge(root.left, root.right);
		 return min;
	}
}
