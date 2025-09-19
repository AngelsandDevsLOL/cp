package NoContest;

import java.util.*;
import java.io.*;

public class JaydenStudiesTrees {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Integer>[] ar = new ArrayList[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = readInt()-1;
            int b = readInt()-1;
            ar[a].add(b);
            ar[b].add(a);
        }
        boolean[] vis = new boolean[n];
        vis[0] = true;
        dfs(0, ar, vis, dis);
        int largest = 0;
        ArrayList<Integer> ends = new ArrayList<>();
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] > largest) {
                largest = dis[i];
                ends = new ArrayList<>();
                ends.add(i);
            }else if (dis[i] == largest) {
                ends.add(i);
            }
        }
        largest = 0;
        dis = new int[n];
        for (int i : ends) {
            vis = new boolean[n];
            vis[i] = true;
            dfs(i, ar, vis, dis);
            Arrays.sort(dis);
            largest = Math.max(dis[n-1], largest);
        }
        System.out.println(largest);
    }
    static void dfs (int cur, ArrayList<Integer>[] ar, boolean[] vis, int[] dis) {
        for (int i : ar[cur]) {
            if (!vis[i]) {
                dis[i] = dis[cur] + 1;
                vis[i] = true;
                dfs(i, ar, vis, dis);
            }
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}