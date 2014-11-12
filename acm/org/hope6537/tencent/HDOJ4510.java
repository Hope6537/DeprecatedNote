package org.hope6537.tencent;

import java.util.Scanner;

public class HDOJ4510 {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = s.nextInt();
		while (n-- != 0) {
			String now = s.next();
			String back = s.next();
			String[] ns = now.split(":");
			String[] bs = back.split(":");
			int nowh = Integer.parseInt(ns[0]), nowm = Integer.parseInt(ns[1]), nows = Integer
					.parseInt(ns[2]);
			int backh = Integer.parseInt(bs[0]), backm = Integer
					.parseInt(bs[1]), backs = Integer.parseInt(bs[2]);
			int borrowm = nows - backs < 0 ? 1 : 0;
			int news = nows - backs < 0 ? nows + 60 - backs : nows - backs;
			int borrowh = nowm - borrowm - backm < 0 ? 1 : 0;
			int newm = nowm - borrowm - backm < 0 ? nowm + 60 - borrowm - backm
					: nowm - borrowm - backm;
			int newh = 0;
			if (nowh - borrowh - backh < 0) {
				newh = (((backh + borrowh) / 24) + 1) * 24 + nowh - borrowh
						- backh;
			} else {
								newh = nowh - borrowh - backh;
			}
			newh = newh % 24 >= 12 ? newh - 12  : newh % 24;
			System.out.printf("%s:%s:%s\r\n", newh < 10 ? "0" + newh : newh + "",
					newm < 10 ? "0" + newm : newm + "", news < 10 ? "0" + news
							: news + "");
		}
	}
}
