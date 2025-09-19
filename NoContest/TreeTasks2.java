package NoContest;

import java.util.*;
import java.io.*;

public class TreeTasks2 {
    static int n, dia, far, dis[], pre[];
    static List<edge>[] adj;
    public static void main (String[] args) throws IOException {
        int t = readInt();
        System.out.println(t);
        for (int k = 0; k < t; k++) {
            int n = readInt();
            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                int u = readInt(), v = readInt(), w = readInt();
                adj[u].add(new edge(v, w));
                adj[v].add(new edge(u, w));
            }
            dis = new int[n + 1];
            pre = new int[n + 1];
            far = 0;
            dia = 0;
            dfs(1, -1, 0);
            dia = 0;
            dfs(far, -1, 0);
            int dif = Integer.MAX_VALUE;
            int ind = 0;
            for (int u = far; u != -1; u = pre[u]) {
                if (Math.abs(dis[u] - (dia - dis[u])) < dif) {
                    dif = Math.abs(dis[u] - (dia - dis[u]));
                    ind = u;
                }
            }
            System.out.println(ind);
        }
    }
    static void dfs (int cur, int par, int d) {
        pre[cur] = par; dis[cur] = d;
        if (d > dia) {dia = d; far = cur;}
        for (edge e : adj[cur]) {
            if (e.v != par) dfs(e.v, cur, d + e.w);
        }
    }
    static class edge{
        int v, w;
        edge (int vv, int ww) {
            v = vv; w = ww;
        }
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
