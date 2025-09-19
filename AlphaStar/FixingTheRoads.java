package AlphaStar;

import java.util.*;
import java.io.*;

public class FixingTheRoads {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt(), a = readInt() - 1, b = readInt() - 1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < m; i++) {
            int u = readInt() - 1, v = readInt() - 1;
            graph[u].add(new Pair(v, 0));
            graph[v].add(new Pair(u, 1));
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[a] = 0;
        for (Pair p : graph[a]) {
            pq.add(p);
            if (dis[p.y] == -1 || dis[p.y] > p.z)dis[p.y] = p.z;
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (Pair next : graph[p.y]) {
                if (dis[next.y] == -1 || dis[next.y] > dis[p.y] + next.z) {
                    dis[next.y] = dis[p.y] + next.z;
                    if (next.y == b) break;
                    pq.add(next);
                }
            }
        }
        System.out.println(dis[b]);
    }
    public static class Pair implements Comparable {
        int y;
        int z;
        public Pair (int yy, int zz) {y = yy; z = zz;}

        @Override
        public int compareTo(Object o) {
            return Integer.compare(z, ((Pair)o).z);
        }
    }

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
