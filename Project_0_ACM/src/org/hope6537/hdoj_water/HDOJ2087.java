package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ2087{

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (s.hasNext()) {
            String all = s.next();
            if (all.charAt(0) == ('#')) {
                break;
            }
            String sin = s.next();
            int count = 0;
            for (int i = 0; i < all.length(); i++) {
                String f = "";
                for (int j = i; j < all.length(); j++) {
                    f += all.charAt(j);
                    if (f.length() == sin.length()) {
                        if (f.equals(sin)) {
                            count++;
                            break;
                        }

                    }

                }
            }
            System.out.println(count);
        }
    }
}
