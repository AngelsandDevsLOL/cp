package LCC;

import java.util.*;
import java.io.*;

public class SpaceTaxi {
    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt();
        int n = readInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            int node = readInt();
            aList[node] = new ArrayList<>();
            int edges = readInt();
            for (int j = 0; j < edges; j++) {
                aList[node].add(readInt());
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        ans[a] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : aList[cur]) {
                if (ans[next] == -1) {
                    q.add(next);
                    ans[next] = ans[cur] + 1;
                }
            }
        }
        System.out.println(ans[b] == -1 ? -1 : ans[b] - 1);
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