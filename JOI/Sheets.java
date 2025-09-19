package JOI;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sheets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[][] input = new int[n][4];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            input[i][0] = x1; input[i][1] = y1; input[i][2] = x2; input[i][3] = y2;
            pq.add(new Pair(x1, i));
        }
        PriorityQueue<Pair> vertical = new PriorityQueue<>();
        int cur = 0;
        int area = 0;
        int perimeter = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

        }
    }
    public static class Pair implements Comparable{
        int x; // enter x-value
        int y; // ind value
        public Pair (int xx, int yy) {
            x = yy; y= yy;
        }

        @Override
        public int compareTo(Object o) {
            if (x != ((Pair)o).x) return Integer.compare(x, ((Pair)o).x);
            else return Integer.compare(y, ((Pair)o).y);
        }
    }
}
