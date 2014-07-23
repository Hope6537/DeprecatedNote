package org.hope6537.datastructs.Tree;

/**
 * @Describe AVLƽ������һ������
 * @Author Hope6537(����)
 * @Signdate 2014-3-27����08:40:15
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <AnyType>
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>> {

	public static class AvlNode<AnyType>{
		
		AnyType element;
		AvlNode<AnyType> left;
		AvlNode<AnyType> right;
		int height;
		
		public AvlNode(AnyType x) {
			this(x,null,null);
		}
		public AvlNode(AnyType element,AvlNode<AnyType> left, AvlNode<AnyType> right){
			this.element = element;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}
	
	private int height(AvlNode<AnyType> t){
		return t==null?-1:t.height;
	}
	
	private AvlNode<AnyType> insert(AnyType x,AvlNode<AnyType> t){
		if(t==null){
			return new AvlNode<AnyType>(x);
		}
		int compareResult = compare(x,t.element);
		
		if(compareResult<0){
			t.left = insert(x, t.left);
			if(height(t.left) - height(t.right) == 2){
				if(compare(x, t.left.element)<0){
					t = rotateWithLeftChild(t);
				}
				else{
					t = doubleWithLeftChild(t);
				}
			}
		}
		else if(compareResult>0){
			t.right = insert(x, t.right);
			if(height(t.left) - height(t.right) == -2){
				if(compare(x, t.right.element)<0){
					t = rotateWithRightChild(t);
				}
				else{
					t = doubleWithRightChild(t);
				}
			}
		}
		else{
			;
		}
		t.height = Math.max(height(t.left), height(t.right))+1;
		return t;
	}

	/**
	 * @Descirbe ˫��ת��֮ǰ�ĶԳ�
	 * @Author Hope6537(����)
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-27����08:39:57
	 * @Version 0.9
	 * @param t
	 * @return
	 */
	private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> t) {
		t.right = rotateWithRightChild(t.right);
		return rotateWithRightChild(t);
	}

	/**
	 * @Descirbe ����ת X�ڽڵ���Ҳ� 
	 * @Author Hope6537(����)
	 * @Params @param k2
	 * @Params @return
	 * @SignDate 2014-3-27����08:39:06
	 * @Version 0.9
	 * @param k2
	 * @return
	 */
	private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
		AvlNode<AnyType> k1 = k2.right;
		k2.right = k1.left;
		k1.left= k2;
		//����µĸ߶Ȳ����� 
		k2.height = Math.max(height(k2.left), height(k2.right));
		k1.height = Math.max(height(k1.left), height(k1.right));
		return k1;
	}

	/**
	 * @Descirbe ִ��˫��ת������
	 * @Author Hope6537(����)
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-27����08:32:40
	 * @Version 0.9
	 * @param t
	 * @return
	 */
	private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> t) {
		t.left = rotateWithLeftChild(t.left);
		return rotateWithLeftChild(t);
	}

	/**
	 * @Descirbe ִ�е���ת������
	 * @Author Hope6537(����)
	 * @Params @param k2 ԭ���ĸ��ڵ�
	 * @Params @return
	 * @SignDate 2014-3-27����08:28:38
	 * @Version 0.9
	 * @param k2
	 * @return
	 */
	private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
		//��k2����������������k1 k1Ϊ�������ĸ��ڵ㣬ͬʱҲ��Ϊ�����ĸ��ڵ㣬��k1�Ľڵ���ȴ����Ҳ�
		AvlNode<AnyType> k1 = k2.left;
		//��k1���ҽڵ㸶��k2������k1���Ҳ�Ĳ�Ӱ��ƽ���Y����k2����࣬
		k2.left = k1.right;
		//��k2����k1���Ҳ���Ϊ������ ��ʱk1����������ĸ߶���� k1��������߶�Ϊ2  ��������Ϊk2+k1.right
		k1.right= k2;
		//����µĸ߶Ȳ����� 
		k2.height = Math.max(height(k2.left), height(k2.right));
		k1.height = Math.max(height(k1.left), height(k1.right));
		return k1;
	}

	private int compare(AnyType x, AnyType element) {
		
		return x.compareTo(element);
	}
	
}
