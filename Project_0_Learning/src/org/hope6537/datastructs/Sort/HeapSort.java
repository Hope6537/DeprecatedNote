package org.hope6537.datastructs.Sort;

public class HeapSort {
	
	/**
	 * @Descirbe ��ȡ���е�����������ķ���
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-4-6����01:18:12
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	private static int leftChild(int x){
		/*
		 * ����Ѳ�ͬ����  ����Ԫ�ص����������ֵ�� 2 * i
		 * ���Ƕѵĸ���Ԫ���Ǵ�����1��ʼ��
		 * ���ڶ������� ��������Ԫ���Ǵ�����0��ʼ�� ����Ҫ+1
		 */
	
		return 2* x + 1;
	}
	
	/**
	 * @Descirbe ������ ����max�� 
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param i �±�
	 * @Params @param n ���ݸ���
	 * @SignDate 2014-4-6����02:01:14
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param i
	 * @param n
	 */
	private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType [] a ,int i , int n){
		int child = 0 ;  //�ӽڵ���±� 
		AnyType tmp; //���ڵ������ 
		for(tmp = a[i] ; leftChild(i) < n ; i = child){
			/*System.out.println("a[i]="+a[i]);*/
			//�Ӹ��ڵ㿪ʼѭ�� һֱ�����һ�������ӽڵ�Ľڵ�Ϊֹ
			child = leftChild(i);
			//��child��ֵ ��i������� 
			if(child != n-1 && a[child].compareTo(a[child+1])<0){
				//��� ��������ֵ� ���Ҷ��� ͬʱ�����С���Ҷ���
				child++;
				//�������Ƶ��Ҷ�������
			}
			if(tmp.compareTo(a[child])<0){
				//���������ӽڵ�������ڸ� 
				/*System.out.println("a[child]="+a[child]);*/
				a[i] = a[child];
				//��ô���ӻ���  �γɵ������� 
			}
			else{
				break;
			}
		}
		/*
		 * ѭ����� ��ȡ�����Ľڵ�Ԫ��ֵ������������ ��ɾ�����ĶѴ洢�ռ� ������
		 */
		a[i] = tmp;
	}
	
	
	 /**
	 * @Descirbe ����Ԫ�� 
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param index1
	 * @Params @param index2
	 * @SignDate 2014-4-6����01:42:56
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param index1
	 * @param index2
	 */
	public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
	    {
	        AnyType tmp = a[ index1 ];
	        a[ index1 ] = a[ index2 ];
	        a[ index2 ] = tmp;
	    }
	
	/**
	 * @Descirbe �������ⲿ�ӿ� ����
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @SignDate 2014-4-6����01:59:26
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType [] a){
		for(int i = a.length/2 ; i>=0 ; i--){
			percDown(a, i, a.length); //����max��
		}
		for(int i = a.length - 1 ; i>0;i--){
			swapReferences(a,0,i); //��Ԫ��deleteMax�� ��maxԪ�ط���i�� �����
			percDown(a, 0, i);//Ȼ���ٽ��ж����� �ҵ������max
		}
	}

}
