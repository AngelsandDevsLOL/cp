package AlphaStar;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SodaMachine {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            pq.add(new Pair(x, 0, i)); // in
            pq.add(new Pair(y, 1, i)); // out
        }
        int ans = 0;
        HashSet<Integer> current = new HashSet<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.y == 0) {current.add(p.z); ans = Math.max(ans, current.size());}
            else { // remove !
                current.remove(p.z);
            }
        }
        System.out.println(ans);
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
