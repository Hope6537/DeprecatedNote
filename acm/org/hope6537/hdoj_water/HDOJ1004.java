package org.hope6537.hdoj_water;

import java.util.Arrays;
import java.util.Scanner;

public class HDOJ1004 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            String maxName = "";
            int max = 1;
            int n = s.nextInt();
            if (n == 0) {
                break;
            }
            String[] name = new String[n];
            for (int i = 0; i < n; i++) {
                name[i] = s.next();
            }
            // input done
            Arrays.sort(name);
            maxName = name[0];
            String tempName = name[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (name[i].equals(tempName)) {
                    count++;
                } else {
                    count = 0;
                    tempName = name[i];
                }
                if (count >= max) {
                    max = count;
                    maxName = name[i];
                }
            }
        
            System.out.println(maxName);
        }
    }
}
