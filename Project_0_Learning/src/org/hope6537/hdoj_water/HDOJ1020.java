package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1020{

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            int n = s.nextInt();
            for (int k = 0; k < n; k++) {
                String string = s.next();
                String newString = "";
                char[] str = string.toCharArray();
                for (int i = 0; i < str.length; i++) {
                    char temp = str[i];
                    if (temp == '#') {
                        continue;
                    } else {
                        int count = 1;
                        for (int j = i+1; j < str.length;j++) {
                            if (temp == str[j]) {
                                count++;
                                str[j] = '#';
                            }else{
                                break;
                            }
                        }
                        newString = newString
                                + (count <= 1 ? "" : count) + temp;
                    }

                }
                System.out.println(newString);

            }
        }
    }
}
