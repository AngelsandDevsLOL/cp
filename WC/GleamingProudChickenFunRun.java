package WC;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class GleamingProudChickenFunRun {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() + 1, b = sc.nextInt() + 1;
            pq.add(new Pair(a, b));
        }
        // 3 states:
        // 0 - dangerous !
        // 1 - YIPPEE
        int cur = 0;
        int state = 0; // not actually used
        int end = 0; // if state = 0, whe nwas the last place that was "Safe" ig
        int ans = 0;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.y >= 0) { // {p.x, p.y} both +
                if (tMap.containsKey(-p.y)) tMap.put(-p.y, tMap.get(-p.y) + 1);
                else tMap.put(-p.y, 1);
                pq.add(new Pair(p.y, -p.x));
                // if (end <= p.x) state = 0; uh oh;
            } else { // {p.y, -p.x} pos, neg
                if (end <= -p.y) {
                    int num = -tMap.higherKey(Integer.MIN_VALUE);
                    end = num;
                    ans++;
                    if (tMap.get(-p.x) == 1) tMap.remove(-p.x);
                    else tMap.put(-p.x, tMap.get(-p.x) - 1);
                } else {
                    if (tMap.get(-p.x) == 1) tMap.remove(-p.x);
                    else tMap.put(-p.x, tMap.get(-p.x) - 1);
                }
            }
        }
        System.out.println(ans);
    }
    public static class Pair implements Comparable{
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }

        @Override
        public int compareTo(Object o) {
            if (((Pair)o).x == x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }
    }
}
