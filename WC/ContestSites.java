package WC;

import java.util.*;

public class ContestSites { // doesn't work, not sure why- likely because of BFS
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long k = sc.nextLong();
        int[] pep = new int[n + 1];
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            pep[i] = sc.nextInt();
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), d = sc.nextInt();
            aList[b].add(a); // 0 = next town // 2 = next town
            aList[b].add(d); // 1 = distance // 3 = distance
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));
        long[] disA = new long[n + 1];
        long[] disB = new long[n + 1];
        Arrays.fill(disA, -1);
        Arrays.fill(disB, -1);
        while (!pq.isEmpty()) { // dijkstra's
            Pair p = pq.poll();
            if (disA[p.node] <= p.dis && disA[p.node] != -1) continue;
            disA[p.node] = p.dis;
            for (int i = 0; i < aList[p.node].size(); i += 2) {
                int next = aList[p.node].get(i);
                if (disA[next] == -1 || disA[next] > p.dis + aList[p.node].get(i + 1)) {
                    pq.add(new Pair(next, p.dis + aList[p.node].get(i + 1)));
                }
            }
        }
        pq.add(new Pair(2, 0));
        while (!pq.isEmpty()) { // dijkstra's again
            Pair p = pq.poll();
            if (disB[p.node] <= p.dis && disB[p.node] != -1) continue;
            disB[p.node] = p.dis;
            for (int i = 0; i < aList[p.node].size(); i += 2) {
                int next = aList[p.node].get(i);
                if (disB[next] == -1 || disB[next] > p.dis + aList[p.node].get(i + 1)) {
                    pq.add(new Pair(next, p.dis + aList[p.node].get(i + 1)));
                }
            }
        }
        long total = 0;
        TreeMap<Long, Long> tMap = new TreeMap<>(); // [saved, # of people]
        for (int i = 2; i <= n; i++) { // loop through each town
            if (pep[i] == 0) continue;
            if (disA[i] == -1) {
                if (disB[i] == -1 || k < pep[i]) {
                    System.out.println(-1);
                    return; // literlaly impossible
                }
                k -= pep[i];
                total += (long) (pep[i]) * disB[i]; // must go to the second site
            } else {
                total += (long) (pep[i]) * disA[i]; // going to first site
                if (disA[i] > disB[i]) {
                    if (tMap.containsKey(disB[i] - disA[i])) {
                        tMap.put(disB[i] - disA[i], tMap.get(disB[i] - disA[i]) + pep[i]);
                    } else {
                        tMap.put(disB[i] - disA[i], (long) pep[i]);
                    }
                }
            }
        }
        for (long x : tMap.keySet()) {
            if (k < tMap.get(x)) {
                total += (x * k);
            } else total += x * tMap.get(x);
            k -= tMap.get(x);
            if (k <= 0) break;
        }
        System.out.println(total);
    }
    static class Pair implements Comparable{
        int node;
        long dis;
        public Pair (int nodee, long diss) {
            dis = diss; node = nodee;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(dis, ((Pair)o).dis);
        }
    }
}
