package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

/**
 * @Describe 过山车问题 匈牙利算法
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-3下午05:56:04
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2063{

    static Scanner s = new Scanner(System.in);

    /**
     * @Describe 用于记录配对情况
     */
    static int[][] map = new int[510][510];
    /**
     * @Describe 用于记录是否被占领
     */
    static int[] flag = new int[510];
    /**
     * @Describe 用于记录pre[i]即男生i的配对女的索引数
     */
    static int[] pre = new int[510];

    /**
     * @Describe n是女生数 m是男生数 num是总数
     */
    static int n, m, num;

    static int find(int cur) {
        // 从第一个男生开始依次遍历
        for (int i = 1; i <= m; i++) {
            if (map[cur][i] == 1 && flag[i] == 0) {
                // 如果该男生可以和该女生坐在一起，同时该男生没有被其他人占领过
                flag[i] = 1;// 将该男生占领
                if (pre[i] == 0 || find(pre[i]) == 1) {
                    // 如果该男生没有女生配对，或者是说和该男生陪对的女生还能找到别人 则该女生将这个男生占领
                    pre[i] = cur;
                    return 1;

                }

            }

        }
        return 0;
    }


    public static void main(String[] args) {
        int girl, boy, sum;
        while (s.hasNext()) {

            sum = 0;
            for (int i = 0; i < map.length; i++) {
                pre[i] = 0;// 这是初始化男生配对堆
                for(int j = 0 ; j < map.length ; j++){
                    map[i][j] = 0;
                }
            }
            num = s.nextInt();
            if (num == 0) {
                break;
            }
            n = s.nextInt(); // 是女生
            m = s.nextInt(); // 是男生
            
            for (int i = 0; i < num; i++) {
                girl = s.nextInt();
                boy = s.nextInt();
                map[girl][boy] = 1;// 可以匹配
            }
            for (int i = 1; i <= n; i++) {
                // 女生去匹配男生
                for (int j = 0; j < flag.length; j++) {
                    flag[j] = 0;
                }
                sum += find(i);
            }
            System.out.print(sum+"\r\n");
        }
    }
}