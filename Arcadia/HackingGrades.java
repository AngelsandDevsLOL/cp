package Arcadia;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class HackingGrades {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] numerators = new int[n];
        Pair p = new Pair(1, 1);
        TreeMap<Pair, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            numerators[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(numerators[i], sc.nextInt());
            if (tMap.containsKey(pair)) tMap.put(p, tMap.get(p) + 1);
            else tMap.put(p, 1);
        }
        for (int i = 0; i < k; i++) {
            for (Pair x : tMap.keySet()) {
                if (tMap.get(x) == 1) tMap.remove(x);
                else tMap.put(x, tMap.get(x) - 1);
                Pair next = new Pair(x.x, x.y);
                if (tMap.containsKey(next)) tMap.put(next, tMap.get(next) + 1);
                else tMap.put(next, 1);
                break;
            }
        }
        double finalAns = 0;
        for (Pair x : tMap.keySet()) {
            finalAns += (x.x / (double)x.y) * tMap.get(x);
        }
        System.out.println(finalAns / n);
    }
    public static class Pair implements Comparable {
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }

        @Override
        public int compareTo(Object o) {
            if (((Pair)o).x * y > ((Pair)o).y * x) {
                return 1;
            } else if (((Pair)o).x * y == ((Pair)o).y * x) return 0;
            else return -1;
        }

        @Override
        public boolean equals (Object o) {
            if (((Pair)o).x * y == ((Pair)o).y * x) return true;
            else return false;
        }
    }
}
