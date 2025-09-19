package Random;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class TrickysTreats {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt(), c = sc.nextInt();
            tMap.put(p, c);
        }
        int curSum = 0;
        int bestSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : tMap.keySet()) {
            if ((x) * 2 + t > m) break;
            pq.add(tMap.get(x));
            curSum += tMap.get(x);
            int houses = (m - t - 2 * (x)) / t;
            while (pq.size() > houses + 1) {
                int remove = pq.poll();
                curSum -= remove;
            }
            bestSum = Math.max(curSum, bestSum);
        }
        System.out.println(bestSum);
    }
}
