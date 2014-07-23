package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2061{

static Scanner s = new Scanner(System.in);

    private static class Course{
        String name;
        double Credit;
        double Score;
        public Course(String name, double credit, double score) {
            super();
            this.name = name;
            Credit = credit;
            Score = score;
        }
        
        
    }

    public static void main(String[] args) {
        
        while(s.hasNext()){

            int n = s.nextInt();
            int flag = 0;
            for(int i = 0 ; i < n ; i++ ){
                if(flag == 1){
                    System.out.println();
                }
                
                int coursecount = s.nextInt();
                Course [] c = new Course[coursecount];
                for(int j = 0 ; j < coursecount ; j++){
                    c[j] = new Course(s.next(),s.nextDouble(),s.nextDouble());
                }
                //input
                double fenzi = 0;
                double fenmu = 0;
                boolean exist = true;
                for(int j = 0 ; j < coursecount ; j ++){
                    Course co = c[j];
                    if(co.Score<60){
                        exist = false;
                        System.out.println("Sorry!");
                        break;
                    }
                    else{
                        fenzi = co.Score * co.Credit + fenzi;
                        fenmu = co.Credit + fenmu;
                    }
                }
                if(exist){
                    double res = fenzi/fenmu;
                    System.out.printf("%.2f\r\n",res);
                }
                flag = 1;
            }
        }
    }
    
}
