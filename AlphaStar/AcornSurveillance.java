package AlphaStar;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AcornSurveillance {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            pq.add(new Pair(a, 0, i));
            pq.add(new Pair(b, 1, i));
        }
        HashSet<Integer> current = new HashSet<>();
        int[][] value = new int[n][2];
        int cur = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.y == 0) {
                if (current.size() >= 1) ans += (p.x - cur);
                if (current.size() == 1) { // already a range overlapping
                    for (int x : current) {
                        value[x][1] = p.x;
                    }
                } else if (current.size() == 0) { // no range !
                    value[p.z][0] = p.x;
                }
                current.add(p.z);
            }
            else {
                ans += p.x - cur; // removing 1 range, has to have 1 range = add
                if (current.size() == 1) {
                    value[p.z][1] = p.x;
                }
                current.remove(p.z);
                if (current.size() == 1) {
                    for (int x : current) {
                        value[x][0] = p.x;
                    }
                }
            }
            cur = p.x;
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            smallest = Math.min(smallest, value[i][1] - value[i][0]);
        }
        System.out.println(ans - smallest);
    }
        public static class Pair implements Comparable {
        int x;
        int y;
        int z;
        public Pair (int xx, int yy, int zz) {x = xx; y = yy; z = zz;}

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }
    }
}
