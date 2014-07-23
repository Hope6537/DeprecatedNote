package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2023 {
	
	private static class Student{
		int grade [] ;
		double avg;
		public Student(int m){
			grade = new int[m];
		}
		public double getAvg(){
			double sum = 0;
			for(int i = 0 ; i < grade.length ; i++){
				sum = sum + grade[i];
			}
			this.avg = (sum*1.0 / grade.length);
			return avg;
		}
	}

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		while(s.hasNext()){
			int n = s.nextInt();
			int m = s.nextInt();
			Student [] stud = new Student[n];
			for(int i = 0 ; i < stud.length ; i++){
				stud[i] = new Student(m);
				for(int j = 0 ; j < stud[i].grade.length ; j++){
					stud[i].grade[j] = s.nextInt();
					
				}
			}
			//input done
			int flag = 0;
			for(int i = 0 ; i < stud.length ; i++){
				if(flag==1){
					System.out.print(" ");
				}
				System.out.printf("%.2f",stud[i].getAvg());
				flag=1;
			}
			System.out.println();
			//output line1 done
			double [] ke = new double [m];
			for(int i = 0 ; i < ke.length ; i++){
				for(int j = 0 ; j < stud.length ; j++){
					ke[i] = stud[j].grade[i] + ke[i];
				}
				ke[i] = ke[i] / (n*1.0);
			}
			flag = 0;
			int clearcount = 0;
			for(int i = 0 ; i < ke.length ; i++){
				if(flag==1){
					System.out.print(" ");
				}
				System.out.printf("%.2f",ke[i]);
				flag=1;
			}
			System.out.println();
			//output line2 done
			for(int i = 0 ; i<stud.length; i++){
				boolean isGuo = true;
				for(int j = 0 ; j<ke.length;j++){
					if(stud[i].grade[j] < ke[j]){
						isGuo = false;
					}
				}
				if(isGuo){
					clearcount++;
				}
			}
			System.out.println(clearcount);
			System.out.println();
			
		}
	}

}
