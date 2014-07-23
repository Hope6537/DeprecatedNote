package org.hope6537.hdoj_water;


import java.util.Scanner;

/**
 * @Describe �޾���· ���AC
 * @Author Hope6537(����)
 * @Signdate 2014-5-6����11:43:51
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2073 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        //������a[x][y]��¼����ԭ�㵽x,y�ڵ�ĳ���
        //i = 2 * x + y + 1 ; ��0,0Ϊ��һ���ڵ� ȨֵΪ0
        double [][] map = new double [1005][1005];
        //��ԭ�㵽i-1���Ȩֵ֮��
        double longs = 0;
        //���ڵ�x��Ԫ����˵
        for(int x = 0  ; x <= 1000 ; x++){
        	//Ȼ����ݶԽ���ԭ����б���
            for(int i = 0 , j = x ; j>=0 ; i++ , j--){
                //���Ǵ�1,i �� i,0 �ĳ��ȼ���
                double res = 0;
                if(i == 0 && j == 0){
                    res = 0;
                }
                //�������ͬ�е�֮���λ��
                else if(i == 0 && j!=0 ){
                    double cau = Math.hypot(x, (x-1)) ;
                    res = cau + longs ;
                }
                //�����ͬ�е�֮���λ��
                else{
                    double cau = Math.hypot(x, x);
                    double fenmu = ((x)<=0?1:(x)) * 1.0;
                    res = (cau/fenmu)  + longs ;
                }
                //��ֵ������
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