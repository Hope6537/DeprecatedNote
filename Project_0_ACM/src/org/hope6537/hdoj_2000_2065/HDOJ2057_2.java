package org.hope6537.hdoj_2000_2065;

import java.util.*;

public class HDOJ2057_2 {

	public static void main(String _[]) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			long i = Long.parseLong(s.next().replaceAll("\\+", ""), 16)
					+ Long.parseLong(s.next().replaceAll("\\+", ""), 16);
			if (i < 0)
				System.out.println("-" + Long.toHexString(-i).toUpperCase());
			else
				System.out.println(Long.toHexString(i).toUpperCase());
		}
	}

}
