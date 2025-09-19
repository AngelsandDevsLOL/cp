package AlphaStar;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class CitySkyline {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair((int) (1e6 + 1), 0));
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            pq.add(new Pair(x, y));
        }
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int count = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (s.peek() < p.y) {
                s.push(p.y);
                count++;
            } else if (s.peek() > p.y) {
                while (s.peek() > p.y) {
                    s.pop();
                }
                if (s.peek() == p.y) continue;
                // else s.peek < p.y
                s.push(p.y);
                count++;
            }
        }
        System.out.println(count);
    }
    public static class Pair implements Comparable {
        int x;
        int y;
        public Pair (int xx, int yy) {x = xx; y = yy;}

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }
    }
}
