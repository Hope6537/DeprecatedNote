package org.hope6537.datastructs.march;

public class 估计两个随机数互素的概率 {
	
	public static double probRelPrim(int n){
		int rel = 0;
		int tot = 0;
		
		for(int i = 1 ; i<= n ;i++){
			for(int j = i+1 ; j<= n;j++){
				tot++;
				if(欧几里得算法.gcd(i,j)==1){
					rel++;
				}
			}
		}
		return (double) rel/tot;
	}
	public static void main(String[] args) {
		System.out.println(probRelPrim(100000));
	}

}
