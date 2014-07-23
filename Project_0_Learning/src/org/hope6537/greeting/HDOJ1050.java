package org.hope6537.greeting;

import java.util.Scanner;

public class HDOJ1050 {

    static Scanner s = new Scanner(System.in);

    private static class Route {
        int start;
        int end;
        int wayLong;
        boolean visit;

        public Route(int start, int end) {
            super();
            this.start = start;
            this.end = end;
            this.wayLong = end - start;
            this.visit = false;
        }

        @Override
        public String toString() {
            return "Route [end=" + end + ", start=" + start + "]";
        }

    }

    public static void main(String[] args) {
        while (s.hasNext()) {
            int T = s.nextInt();
            while (T-- != 0) {
                int n = s.nextInt();
                if (n == 0) {
                    System.out.println(0);
                } else {
                    Route[] routes = new Route[n];
                    for (int i = 0; i < routes.length; i++) {
                        int start = s.nextInt();
                        int end = s.nextInt();
                        if (start > end) {
                            int temp = start;
                            start = end;
                            end = temp;
                        }
                        routes[i] = new Route(start, end);
                    }
                    // 肯定需要排序 贪心法不对数据进行排序简直作死
                    // 先根据终点来排序吧
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (routes[i].start < routes[j].start) {
                                Route temp = routes[i];
                                routes[i] = routes[j];
                                routes[j] = temp;
                            }
                        }
                    }

                    int minutes = 0;
                    int i = 0;
                    int nums = 0;
                    Route r = routes[0];

                    // 将移动距离短的放在前面 来先移动
                    while (nums < n) {
                        if (r.visit == false) {
                            r.visit = true;
                            nums++;
                            i++;
                            minutes += 10;
                            int rend = r.end % 2 == 0 ? r.end / 2
                                    : (r.end / 2) + 1;
                            for (int i1 = i; i1 < n; i1++) {
                                Route temp = routes[i1];
                                if (!temp.visit) {

                                    int tempstart = temp.start % 2 == 0 ? temp.start / 2
                                            : (temp.start / 2) + 1;
                                    if (tempstart > rend && temp.visit == false) {
                                        rend = temp.end % 2 == 0 ? temp.end / 2
                                                : (temp.end / 2) + 1;
                                        nums++;
                                        temp.visit = true;
                                    }
                                } else {
                                    continue;
                                }

                            }
                            if (i < n) {
                                r = routes[i];
                            }

                        } else {
                            if (i < n) {
                                r = routes[++i];
                            }

                        }
                    }
                    System.out.println(minutes);
                }
            }
        }
    }
}
