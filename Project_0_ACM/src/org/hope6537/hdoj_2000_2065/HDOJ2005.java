package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2005 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year, month, day;
		int days = 0;
		int i;
		while (s.hasNext()) {
			String date =  s.next();
			String [] chars = date.split("/");
			year = Integer.parseInt(chars[0]);
			month = Integer.parseInt(chars[1]);
			day = Integer.parseInt(chars[2]);
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				months[1] = 29;
				for (i = 0; i < (month - 1); i++)
					days += months[i];
				days += day;
				System.out.println(days);
				days = 0;
			} else {
				months[1] = 28;
				for (i = 0; i < (month - 1); i++)
					days += months[i];
				days += day;
				System.out.println(days);
				days = 0;
			}

			/*
			 * try { String date = s.next(); SimpleDateFormat sd1 = new
			 * SimpleDateFormat("yyyy/MM/dd"); SimpleDateFormat sd2 = new
			 * SimpleDateFormat("yyyy"); Date d1 = new Date(); Date d2 = new
			 * Date(); d1 = sd1.parse(date); d2 = sd2.parse(date);
			 * System.out.println(d1); System.out.println(d2);
			 * System.out.println(d1); int day = (int) (((d1.getTime() -
			 * d2.getTime())/1000/60/60/24)+1); System.out.println(day); } catch
			 * (ParseException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */}
	}
}
