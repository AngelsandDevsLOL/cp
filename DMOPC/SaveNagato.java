package DMOPC;

import java.io.*;
import java.util.*;

public class SaveNagato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = readInt();
            int b = readInt();
            aList[a].add(b);
            aList[b].add(a);
        }
        int[] ar = bfs(n, aList, 1);
        int index = 0;
        int max = 0;
        for (int i = 0; i < n+1; i++) {
            if (max < ar[i]) {
                max = ar[i];
                index = i;
            }
        }
        int[] dis = bfs(n, aList, index);
        index = 0;
        max = 0;
        for (int i = 0; i < n+1; i++) {
            if (max < dis[i]) {
                max = dis[i];
                index = i;
            }
        }
        int[] dis2 = bfs(n, aList, index);
        int[] x = new int[n+1];
        for (int i = 1; i < dis.length; i++) {
            x[i] = Math.max(dis[i] + 1, dis2[i] + 1);
        }
        for (int i = 1; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
    static int[] bfs(int n, ArrayList<Integer>[] aList, int cur) {
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        vis[cur] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i : aList[current]) {
                if (!vis[i]) {
                    q.add(i);
                    vis[i] = true;
                    dis[i] = dis[current] + 1;
                }
            }
        }
        return dis;
    }


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