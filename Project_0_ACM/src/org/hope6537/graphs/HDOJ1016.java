package org.hope6537.graphs;

import java.io.*;


public class HDOJ1016 {
	
	static int prime[] = {0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,
	        0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1}; //数组长度60

	static boolean check(int x) {
		return prime[x] == 1 ? true:false;
	}

	static int arr[];
	static int hash[];
	static int n;

	static void dfs(int order, int index) {
		arr[order] = index;
		hash[index] = 1;
		if (order == n) {
			if (check(arr[order] + arr[1])) {
				out.print(1);
				for (int i = 2; i <= n; i++) {
					out.print(" "+arr[i]);
				}
				out.println();
				out.flush();
			}
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (hash[i] == 0 && check(arr[order] + i)) {
				dfs(order + 1, i);
				hash[i] = 0;
			}
		}

	}

	static StreamTokenizer in = new StreamTokenizer(new BufferedReader(
			new InputStreamReader(System.in)));
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int flag = 1;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int) in.nval;
			// input done
			arr = new int[100];
			hash = new int[50];
			out.println("Case " + flag + ":");
			out.flush();
			dfs(1, 1);
			flag++;
			out.println();
			out.flush();

		}

	}

}
