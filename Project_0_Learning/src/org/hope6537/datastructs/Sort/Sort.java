package org.hope6537.datastructs.Sort;

public class Sort {
	
	/**
	 * @Descirbe ��������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @SignDate 2014-4-6����12:45:25
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType [] a){
		int j = 0;
		for(int p = 1 ; p < a.length ; p++ ){
			//�ӵڶ���Ԫ�ؿ�ʼ��β��
			AnyType tmp = a[p]; //Ȼ���ȡ��p��Ԫ��
			for(j = p ; j > 0 && tmp.compareTo(a[j-1])<0 ; j--){
				//����ѭ��  j��������p��ʼ ��j-1Ԫ�ش���jԪ��ʱ  ����
				a[j] = a[j-1];
			}
			//�������������
			a[j] = tmp;
		}
	}
	
	/**
	 * @Descirbe ϣ������
	 * @Author Hope6537(����)
	 * @Params @param <AnyType>
	 * @Params @param a
	 * @SignDate 2014-4-6����12:57:15
	 * @Version 0.9
	 * @param <AnyType>
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void shellsort(AnyType [] a){
		int j = 0; //��Ϊһ����ʱ�±�
		//���ܳ���һ�뿪ʼ ��gap>0ʱ �������۰����� gap��Ϊһ����Ծ���� 
		for(int gap = a.length/2 ;  gap>0 ; gap /= 2  ){
			//��֮ǰ���۰������ʼ������ĩβ
			for(int i = gap ; i < a.length ; i++){
				//����Ѱ�Ҳ����ñ��� �����䱣��
				AnyType tmp = a[i];
				//��i��ֵ����j ���j����gap���� ͬʱj������Ԫ��С�� j-gap �����ڱ���Ծ��ʽ�����в�ͬ�� �򻥻�
				for(j = i ; j>=gap && tmp.compareTo(a[j-gap]) < 0 ; j-= gap){
					//Ԫ�ػ���
					a[j] = a[j-gap];
				}
				//�������������
				a[j] = tmp;
			}
		}
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void BooSort(AnyType [] a){
		AnyType temp = null;
		for(int i = 0 ; i < a.length ; i++){
			for(int j = 0 ; j < i ; j++){
				if(a[i].compareTo(a[j])<0){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

}
