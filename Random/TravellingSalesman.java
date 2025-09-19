package Random;

import java.io.*;
import java.util.*;

public class TravellingSalesman {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        ArrayList<Integer>[] ar = new ArrayList[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt() - 1;
            int b = readInt() - 1;
            ar[a].add(b);
            ar[b].add(a);
        }
        int k = readInt();
        int[] tdis = new int[n];
        HashSet<Integer> companies = new HashSet<>();
        for (int i = 0; i < k; i++) {
            boolean[] vis = new boolean[n];
            int[] dis = new int[n];
            Queue<Integer> q = new LinkedList<>();
            int office = readInt() - 1;
            q.add(office);
            companies.add(office - 1);
            vis[office] = true;
            while (!q.isEmpty()) {
                int x = q.poll();
                ArrayList<Integer> connected = ar[x];
                for (int j : connected) {
                    if (!vis[j] && !companies.contains(j)) {
                        q.add(j);
                        vis[j] = true;
                        dis[j] = dis[x] + 1;
                        if (tdis[j] > dis[j] || (tdis[j] == 0 && !companies.contains(j))) {
                            tdis[j] = dis[j];
                        }
                    }
                }
            }
        }
        Arrays.sort(tdis);
        System.out.println(tdis[tdis.length-1]);
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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
