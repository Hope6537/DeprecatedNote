package org.hope6537.datastructs.march;

public class �۰���� {

	/**
	 * @Descirbe �۰���� 
	 * @Author Hope6537(����)
	 * @Params @param <T>
	 * @Params @param a ���ȱ��뽫A����
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-3-3����07:00:44
	 * @Version 0.9
	 * @param <T>
	 * @param a
	 * @param x
	 * @return ����ֵ�Ǹ�Ԫ���������е��±���
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T [] a , T x ){
		//�ӵ�һ�п�ʼע�� �����Ƕ������� T �̳��� Comparable 
		/*
		 * ������Comparable�ӿڵ�����
		 * ʵ����Comparable�ӿڵ�����һ��Collection(���ϣ����ǿ��������
		 * ������Ĺ����ǰ�����ʵ�ֵ�Comparable��ĳ��󷽷�compareTo(Object o) �����������ġ� 
		 */
		
		int low = 0 , high = a.length - 1;
		// ���ȶ��Ƶ�λ�͸�λ
		
		while (low <= high){
			//�����λ�͸�λ�߼�����
			int mid = (low + high) / 2;
			//����������������
			if(a[mid].compareTo(x)<0){
				//������ĵ�Ԫ�صıȽ�ֵС��0 ��Ŀ����������Ҳ�
				low = mid + 1;//���ʱ��λ������ĵ�+1�����½���ѭ������
			}else if(a[mid].compareTo(x)>0){
				//���������Ԫ�صıȽ�ֵ����һ ��Ŀ������������
				high = mid - 1;//��ʱ��λ������ĵ�-1�����½���ѭ������
			}
			else{
				//���ü����
				return mid ; 
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		Integer [] a = {1,2,3,4,5,6,7};
		System.out.println(binarySearch(a, 2));
	}
}
