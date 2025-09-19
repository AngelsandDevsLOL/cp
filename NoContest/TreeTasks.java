package NoContest;

import java.io.*;
import java.util.*;

public class TreeTasks {
    public static int[] parent;
    public static void main(String[] args) throws IOException { // print the diameter, then the radius
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of nodes

        ArrayList<int[]>[] aList = new ArrayList[n + 1]; // edge [node, weight]
        parent = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            aList[j] = new ArrayList<>();
        }

        for (int j = 0; j < n - 1; j++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            aList[a].add(new int[]{b, c});
            aList[b].add(new int[]{a, c});
        }
        int maxVal = bfs(1, aList, new int[n + 1]); // the index of the node with the maximum value from node 1
        int[] dis1 = new int[n + 1]; // distance array from node a
        int nextVal = bfs(maxVal, aList, dis1); // the ind of the node with the maximum value from node a
        // notice that you do not need to return dis1 because it is automatically updated in the bfs method
        int dif = dis1[nextVal]; // maximum distance

        // let a and b be the endpoints, being maxVal and nextVal respectively
        // backtracking starts
        int radius = dif;
        for (int j = nextVal; j != -1; j = parent[j]) {
            int a = dis1[j]; // distance to j from node a
            int b = dif - dis1[j]; // distance to j from node b
            if (Math.max(a, b) < radius) {
                radius = Math.max(a,b);
            }
        }
        System.out.println(dif);
        System.out.println(radius);
    }
    public static int bfs (int start, ArrayList<int[]>[] edges, int[] dis) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        boolean[] vis = new boolean[edges.length];
        vis[start] = true;
        int max = 0;
        int ind = 0;
        parent[start] = -1;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int[] edge : edges[curNode]) {
                if (!vis[edge[0]]) {
                    vis[edge[0]] = true;
                    dis[edge[0]] = dis[curNode] + edge[1];
                    if (dis[edge[0]] > max) {
                        max = dis[edge[0]];
                        ind = edge[0];
                    }
                    q.add(edge[0]);

                    parent[edge[0]] = curNode; // will only happen once since the graph is a tree!
                }
            }
        }
        return ind;
    }
    final private static int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din = new DataInputStream(System.in);
    private static byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = Read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public static String read() throws IOException {
        byte[] ret = new byte[1024];
        int idx = 0;
        byte c = Read();
        while (c <= ' ') {
            c = Read();
        }
        do {
            ret[idx++] = c;
            c = Read();
        } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
        return new String(ret, 0, idx);
    }

    public static int readInt() throws IOException {
        int ret = 0;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public static long readLong() throws IOException {
        long ret = 0;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public static double readDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = Read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private static void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private static byte Read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }

    static void print(Object o) {
        pr.print(o);
    }

    static void println(Object o) {
        pr.println(o);
    }

    static void flush() {
        pr.flush();
    }

    static void println() {
        pr.println();
    }

    static void exit() throws IOException {
        din.close();
        pr.close();
        System.exit(0);
    }
}