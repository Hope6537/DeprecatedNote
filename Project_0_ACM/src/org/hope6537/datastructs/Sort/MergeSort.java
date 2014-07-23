package org.hope6537.datastructs.Sort;

/**
 * @Describe �鲢����
 * @Author Hope6537(����)
 * @Signdate 2014-4-6����02:23:41
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class MergeSort {

	/**
	 * @Descirbe �鲢������������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param tmpArray
	 * @Params @param left
	 * @Params @param right
	 * @SignDate 2014-4-6����02:23:49
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a ��������
	 * @param tmpArray ��������
	 * @param left �������� ��Ч����󶨵�
	 * @param right ����������Ч����Ҷ���
	 */
	private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType [] a , AnyType [] tmpArray , int left , int right){
		if(left<right){
			//���������Ϸ� �ҳ���ֵ
			int center = (left+right)/2;
			//Ȼ��ݹ�ָ� ����������м�
			mergeSort(a, tmpArray, left, center);
			//�ݹ�ָ�ڶ��� �м��������Ҳ�
			mergeSort(a, tmpArray, center+1, right);
			//6��
			merge(a,tmpArray,left,center+1,right);
		}
	}
	
	/**
	 * @Descirbe �鲢����������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @Params @param tmpArray
	 * @Params @param leftPos ���α��λ��
	 * @Params @param rightPos ���α��λ��
	 * @Params @param rightEnd ���α�ļ���
	 * @SignDate 2014-4-6����03:52:03
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 * @param tmpArray
	 * @param leftPos
	 * @param rightPos
	 * @param rightEnd
	 */
	private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType [] a , AnyType [] tmpArray , int leftPos, int rightPos , int rightEnd){
		int leftEnd = rightPos - 1; //�������α�ļ��� ��center-1
		int tmpPos = leftPos;//��0��ʼ 
		int numElement = rightEnd - leftPos + 1;//��õ������ݵ��ܸ���
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			//��������α�ֱ���Ϸ�Χ���Ϸ�
			if(a[leftPos].compareTo(a[rightPos])<=0){
				//��ô��ʼ�Ƚ� ������α�����α������С
				tmpArray[tmpPos++] = a[leftPos++];
				//��ô�������α����ݸ�����ʱ����ĵ�ǰλ�� ������ tmpPos����
			}
			else{
				//��֮���α������С�Ļ� �����α�����ݸ�����ʱ����ĵ�ǰλ�� ���������α�����
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		//����ֿ��������� �ĸ���ֵʣ���� ��ôֱ�Ӱ���˳�����
		while(leftPos<=leftEnd){
			tmpArray[tmpPos++] = a[leftPos++];
		}
		while(rightPos<=rightEnd){
			tmpArray[tmpPos++] = a[rightPos++];
		}
		//�����ʱ��������ݸ��ǻ�a
		for(int i = 0; i<numElement ; i++,rightEnd--){
			a[rightEnd] = tmpArray[rightEnd];
		} 
	}
	/**
	 * @Descirbe �鲢�����������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @SignDate 2014-4-6����03:59:25
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 */
	@SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType [] a){
		AnyType [] tmpArray = (AnyType[]) new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length-1);
		
	}
}
