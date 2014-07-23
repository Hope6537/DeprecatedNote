package org.hope6537.hdoj_water;

import java.math.BigInteger;
import java.util.Scanner;

public class HDOJ1212 {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(s.hasNext()){
			BigInteger bigInteger1 = s.nextBigInteger();
			BigInteger bigInteger2 = s.nextBigInteger();
			BigInteger bigInteger3 = bigInteger1.mod(bigInteger2);
			System.out.println(bigInteger3);
		}
	}
	
	
}
