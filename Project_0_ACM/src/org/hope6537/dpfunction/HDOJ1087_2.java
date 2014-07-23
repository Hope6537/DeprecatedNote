package org.hope6537.dpfunction;

import java.util.Scanner;

/**
 * @״̬ת�Ʒ���ʽΪ dp[i] = Max(dp[j]+value[i] , value[i]);
 * @״̬���̵����� dp[i] ���������value[i]Ϊ��β������������������iλ��ʱ�����Ž�,����value[j] < value[i]
 *          ��i���Դ�j����ȥ ������1��3 1 = j �� 3 = i (0<=j<i) ��i��j֮��;
 * @Dp����
 * @��߽�Ϊ dp[0]������������һ������
 * @�����ӽṹΪ ÿ��dp[i]�������Ž�
 * @�����ж� ��value[j]<value[i] �����޷���j����i������i��ǰ����������j;
 */
public class HDOJ1087_2 {

	static Scanner s = new Scanner(System.in);
	static int MAX = 1005;

	public static void main(String[] args) {
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			// �����ֵ�ķ���
			int value[] = new int[MAX];
			// ����̬�滮��ֵ
			int dp[] = new int[MAX];
			// Ȼ��ӵ�һ���㿪ʼ����Ȩֵ
			for (int i = 0; i < n; i++) {
				value[i] = s.nextInt();
			}
			// �����ֵ��ʱ�����ӵ�һ�������Ȼ��ֱ�������յ��·��Ȩֵ
			// max�����������յ��ۺ�
			int max = value[0];
			//dp[0]������Ǵ�������������һ���㣬ֻ��һ���������Ϊ�߽�
			dp[0] = value[0];
			// input done;
			//�ӵڶ������㿪ʼ
			for (int i = 1; i < n; i++) {
				//��ȡ��ֱ�Ӵ������������Ķ�ֵ
				dp[i] = value[i];
				for (int j = 0; j < i; j++) {
					//Ȼ��������ǰ�� j---->i
					if (value[i] > value[j]) {
						//�������ǰ������
						if (dp[i] < dp[j] + value[i]) {
							//ͬʱ�ۺ���������ֱ����������||�����Ǵ��ڴ��������������ġ���ô��ֵ
							dp[i] = dp[j] + value[i];
						}
					}
				}
				//�������i���ֵ����ֱ�������յ�������е��յ�ֵ����ôȡ��
				if (dp[i] > max) {
					max = dp[i];
				}
			}
			System.out.println(max);
		}
	}

}
