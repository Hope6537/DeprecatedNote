package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2081 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while(s.hasNext()){
            int n = s.nextInt();
            while(n--!=0){
                String tel = s.next();
                String res = "6";
                for(int i = tel.length()-5 ; i < tel.length() ; i++){
                    res = res + tel.charAt(i);
                }
                System.out.println(res);
            }
        }
    }
}
