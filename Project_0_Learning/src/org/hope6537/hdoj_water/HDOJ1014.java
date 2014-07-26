package org.hope6537.hdoj_water;

import java.util.Scanner;

public class HDOJ1014 {
    /**  
     *@描述：随机数种子和Mod选择问题 
     *@作者：赵鹏
     *@版本：
     *@变量： @param args
     *@返回值：void
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            long step = s.nextLong();
            long mod = s.nextLong();
            System.out.printf("%10.0f",step*1.0);
            System.out.printf("%10.0f",mod*1.0);
            String str = " ";
            if(gcd(step,mod)==1){
                str = "    Good Choice";
                System.out.printf(str);
            }else{
                str = "    Bad Choice";
                System.out.printf(str);
            }
            System.out.println();
                        System.out.println();
        }
        
    }

    public static long gcd(long m , long n){
        while(n != 0){
            long rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
}
