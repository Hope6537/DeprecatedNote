package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Describe
 * @Author Hope6537(’‘≈Ù)
 * @Signdate 2014-05-06 10:50:45
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2071 {

    static Scanner s = new Scanner(System.in);

    private static class C{
         double [] h ;
         public C(int x) {
             h = new double[x];
        }
    }
    
    public static void main(String[] args) {
        while(s.hasNext()){
            int n = s.nextInt();
            while(n--!=0){
                C c = new C(s.nextInt());
                for(int i = 0 ; i < c.h.length; i++){
                    c.h[i] = s.nextDouble();
                }
                Arrays.sort(c.h);
                System.out.printf("%.2f\r\n",c.h[c.h.length-1]);
                
            }
        }
    }
}