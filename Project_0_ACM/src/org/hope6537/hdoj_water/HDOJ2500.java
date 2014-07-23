package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2500{

    
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String str = "HDU";
        while(s.hasNext()){
            int n = s.nextInt();
            while(n-->0){
                int l = s.nextInt();
                for(int i = 0 ; i < 3*l ; i++){//ÕâÊÇÁÐ
                    for(int j = 0 ; j < l ; j++){
                        System.out.print(str);
                    }
                    System.out.println();
                }
            }
        }
    }

}