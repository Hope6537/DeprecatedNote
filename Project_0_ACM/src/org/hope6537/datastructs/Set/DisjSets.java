package org.hope6537.datastructs.Set;

/**
 * @Describe ���ཻ������
 * @Author Hope6537(����)
 * @Signdate 2014-4-7����08:09:49
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class DisjSets {

	/**
	 * @Describe ���Ƿ���ʾ��ʾ���ݵ����� ����˵��Ԫ�صĸ����� �±���Ԫ�ص����� ����������������ĸ߶ȵ��෴��
	 */
	private int[] s;

	/**
	 * @Describe ����Ԫ�������Ĺ��췽��
	 * @Author Hope6537(����)
	 * @param @param numElements
	 */
	public DisjSets(int numElements) {
		s = new int[numElements];
		for (int i = 0; i < s.length; i++) {
			s[i] = -1;
		}
	}

	/**
	 * @Descirbe �����󲢷�
	 * @Author Hope6537(����)
	 * @Params @param root1
	 * @Params @param root2
	 * @SignDate 2014-4-7����08:15:30
	 * @Version 0.9
	 * @param root1
	 *            ������s�ϵ�����
	 * @param root2
	 *            ������s�ϵ�����
	 */
	public void union(int root1, int root2) {
		/*
		 * ���root2������λ�ø���
		 */
		if (s[root2] < s[root1]) {
			// ��ô��root1�����root2������ ��������������
			s[root1] = root2;
		} else {
			// ������߸߶���ͬ����root1����
			if (s[root1] == s[root2]) {
				// �����ͬ ���+1 ����������ͬ�������
				s[root1]--;

			}
			// Ȼ��root2����root1�����µ�������������
			s[root2] = root1;
		}
	}

	/**
	 * @Descirbe ���x������Ԫ�����ĸ������� �����ĸ��ڵ�
	 * @Author Hope6537(����)
	 * @Params @param x
	 * @Params @return
	 * @SignDate 2014-4-7����08:27:41
	 * @Version 0.9
	 * @param x
	 * @return
	 */
	public int find(int x) {
		if (s[x] < 0) {
			return x;
		} else {
			return find(s[x]);
		}
	}

	public static void main(String[] args) {
		int NumElements = 128;
		int NumInSameSet = 16;

		DisjSets ds = new DisjSets(NumElements);
		int set1, set2;

		for (int k = 1; k < NumInSameSet; k *= 2) {
			for (int j = 0; j + k < NumElements; j += 2 * k) {
				set1 = ds.find(j);
				set2 = ds.find(j + k);
				ds.union(set1, set2);
			}
		}

		for (int i = 0; i < NumElements; i++) {
			System.out.print(ds.find(i) + "*");
			if (i % NumInSameSet == NumInSameSet - 1)
				System.out.println();
		}
		System.out.println();
	}

}
