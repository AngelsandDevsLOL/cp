package CCC.Senior;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TruckingTroubles {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int r = scanner.nextInt();
        int d = scanner.nextInt();
        int[] dis = new int[c+1];
        dis[1] = 100000;
        ArrayList<Pair>[] aList = new ArrayList[c+1];
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 1; i < c + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            aList[x].add(new Pair(x,y,w));
            aList[y].add(new Pair(y,x,w));
        }
        pq.add(1);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (Pair p : aList[cur]) {
                int n = Math.max(dis[p.y],Math.min(p.weight,dis[p.x]));
                if (n != dis[p.y]) {
                    pq.add(p.y);
                    dis[p.y] = n;
                }
            }
        }
        int smallest = 100000;
        for (int i = 0; i < d; i++) {
            int destination = scanner.nextInt();
            if (dis[destination] < smallest) smallest = dis[destination];
        }
        System.out.println(smallest);
    }
    public static class Pair{
        int x;
        int y;
        int weight;
        public Pair(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    static class c implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.x - b.x;
        }
    }
}
