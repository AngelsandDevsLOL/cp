package BackToSchool;

import java.util.*;
import java.io.*;

public class Candidates {
    public static void main (String[] args) throws IOException {
        int n = readInt(), k = readInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[readInt() - 1] = i;
        }
        ArrayList<Integer>[] futureJumps = new ArrayList[k];
        ArrayList<Integer>[] bad = new ArrayList[n]; // per person
        int[][] order = new int[n][k];
        for (int i = 0; i < n; i++) {
            bad[i] = new ArrayList<>();
            int ind = temp[i];
            for (int j = 0; j < k; j++) {
                order[ind][j] = readInt();
            }
        }
        for (int i = 0; i < k; i++) {
            futureJumps[i] = new ArrayList<>();
        }
        int[] inDeg = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j + 1 < n; j++) {
                if (order[j][i] > order[j + 1][i]) futureJumps[i].add(j);
                else if (order[j][i] < order[j + 1][i]) { bad[j].add(i); inDeg[i]++; }
            }
        }
        for (int i = 0; i < k; i++) {
            if (inDeg[i] == 0) pq.add(i);
        }
        int[] ans = new int[k];
        boolean[] vis = new boolean[n];
        int counter = 0;
        while (!pq.isEmpty()) {
            int next = pq.poll();
            ans[counter++] = next + 1;
            for (int x : futureJumps[next]) {
                if (vis[x]) continue;
                for (int y : bad[x]) {
                    if (--inDeg[y] == 0) pq.add(y);
                }
                vis[x] = true;
            }
        }
        if (ans[k - 1] != 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        } else System.out.println(-1);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
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
