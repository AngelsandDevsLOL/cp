package CCC.Senior;

import java.util.*;
import java.io.*;

public class EscapeRoom {
    public static void main(String[] args) throws IOException {
        int m = readInt(), n = readInt();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x = readInt();
                if (map.containsKey(x)) map.get(x).add(i * j);
                else {
                    HashSet<Integer> hSet = new HashSet<>();
                    hSet.add(i * j);
                    map.put(x, hSet);
                }
            }
        }
        int find = m * n;
        Queue<Integer> q = new LinkedList<>();
        q.add(find);
        boolean[] vis = new boolean[1000001];
        vis[find] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map.containsKey(cur)) {
                for (int x : map.get(cur)) {
                    if (!vis[x]) {
                        vis[x] = true;
                        q.add(x);
                    }
                    if (x == 1) {
                        System.out.println("yes");
                        return;
                    }
                }
            }
        }
        System.out.println("no");
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}