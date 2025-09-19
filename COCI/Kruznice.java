package COCI;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Kruznice {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] ar = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), r = sc.nextInt();
            pq.add(new Pair(x - r, r, true, i));
            pq.add(new Pair(x + r, r, false, i));
        }
        Stack<Integer> s = new Stack<>();
        while (!pq.isEmpty()) {
            int num = pq.peek().l;
            while (!pq.isEmpty() && num == pq.peek().l) {
                Pair p = pq.poll();
                if (p.start) s.push(p.ind);
                else {
                    s.pop();
                }
            }
            if (!s.isEmpty()) ar[s.peek()] = true;
        }
        int count = 2 * n + 1;
        for (int i = 0; i < n; i++) {
            if (ar[i]) count--;
        }
        System.out.println(count);
    }
    public static class Pair implements Comparable<Pair>{
        int l;
        int r;
        boolean start;
        int ind;

        @Override
        public int compareTo(Pair o) {
            if (l != o.l) return Integer.compare(l, o.l);
            else {
                if (start && o.start) {
                    return -Integer.compare(r, o.r);
                } else if (start) {
                    return 1;
                } else if (o.start) {
                    return -1;
                } else { // both false
                    return Integer.compare(r, o.r);
                }
            }
        }
        public Pair (int ll, int rr, boolean startt, int indd) {
            l = ll; r = rr; start = startt; ind = indd;
        }
    }
}
