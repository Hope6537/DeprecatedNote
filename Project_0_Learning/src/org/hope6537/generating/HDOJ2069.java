package org.hope6537.generating;

import java.util.Scanner;

public class HDOJ2069{
    static int[] coin = { 0, 1, 5, 10, 25, 50 };
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int[][][] dp = new int[255][6][105];
        // 对于数组dp[i][j][k] = value来说
        // 是指在金额为i元的情况下以金币种类j结束，总金币个数为k value = 1为可行 0为不可行
        // 这里标注为① 一会下面说他的作用
        dp[0][0][0] = 1;
        // 非常奸诈的使用打表法
        for (int i = 1; i < 255; i++) {
            // 从一块钱开始 一直到题目的范围
            for (int j = 1; j <= 5; j++) {
                /*
                 * 依次对5种硬币进行迭代 如果当前的钱数量小于这个硬币的面额，
                 * 那就直接打表打到下一个金额上，典型的贪心做法，只不过是变换思维反过来而已
                 */
                // 获取到当前的拾取的硬币的面额
                int temp = coin[j];
                if (i < temp) {
                    break;
                }
                /*
                 * 对于当前的减法来计算找零余额来说， 选取比当前temp面额更小的硬币来进行减法操作
                 * 这也是为啥在面额数组前加一个0的缘由，防止越界啊混蛋
                 */
                for (int k = 0; k <= j; k++) {
                    /*
                     * 由于题目要求找零个数不能超过100个硬币， 所有在之前和这里限定长度为100 超出则不进行计算
                     */
                    for (int x = 1; x <= 100; x++) {
                        /*
                         * 算法核心 对于当前金额i的以j面额为结束，总金币个数为x种的找法来说 如果i-temp的余额
                         * 能被k面额x-1种找法所找成，那么+temp的值就是i的值 所以也能找成钱
                         * 
                         * 语文不太好，防止以后自己看不懂，写个例子 11元钱中 1+5+5找法，3个硬币中 i=11 j=2 x=3
                         * 对于最后一位的5去掉它 即在6元钱 1+5找法中 2个硬币中 i=6 j=2 x=2
                         * 来说这种找法是合法的，所以左右两端加上一个5 肯定合法 依次类推寻找，最后①来说的作用就是用于寻找到最低端
                         * 0元钱在0元结束下时使用0个硬币找钱这个事情是合法的。提供了初始值为1的累加条件
                         */
                        dp[i][j][x] += dp[i - coin[j]][k][x - 1];
                        /*
                         * 综上算法结束
                         */
                    }
                }
            }
        }

        while (s.hasNext()) {

            int money = s.nextInt();
            int ans = 0;
            // 下面的查表就不用说了
            {
                for (int i = 0; i <= 5; i++) {
                    for (int j = 0; j <= 100; j++) {
                        ans = ans + dp[money][i][j];
                    }
                }
                System.out.print(ans + "\r\n");
            }

        }
    }
}