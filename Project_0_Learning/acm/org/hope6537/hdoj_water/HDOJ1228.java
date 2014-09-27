package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1228{

    static Scanner s = new Scanner(System.in);

    static String[] index = { "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine" };

    
    public static String toInt(String a){
        for(int i = 0 ; i < index.length ; i++){
            if(a.equals(index[i])){
                return i+"";
            }
        }
        return "-1";
    }
    
    public static void main(String[] args) {
        while (s.hasNext()) {
            String str = s.nextLine();
            String[] strs = str.split(" ");
            String A = "";
            String B = "";
            String temp = "";
            int count = 0;
            for(int i = 0 ; i < strs.length ; i++){
                temp = strs[i];
                if(temp.equals("+")){
                    count = 1;
                }
                else if(temp.equals("=")){
                    count = 2;
                }
                else{
                    if(count == 0){
                        A = A + toInt(temp);
                    }
                    if(count == 1){
                        B = B + toInt(temp);
                    }
                }
            }
            int sum = Integer.parseInt(A) + Integer.parseInt(B);
            if(sum==0){
                break;
            }
            System.out.println(sum);
        }
    }
}
