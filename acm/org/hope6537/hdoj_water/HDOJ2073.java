package org.hope6537.hdoj_water;


import java.util.Scanner;

/**
 * @Describe 无尽的路 打表法AC
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-5-6下午11:43:51
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2073 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        //该数组a[x][y]记录的是原点到x,y节点的长度
        //i = 2 * x + y + 1 ; 即0,0为第一个节点 权值为0
        double [][] map = new double [1005][1005];
        //从原点到i-1点的权值之和
        double longs = 0;
        //对于第x行元素来说
        for(int x = 0  ; x <= 1000 ; x++){
        	//然后根据对角线原则进行遍历
            for(int i = 0 , j = x ; j>=0 ; i++ , j--){
                //这是从1,i 到 i,0 的长度计算
                double res = 0;
                if(i == 0 && j == 0){
                    res = 0;
                }
                //计算出非同列点之间的位差
                else if(i == 0 && j!=0 ){
                    double cau = Math.hypot(x, (x-1)) ;
                    res = cau + longs ;
                }
                //计算出同列点之间的位差
                else{
                    double cau = Math.hypot(x, x);
                    double fenmu = ((x)<=0?1:(x)) * 1.0;
                    res = (cau/fenmu)  + longs ;
                }
                //赋值并更新
                map[i][j] = res;
                longs = map[i][j];
            }
        }
        while (s.hasNext()) {
            
            int n = s.nextInt();
            
            while (n-- != 0) {
                int x1 = s.nextInt();
                int y1 = s.nextInt();
                int x2 = s.nextInt();
                int y2 = s.nextInt();
                System.out.printf("%.3f\r\n",Math.max(map[x1][y1],map[x2][y2])-Math.min(map[x1][y1],map[x2][y2]));
            }
        }
    }
}
