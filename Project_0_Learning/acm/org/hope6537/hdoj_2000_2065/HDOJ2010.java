package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2010 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			int first = s.nextInt();
			int last = s.nextInt();
			int flag = 0;
			boolean isHave = false;
			for(int i = first ; i <= last ; i++){
				//System.out.println(i);
				if(i ==  Math.pow((int)i/100, 3) + Math.pow((int)((i/10)%10), 3) + Math.pow((int)(i%10), 3) ){
					if(flag == 1){
						System.out.print(" ");
					}
					System.out.print(i);
					flag = 1;
					isHave = true;
				}
			}
			if(isHave == false){
				System.out.print("no");
			}
			System.out.println();
		}
		
	}

}
