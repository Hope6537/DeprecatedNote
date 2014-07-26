package org.hope6537.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


/**
 * @Describe 变形记 深度优先搜索
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-6-2下午12:14:57
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class HDOJ1181 {

	static boolean visit[];

	static class Node {
		char sta;

		public Node(char sta, char end) {
			super();
			this.sta = sta;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", sta=" + sta + "]";
		}

		char end;
	}



	static int n;

	static Node[] words;

	static boolean dfs(char ch) {
		if (ch == 'm') {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (words[i].sta == ch && visit[i] == false) {
				visit[i] = true;
				if (dfs(words[i].end)) {
					return true;
				}
				visit[i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			n = 0;
			words = new Node[1005];
			visit = new boolean[1005];
			String str = in.sval;
			while (str!=null) {
				words[n] = new Node(str.charAt(0), str.charAt(str.length() - 1));
				n++;
				in.nextToken();
				str = in.sval;
			}
			if (dfs('b')) {
				out.println("Yes.");
			} else {
				out.println("No.");
			}
			out.flush();
		}
	}
}
