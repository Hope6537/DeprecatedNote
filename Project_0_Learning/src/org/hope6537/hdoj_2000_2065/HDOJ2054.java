package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2054 {

	static Scanner s = new Scanner(System.in);

	public static int isFloat(String n) {
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) == '.') {
				return i;
			}
		}
		return n.length();
	}

	public static String clearZero(String n, int split) {
		String newNumber = "";
		String f = "";
		String b = "";
		boolean isReachF = n.charAt(0) == '0' ? false : true;
		boolean isReachB = n.charAt(n.length() - 1) == '0' ? false : true;
		boolean isF = false;
		boolean isB = false;
		for (int i = 0, j = n.length() - 1;;) {
			if(isB && isF){
				if(b.equals("")){
					newNumber = f + b;
				}else{
					newNumber = f +"."+ b;
				}
				
				break;
			}
			if (i < split) {
				if (isReachF) {
					f = f + n.charAt(i);
				} else if (i + 1 < split && n.charAt(i) == '0'
						&& n.charAt(i + 1) != '0') {
					isReachF = true;
				}
				i++;
			}else{
				isF = true;
			}
			if (j > split) {
				if (isReachB) {
					b = n.charAt(j) + b;
				} else if (j - 1 > split && n.charAt(j) == '0'
						&& n.charAt(j - 1) != '0') {
					isReachB = true;
				}
				j--;
			}else{
				isB = true;	
			}
			
			
		}
		return newNumber;
	}

	/*public static String formatNumber(String n) {
		String newNumber = "";
		if (isFloat(n) == -1) {
			newNumber = clearZero(n, 1);
		} else {
			// 如果是浮点数
			int index = isFloat(n);
			String forward = "";
			String back = "";
			for (int i = 0; i < index; i++) {
				forward = forward + n.charAt(i);
			}
			for (int j = index + 1; j < n.length(); j++) {
				back = back + n.charAt(j);
			}
			boolean zresf = isAllZero(forward);
			boolean zresb = isAllZero(back);
			forward = clearZero(forward, 1);
			back = clearZero(back, 0);
			if (zresf && zresb) {
				newNumber = "0";
			} else if (zresb) {
				newNumber = forward;
			} else if (zresf) {

				newNumber = "0." + back;
			} else {
				newNumber = forward + '.' + back;
			}
		}
		return newNumber;
	}*/

	public static boolean isAllZero(String n) {
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) != '0') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		
		while (s.hasNext()) {

			String a = s.next();
			String b = s.next();

			a = clearZero(a, isFloat(a));
			b = clearZero(b, isFloat(b));
		/*	System.out.println(a+" "+b);*/
			if (a.equals(b)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}
