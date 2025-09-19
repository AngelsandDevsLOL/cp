package NoContest;

import java.io.*;
import java.util.*;

public class BobsPortalTravel {
    static int bool = -1;
    static int[] x;
    static int[] distance;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {

        int n = readInt();
        long k = readLong();
        ArrayList<Integer>[] ar = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            ar[i].add(readInt()-1);
        }
        boolean[] vis = new boolean[n];
        vis[0] = true;
        boolean[] dfsvis = new boolean[n];
        dfsvis[0] = true;
        distance = new int[n];

        recursion(0, ar, vis, dfsvis, new int[n],0);
        ArrayList<Integer> route = new ArrayList<>();
        int integer = x[bool];
        while (integer != bool) {
            route.add(integer);
            integer = x[integer];
        }
        /*
        vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.add(0);
        int[] dis = new int[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : ar[cur]) {
                if (i == bool) {
                    dis[i] = dis[cur] + 1;
                    break;
                } else {
                    if (!vis[i]) {
                        vis[i] = true;
                        dis[i] = dis[cur] + 1;
                        q.add(i);
                    }
                }
            }
        }
        */

        route.add(bool);
        if (k >= distance[bool]) {
            k -= distance[bool];
            k = k % route.size();
            System.out.println(route.get((int) (route.size() - 1 - k)) + 1);
        } else {
            for (int i = 0; i < n; i++) {
                if (distance[i] == k) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
    public static void recursion (int cur, ArrayList<Integer>[] ar, boolean[] vis, boolean[] dfsvis, int[] last, int ds) {
        for (int i : ar[cur]) {
            if (dfsvis[i]) {
                last[i] = cur;
                bool = i;
                x = last;
                return;
            }
            if (!vis[i]) {
                ds++;
                distance[i]=ds;
            }
            if (bool != -1) {
                return;
            }else {

                vis[i] = true;

                dfsvis[i] = true;
                last[i] = cur;
                recursion(i, ar, vis, dfsvis, last,ds);
            }
        }
        dfsvis[cur] = false;
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
