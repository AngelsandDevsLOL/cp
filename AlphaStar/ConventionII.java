package AlphaStar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConventionII {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ar = new int[n][3];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), t = sc.nextInt();
            ar[i][0] = a; ar[i][1] = t; ar[i][2] = i;
        }
        Arrays.sort(ar, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[2], o2[2]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });
        int cur = ar[0][0];
        int ans = 0;
        int ind = 1;
        pq.add(new Pair(ar[0][0], ar[0][1], ar[0][2]));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int endTime = cur + p.time;
            for (; ind < n; ind++) {
                if (ar[ind][0] <= endTime)
                    pq.add(new Pair(ar[ind][0], ar[ind][1], ar[ind][2]));
                else break;
            }
            ans = Math.max(ans, cur - p.start);
            cur = endTime;

            if (pq.isEmpty() && ind != n) {
                cur = ar[ind][0];
                pq.add(new Pair(ar[ind][0], ar[ind][1], ar[ind][2]));
                ind++;
            }
        }
        System.out.println(ans);
    }
    public static class Pair implements Comparable {
        int start;
        int time;
        int seniority;

        @Override
        public int compareTo(Object o) {
            return Integer.compare(seniority, ((Pair)o).seniority);
        }

        public Pair (int ss, int ee, int sss) {
            start = ss; time = ee; seniority = sss;
        }
    }
}
