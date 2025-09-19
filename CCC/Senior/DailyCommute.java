package CCC.Senior;

import java.util.*;
public class DailyCommute {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt(), d = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < w; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            aList[b].add(a); // reverse
        }

        HashMap<Integer, Integer> index2 = new HashMap<>(); // 1 = 1, 2 =  4, 3 = 3, 4 = 2
        TreeMap<Integer, Integer> routes = new TreeMap(); // distance, # of routes
        int[] dis = bfs(aList, n);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            index2.put(i, x);
            int distance= i + dis[x];

            add(routes, distance);
        }


        for (int i = 0; i < d; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1; // 3, 4?
            int nodeA= index2.get(a);
            int nodeB=index2.get(b);
            remove (routes, a +dis[index2.get(a)]);
            remove (routes, b +dis[index2.get(b)]);

            add(routes, b + dis[index2.get(a)]);
            add(routes, a + dis[index2.get(b)]);
            index2.put(a,nodeB);
            index2.put(b,nodeA);

            System.out.println(routes.firstKey());
        }
    }
    public static void add (TreeMap<Integer, Integer> routes, int val) {
        if (routes.containsKey(val)) routes.put(val, routes.get(val) + 1);
        else routes.put(val, 1);
    }
    public static void remove (TreeMap<Integer, Integer> routes, int val) {

        if (routes.containsKey(val)) {
            int cnt=  routes.get(val) -1;
            if (cnt==0) {
                routes.remove(val);
            }else {
                routes.put(val,cnt);
            }
        }
    }

    public static int[] bfs(ArrayList<Integer>[] aList, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        boolean[] vis = new boolean[n + 1];
        vis[n] = true;
        int[] dis = new int[n + 1];
        Arrays.fill(dis, (int) 1e9);
        dis[n] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int x : aList[cur]) {
                if (!vis[x]) {
                    dis[x] = dis[cur] + 1;
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return dis;
    }
}