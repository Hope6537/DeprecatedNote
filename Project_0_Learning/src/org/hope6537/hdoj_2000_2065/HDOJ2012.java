package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2012 {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
			int x = s.nextInt();
			int y = s.nextInt();
			if((x==y && x==0) || (x>y) || (x<-39||x>50) || (y<-39||y>50)){
				break;
			}else{
				int suCount = 0;
				for(int i = x ; i <= y ; i ++){
					int res = i*i+i+41;
					//System.out.println("res"+res);
					boolean isSU = false;
					for(int j = 2 ; j < res ; j ++){
						if(res%j==0){
							isSU = true;
						}
					}
					if(!isSU){
					suCount++;
					}
				}
				
				/*System.out.println(y-x+1);
				System.out.println(suCount);*/
				if(suCount == y-x+1){
					
					System.out.println("OK");
				}else{
					System.out.println("Sorry");
				}
			}
		}
	}

}
