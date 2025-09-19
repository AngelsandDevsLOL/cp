package AlphaStar;

import java.util.*;

public class ForestSunset {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), h = sc.nextInt();
            pq.add(new Pair(a, -h, 0));
            pq.add(new Pair(b, -h, 1));
        }
        tMap.put(0, 0);
        int cur = 0;
        long ans = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int x : tMap.keySet()) {
                ans += (long) (p.x - cur) * (-x);
                break;
            }
            if (p.z == 0) {
                if (tMap.containsKey(p.y)) tMap.put(p.y, tMap.get(p.y) + 1);
                else tMap.put(p.y, 1);
            } else {
                if (tMap.get(p.y) == 1) tMap.remove(p.y);
                else tMap.put(p.y, tMap.get(p.y) - 1);
            }
            cur = p.x;
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
