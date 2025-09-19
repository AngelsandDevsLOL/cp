package CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumCostRoads {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static int n, m;
    public static List<int[]> adj[];
    public static boolean rem[];
    public static void main (String[] args) throws IOException{
        n = nextInt(); m = nextInt();
        long cost = 0;
        rem = new boolean[m + 1];
        List<int[]> edge = new ArrayList<>();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt(), c = nextInt();
            edge.add(new int[]{u, v, w ,c, i}); cost += c;
            adj[u].add(new int[]{v, w, i}); adj[v].add(new int[]{u, w,i});
        }
        Collections.sort(edge, (x,y) -> -Integer.compare(x[3], y[3]));
        for (int[] x : edge) {
            int u = x[0], v = x[1], w = x[2], c = x[3], i = x[4];
            rem[i] = true;
            if (spfa(u, v) > w) rem[i] = false;
            else cost -= c;
        }
        System.out.println(cost);
    }
    public static long spfa (int st, int ed) {
        long[] dis = new long[n + 1];
        boolean[] inq = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dis, (long)1e15);
        q.add(st);
        dis[st] = 0;
        inq[st] = true;
        while (!q.isEmpty() ){
            int u = q.poll(); inq[u] = false;
            for (int[] x : adj[u]) {
                int v = x[0], w = x[1], id = x[2];
                if (rem[id]) continue;
                if (dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    if (!inq[v]){ inq[v] = true; q.add(v);}
                }
            }
        }
        return dis[ed];
    }
    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}