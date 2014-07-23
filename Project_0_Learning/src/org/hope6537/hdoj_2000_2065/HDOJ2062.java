package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2062 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			int m = s.nextInt();
			/*
			 * if(m==1){ System.out.print("1"); continue; }
			 */
			// MyArrayList<Integer> list = new MyArrayList<Integer>();
			int[] father = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				// list.add(i);
				father[i] = i;
			}
			// input done

			/*
			 * ˼·������������������m�����ֵ ���Ӽ��ϵ����� ���ݷ��� ���ھ���n��Ԫ�صļ��� ���԰�����Ԫ�ؽ����Ϊn���Ӽ�
			 * ��Щ����Ӽ��У����˱�����Ԫ��֮�⣬����n-1��Ԫ�� ��f(n-1) �ڼ��ϱ������1���Ӽ� ����f(n-1) + 1
			 * ����n��Ԫ�ص��Լ�Ϊf(n) = n*(f(n-1)+1) �ɵõ��Ӽ��ϵ�һ������
			 */
			// System.out.println(caluM(m));
			int flag = 0;
			while (m > 0) {
				int max_M = caluM(n);
				int countofGroup = n;// ���ж����飿
				int countofTarget = max_M / countofGroup;// ÿ����ٸ���
				// Ȼ����㵱ǰm����������ڼ��飿
				int groupNum = (m % countofTarget) == 0 ? (m / countofTarget)
						: (m / countofTarget) + 1;// ���ǵڼ���
				int targetNum = m - ((groupNum - 1) * countofTarget);// ���ǵڼ���
				// Integer num = list.get(groupNum);
				int num = father[groupNum];
				if (flag == 1) {
					System.out.print(" ");
				}
				if (targetNum > 0 && num != 0) {
					System.out.print(num);// �ҵ��������֣��������
					flag = 1;
				} else {
					flag = 0;
				}
				n--;
				m = targetNum - 1;
				// list.remove(groupNum);
				for (int i = groupNum; i < father.length - 1; i++) {
					father[i] = father[i + 1];
				}
			}
			System.out.print("\r\n");

			/*
			 * if(targetNum - 1 > 0){ //����ⲻ�Ǹ��ռ��ϣ���������� targetNum--;//���ռ����޳�
			 * �õ���ǰn-1����Ԫ�ص�λ�� groupNum = caluM(m-1) / m-1;//���ǵڼ���
			 * System.out.println(groupNum); }
			 */

		}
	}

	public static int caluM(int m) {
		int temp = 1;
		for (int i = 1; i < m + 2; i++) {
			temp = (temp + 1) * (i - 1);
		}
		return temp;
	}
}
