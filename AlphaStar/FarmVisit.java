package AlphaStar;

import java.util.*;
import java.io.*;

public class FarmVisit {
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            aList[i] = new ArrayList<>();
        }
        char[] input = (" " + readLine()).toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int a = readInt(), b = readInt();
            aList[a].add(b);
            aList[b].add(a);
        }
        int[] dsu = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int counter = 2;
        dsu[1] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int x : aList[node]) {
                if (dsu[x] == 0) {
                    if (input[node] == input[x]) dsu[x] = dsu[node];
                    else dsu[x] = counter++;
                    q.add(x);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            String[] input2 = readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            char c = input2[2].charAt(0);
            if (input[a] == c || input[b] == c) System.out.print(1);
            else if (dsu[a] != dsu[b]) System.out.print(1);
            else System.out.print(0);
        }
        System.out.println();
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
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
