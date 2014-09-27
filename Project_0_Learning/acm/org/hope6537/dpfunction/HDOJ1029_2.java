package org.hope6537.dpfunction;

import java.util.ArrayList;
import java.util.Scanner;

public class HDOJ1029_2 {

	private static class NameValuePair {
		int index;
		int times;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getTimes() {
			return times;
		}

		public void setTimes(int times) {
			this.times = times;
		}

		public NameValuePair(int index, int times) {
			super();
			this.index = index;
			this.times = times;
		}

		public NameValuePair() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "NameValuePair [index=" + index + ", times=" + times + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NameValuePair other = (NameValuePair) obj;
			if (index != other.index)
				return false;
			return true;
		}

	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
			int n = s.nextInt();
			int times = (n + 1) / 2;
			for (int i = 0; i < n; i++) {
				int id = s.nextInt();
				NameValuePair nameValuePair = new NameValuePair();
				nameValuePair.index = id;
				if (list.contains(nameValuePair)) {
					int index = list.indexOf(nameValuePair);
					nameValuePair = list.get(index);
					nameValuePair.times++;
					list.set(index, nameValuePair);
				} else {
					nameValuePair.times++;
					list.add(nameValuePair);
				}

			}
			// input done
			int max = 0;
			for (int i = 0; i < list.size(); i++) {
				NameValuePair nameValuePair = list.get(i);
				int count = nameValuePair.getTimes();
				if (count >= times) {
					max = nameValuePair.getIndex();
					break;
				}
			}
			System.out.println(max);
		}
	}
}
