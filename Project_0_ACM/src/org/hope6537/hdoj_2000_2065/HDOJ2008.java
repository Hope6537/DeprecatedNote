package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2008 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int num = s.nextInt();
			if(num == 0){
				break;
			}
			int z = 0;
			int o = 0;
			int f = 0;
			for(int i = 0 ; i < num ; i++){
				double d = s.nextDouble();
				if(d<0){
					f++;
				}else if(d>0){
					z++;
				}else{
					o++;
				}
			}
			System.out.println(f+" "+o+" "+z);
		}
	}
}
