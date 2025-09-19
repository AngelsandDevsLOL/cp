package Random;

import java.io.*;
import java.util.*;

public class Policijia {
    static int n;
    static ArrayList<Integer>[] ar;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // number of cities
        int e = scanner.nextInt(); // number of roads
        ar = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ar[a].add(b);
            ar[b].add(a);
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int g1 = scanner.nextInt();
                int g2 = scanner.nextInt();
                boolean bool = bfs(a, b, g1, g2);
                if (bool) System.out.println("yes");
                else System.out.println("no");
            } else {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                boolean bool = bfs(a, b, c);
                if (bool) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
    static boolean bfs (int a, int b, int g1, int g2) {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : ar[cur]) {
                if ((g1 == i && g2 == cur) || (g2 == i && g1 == cur)) {
                    continue;
                } else if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        if (vis[b]) return true;
        return false;
    }
    static boolean bfs (int a, int b, int c) {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == c) continue;
            for (int i : ar[cur]) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        if (vis[b]) return true;
        return false;
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