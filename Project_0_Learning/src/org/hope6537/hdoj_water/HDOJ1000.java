package org.hope6537.hdoj_water;

import java.util.ArrayList;
import java.util.Scanner;

public class HDOJ1000{

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (s.hasNext()) {
            list.clear();
            int a = s.nextInt();
            int b = s.nextInt();
            list.add(a);
            list.add(b);
            int sum = list.get(0) + list.get(1);
            System.out.println(sum);
        }
    }
}
