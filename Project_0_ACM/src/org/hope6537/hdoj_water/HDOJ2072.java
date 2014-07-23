package org.hope6537.hdoj_water;

import java.util.Scanner;

/**
 * @Describe ÷¡ΩÒWA
 * @Author Hope6537(’‘≈Ù)
 * @Signdate 2014-5-18œ¬ŒÁ10:14:16
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2072 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            String str = s.nextLine();
            if(str.equals("#")){
                break;
            }
            int count = 0;
            str = str + " ";
            for(int i = 1 ; i < str.length() ; i++){
                char c = str.charAt(i);
                char back = str.charAt(i-1);
                if(c == ' ' && back!=' '){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}