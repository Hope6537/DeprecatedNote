package org.hope6537.dpfunction;

import java.util.Scanner;

public class HDOJ1087 {

	static Scanner s = new Scanner(System.in);

	// 肯定需要写状态方程,所以必须要有状态类
	/**
	 * @Describe 必须要有状态类
	 * @Author Hope6537(赵鹏)
	 * @Signdate 2014-5-18上午10:17:38
	 * @version 0.9
	 * @company Changchun University&SHXT
	 */
	public static class Status {
		/**
		 * @Describe 代表累和
		 */
		long totalSum;
		/**
		 * @Describe 代表当前的数值
		 */
		long userNum;
		/**
		 * @Describe 代表前驱的状态
		 */
		int preStatus;

		@Override
		public String toString() {
			return "Status [前驱的状态=" + Integer.toBinaryString(preStatus)
					+ ",累和 =" + totalSum + ", 用户当前数值=" + userNum + "]";
		}

		/**
		 * @Describe
		 * @Author Hope6537(赵鹏)
		 * @param 累和
		 * @param 用户当前数值
		 * @param 前驱的状态
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

				// 定义其的状态数量 为11111
				int nums = (1 << (n));
				nums ++;
				int preStatus = 0;
				long totalSum = 0;
				status = new Status[nums];
				// 然后开始从第一个状态开始
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
							// 如果是后续状态
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
