package CCC;

import java.util.*;
import java.io.*;

public class PaintingRoad {
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ArrayList<Integer>[] aList = new ArrayList[n];
        int[] ans = new int[m];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt() - 1, b = readInt() - 1;
            aList[a].add(b);
            aList[a].add(i);
            aList[b].add(a);
            aList[b].add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(i, vis, aList, ans, -1, 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (ans[i] == 1) {
                System.out.print("R");
            } else if (ans[i] == 2) {
                System.out.print("B");
            } else {
                System.out.print("G");
            }
        }
    }
    public static void dfs (int cur, boolean[] vis, ArrayList<Integer>[] aList, int[] ans, int prev, int edge) {
        for (int i = 0; i < aList[cur].size(); i += 2) {
            int next = aList[cur].get(i);
            if (next == prev) continue;
            if (!vis[next]) {
                vis[next] = true;
                ans[aList[cur].get(i + 1)] = 3 - edge;
                dfs(next, vis, aList, ans, cur, 3 - edge);
            } else {
                if (ans[aList[cur].get(i + 1)] != 0) continue;
                ans[aList[cur].get(i + 1)] = -1;
            }
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
