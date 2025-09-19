package CCC.Senior;

import java.util.*;

public class PhonomenalReviews3 {
    public static boolean[] pho;
    public static int sum;
    public static int max = 0;
    public static int ind = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        pho = new boolean[n];
        int last = 0;
        for (int i = 0; i < m; i++) {
            last = sc.nextInt();
            pho[last] = true;
        }
        sum = n - 1;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            edges[a].add(b);
            edges[b].add(a);
        }
        remove(last, -1, edges);
        bfs(last, edges);
        max = 0;
        bfs(ind, edges);
        System.out.println(2 * sum - max);
    }
    public static boolean remove (int current, int past, ArrayList<Integer>[] edges) {
        for (int x : edges[current]) {
            if (x != past) {
                if (remove(x, current, edges)) {
                    pho[current] = true;
                }
            }
        }
        if (!pho[current]) sum--;
        return pho[current];
    }
    public static int[] bfs (int start, ArrayList<Integer>[] edges) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[edges.length];
        int[] dis = new int[edges.length];
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : edges[cur]) {
                if (!vis[i] && pho[i]) {
                    vis[i] = true;
                    dis[i] = dis[cur] + 1;
                    if (dis[i] > max) {
                        max = dis[i];
                        ind = i;
                    }
                    q.add(i);
                }
            }
        }
        return dis;
    }
}
