package org.hope6537.datastructs.Tree;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * @Describe ����������
 * @Author Hope6537(����)
 * @Signdate 2014-3-6����07:55:36
 * @version 0.9
 * @company Changchun University&SHXT
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>>{

	/**
	 * @Describe ���Ľڵ��Ƕ����
	 * @Author Hope6537(����)
	 * @Signdate 2014-3-6����07:55:50
	 * @version 0.9
	 * @company Changchun University&SHXT
	 * @param <T>
	 */
	private static class BinaryNode<T>{
		
		private T element;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		
		public BinaryNode(T theElement , BinaryNode<T> l , BinaryNode<T> r) {
			this.element = theElement;
			this.left = l;
			this.right = r;
		}
		
		public BinaryNode(T theElement) {
			this(theElement , null , null);
		}
	}
	
	/**
	 * @Describe ���ڵ�
	 */
	private BinaryNode<T> root;
	
	
	/**
	 * @Describe ���췽�� �γ�һ���յ���
	 * @Author Hope6537(����)
	 * @param 
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * @Descirbe ���������
	 * @Author Hope6537(����)
	 * @Params 
	 * @SignDate 2014-3-6����07:56:32
	 * @Version 0.9
	 */
	public void makeEmpty(){
		root = null;
	}
	
	/**
	 * @Descirbe ������Ƿ�Ϊ��
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-3-6����07:56:59
	 * @Version 0.9
	 * @return
	 */
	public boolean isEmpty(){
		return root == null;
	}
	
	/**
	 * @Descirbe �����t�������Ƿ����xԪ��
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-6����07:59:28
	 * @Version 0.9
	 * @param x
	 * @param t
	 * @return
	 */
	private boolean contain(T x , BinaryNode<T> t){
		if(t==null){//������ǿյģ����߸�������Ҷ
			return false;//��ƥ�� �Ҳ���
		}
		int compareResult = x.compareTo(t.element);//����x�͸���Ԫ���ֵ�ԱȵĽ��
		if(compareResult<0){//���x��t����� �Ƚϴ�СС����
			return contain(x, t.left);//�ݹ���Ҵ�t���������
		}else if(compareResult>0){//��֮����
			return contain(x, t.right);
		}
		else{//������ ���true �����ҵ���
			return true;
		}
	}
	
	/**
	 * @Descirbe �ҵ���t����С��Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-6����08:41:32
	 * @Version 0.9
	 * @param t
	 * @return
	 */
	private BinaryNode<T> findMin(BinaryNode<T> t){
		if(t==null){
			return null;
		}
		else if(t.left==null){//�����û��������� ��ô���ݽṹ ������С��
			return t;
		}
		return findMin(t.left);//����ݹ�
	}
	
	/**
	 * @Descirbe �ҵ���t������Ԫ��
	 * @Author Hope6537(����)
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-6����08:42:23
	 * @Version 0.9
	 * @param t
	 * @return
	 */
	private BinaryNode<T> findMax(BinaryNode<T> t){
		if(t!=null){
			while(t.right!=null){
				t = t.right;//ѭ���ҵ�û���Ҷ��ӵ��Ǹ�
			}
		}
		return t;
	}
	
	/**
	 * @Descirbe �ڸ�t��������½ڵ� 
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-6����08:42:55
	 * @Version 0.9
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryNode<T> insert (T x , BinaryNode<T> t){
		
		if(t == null){ // ������ǿյ� ��ô������Ǹ�
			return new BinaryNode<T>(x);
		}
		int compareResult = x.compareTo(t.element);
		
		if(compareResult<0){
			t.left = insert(x, t.left);//��Ϊ��t������С ���������
		}else if(compareResult>0){
			t.right = insert(x, t.right);//���� �� ���ұ�
		}
		else{
			;//�����ظ� �����Ѿ�����ͬ����
		}
		return t;
		
	}
	/**
	 * @Descirbe ��t����ɾ��xԪ��
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @param t
	 * @Params @return
	 * @SignDate 2014-3-6����08:44:20
	 * @Version 0.9
	 * @param x
	 * @param t
	 * @return
	 */
	private BinaryNode<T> remove(T x , BinaryNode<T> t){
		if( t == null){
			//������ǿյ� ��ôֱ�ӻ�ȥ
			return t;
		}
		int compareResult = x.compareTo(t.element);
		
		if(compareResult<0){
			t.left = remove(x, t.left);//˵��Ҫɾ������t���������
		}else if(compareResult>0){
			t.right = remove(x, t.right);//���Ҷ�����
		}else if(t.left!=null && t.right != null){
			//��������ӵ���� ������������ �����Ҷ���
			//��ô ������Ҫ�ҳ�t���Ҷ��ӵ���С����һ�����ڴ��浱ǰ��ɾ���Ľڵ�������ԭ����t�ĺ����ǵĸ���
			//��Ϊ���ǽ�������t�����ݵ� ��������t�������Ҷ��Ӷ�С
			//������������Ƕ��� �����ȴ�t���Ҳ�Ѱ��
			t.element = findMin(t.right).element;
			//�ҵ��� ����һ�θ��׵�ֵ�����ȥ Ѱ������ԭַ��ɾ�� �������ǻ��ߵ����һ��else
			//ͬʱt���Ҳ���ƹ����θ���ԭ����λ�� ��ֱ������t�ĸ��׵ĵ��ӽڵ�
			//��Ϊ���θ��׵����ֻ����һ���ҽڵ� �������Ǿ���������һ���ƹ����θ��׵�ԭַ�ͺ��ˡ�
			t.right = remove(t.element, t.right);
		}
		else{
			//�������Ǽ�״�� ���t������� ��ôt = t�������  ���û�� t = t���Ҷ���
			t = t.left!=null ? t.left : t.right;//�ظ�
		}
		return t;
	}
	
	/**
	 * @Descirbe ��ӡ����������
	 * @Author Hope6537(����)
	 * @Params @param t
	 * @SignDate 2014-3-6����08:53:15
	 * @Version 0.9
	 * @param t
	 */
	private void printTree(BinaryNode<T> t){
		if(t != null){
			printTree(t.left);
			System.out.print(" "+t.element+" ");
			printTree(t.right);
		}
	}
	
	/**
	 * @Descirbe ��t���²���һ���µĽڵ�
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-3-6����08:54:21
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	public boolean contains(T x){
		return contain(x, root);
	}

	/**
	 * @Descirbe �ҵ��������е���С��
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-3-6����08:56:52
	 * @Version 0.9
	 * @return
	 */
	public T findMin(){
		if(isEmpty()){
			throw new UndeclaredThrowableException(null);
		}
		return findMin(root).element;
	}
	/**
	 * @Descirbe �ҵ��������е������
	 * @Author Hope6537(����)
	 * @Params @return
	 * @SignDate 2014-3-6����08:56:51
	 * @Version 0.9
	 * @return
	 */
	public T findMax(){
		if(isEmpty()){
			throw new UndeclaredThrowableException(null);
		}
		return findMax(root).element;
	}
	
	/**
	 * @Descirbe �������������
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @SignDate 2014-3-6����08:58:47
	 * @Version 0.9
	 * @param x
	 */
	public void insert (T x){
		root = insert(x, root);
	}
	/**
	 * @Descirbe ������ɾ������
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @SignDate 2014-3-6����08:58:46
	 * @Version 0.9
	 * @param x
	 */
	public void remove (T x){
		root = remove(x, root);
	}
	
	public void printTree(){
		if(isEmpty()){
			System.out.println("This Tree is Empty : ���Ǹ����� ������ ");
		}
		else{
			printTree(root);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.insert(0);
		for(int i = -99 ; i <= 99 ; i = i+1){
			t.insert(i);
		}
	
		t.printTree();
	}
}
