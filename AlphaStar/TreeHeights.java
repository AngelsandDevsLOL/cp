package AlphaStar;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TreeHeights {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i = sc.nextInt(), h = sc.nextInt(), r = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int j = 1; j <= n; j++) {
            pq.add(new Pair(j, 1));
        }
        HashSet<Pair> hSet = new HashSet<>();
        for (int j = 0; j < r; j++) {
            int x = sc.nextInt(), y = sc.nextInt();
            if (y < x) {
                int a = x;
                x = y;
                y = a;
            }
            hSet.add(new Pair(x, y));
        }
        for (Pair p : hSet) {
            pq.add(new Pair(p.x, 2));
            pq.add(new Pair(p.y, 0));
        }
        int count = 0;
        int[] ans = new int[n + 1];
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.y == 0) count--; // remove, priority #1
            else if (p.y == 1) {
                ans[p.x] = count; // get # of stacks, priority #2
            } else { // p.y == 2
                count++; // +1 on the stack, priority #3
            }
        }
        for (int j = 1; j < ans.length; j++) {
            System.out.println(h - ans[j]);
        }
    }
    public static class Pair implements Comparable {
        int x;
        int y;

        public Pair(int xx, int yy) {
            x = xx;
            y = yy;
        }
        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }

        @Override
        public boolean equals(Object obj) {
            Pair a = (Pair) obj;
            if (a.x == x && a.y == y) return true;
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
