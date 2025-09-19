package COCI;

import java.io.*;
import java.util.*;

public class Naboj {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        int[] in = new int[n + 1];
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt();
            int b = readInt();
            aList[a].add(b);
            aList[b].add(a);
            in[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        Stack<String> s = new Stack<>();
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (in[i] == 0) {
                q.add(i);
                vis[i] = true;
            } else if (aList[i].size() == in.length) {
                q.add(i);
                vis[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            if (in[i] == 0) {
                s.add(i + " " + 0);
                for (int x : aList[i]) {
                    in[x]--;
                    if (in[x] == 0 && !vis[x]) {
                        q.add(x);
                        vis[x] = true;
                    }
                }
            } else if (aList[i].size() == in[i]) {
                s.add(i + " " + 1);
                for (int x : aList[i]) {
                    if (aList[x].size() == in[x] && !vis[x]) {
                        q.add(x);
                        vis[x] = true;
                    }
                }
            }
        }
        if (s.size() != n) {
            System.out.println(-1);
        } else {
            System.out.println(n);
            int length = s.size();
            for (int i = 0; i < length; i++) {
                System.out.println(s.pop());
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