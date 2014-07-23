package org.hope6537.hdoj_water;

import java.util.Scanner;

/**
 * @Describe
 * @Author Hope6537(’‘≈Ù)
 * @Signdate 2014-05-06 10:14:57
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ2076{
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        double[] hours = new double[12];
        double[] minutes = new double[61];
        double[] seconds = new double[61];
        for (int i = 0; i < hours.length; i++) {
            double angle = i * 30;
            hours[i] = angle;

        }
        for (int i = 0; i < minutes.length; i++) {
            double angle = i * 6;
            minutes[i] = angle;
            seconds[i] = angle;
        }
        while (s.hasNext()) {
            int n = s.nextInt();
            while(n--!=0){
                double hour = s.nextDouble();
                if(hour >= 12){
                    hour =   hour - 12;
                }
                double minute = s.nextDouble();
                double second = s.nextDouble();
                double houra = hours[(int) hour];
                double minutea = minutes[(int) minute];
                double seconda = seconds[(int) second];
                double hour_angle = 0.0 +houra + (1.0*minutea/12.0) + (1.0*seconda/(720.0));
                
                double minute_angle = 0.0 + (1.0*minutea) + (1.0*seconda/60.0);
                double res = 0;
                res = (Math.max(hour_angle, minute_angle) - Math.min(hour_angle, minute_angle));
                /*if(hour_angle > 180 && minute_angle < 180){
                    hour_angle = 360 - hour_angle;
                    res = (int) (hour_angle + minute_angle);
                }
                else if(hour_angle < 180 && minute_angle > 180){
                    minute_angle = 360 - minute_angle;
                    res = (int) (hour_angle + minute_angle);
                }*/
                if(res>180){
                    res = 360 - res;
                }
                else{
                    ;
                }
                System.out.println((int)res);
            }
        }
    }
}
