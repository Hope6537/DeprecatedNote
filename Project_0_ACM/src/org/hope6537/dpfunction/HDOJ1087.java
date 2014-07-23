package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1087 {

	static Scanner s = new Scanner(System.in);

	// �϶���Ҫд״̬����,���Ա���Ҫ��״̬��
	/**
	 * @Describe ����Ҫ��״̬��
	 * @Author Hope6537(����)
	 * @Signdate 2014-5-18����10:17:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	public static class Status {
		/**
		 * @Describe �����ۺ�
		 */
		long totalSum;
		/**
		 * @Describe ����ǰ����ֵ
		 */
		long userNum;
		/**
		 * @Describe ����ǰ����״̬
		 */
		int preStatus;

		@Override
		public String toString() {
			return "Status [ǰ����״̬=" + Integer.toBinaryString(preStatus)
					+ ",�ۺ� =" + totalSum + ", �û���ǰ��ֵ=" + userNum + "]";
		}

		/**
		 * @Describe
		 * @Author Hope6537(����)
		 * @param �ۺ�
		 * @param �û���ǰ��ֵ
		 * @param ǰ����״̬
		 */
		public Status(long totalSum, long userNum, int preStatus) {
			super();
			this.totalSum = totalSum;
			this.userNum = userNum;
			this.preStatus = preStatus;
		}

	}

	public static void main(String[] args) {
		while (s.hasNext()) {
			int[] arr;
			Status[] status;

			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			arr = new int[n + 2];
			arr[0] = 0;
			arr[n + 1] = 0;
			for (int i = 1; i <= n; i++) {
				arr[i] = s.nextInt();
			}
			{

				// �������״̬���� Ϊ11111
				int nums = (1 << (n));
				nums ++;
				int preStatus = 0;
				long totalSum = 0;
				status = new Status[nums];
				// Ȼ��ʼ�ӵ�һ��״̬��ʼ
				status[0] = new Status(0, 0, 0);
				for (int i = 1; i < nums; i++) {
					if (status[i] == null) {
						status[i] = new Status(0, 0, 0);
					}
					status[i].totalSum = 0;
					String binaryI = Integer.toBinaryString(i);
					for (int j = arr.length - 1; j >= 0; j--) {
						int temp = 1 << j;
						String binaryTemp = Integer.toBinaryString(temp);
						
						if ((i & temp) != 0) {
							// ����Ǻ���״̬
							preStatus = i - temp;
							String binaryPreStatus = Integer.toBinaryString(preStatus);
							if (status[preStatus].userNum < arr[j]) {
								totalSum = status[preStatus].totalSum + arr[j];
								if (status[i].totalSum < totalSum) {
									status[i].totalSum = totalSum;
									status[i].userNum = arr[j];
									status[i].preStatus = preStatus;
								}
							} else {
								continue;
							}
						}
					}
				}

			}
			long max = 0;
			for (int i = 0; i < status.length; i++) {
				if ((status[i].preStatus & 1) != 0) {
					if (status[i].totalSum > max) {
						max = status[i].totalSum;
					}
				}
			}
			System.out.println(max);
		}
	}

}
