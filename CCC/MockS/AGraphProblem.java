package CCC.MockS;

import java.util.*;
import java.io.*;

public class AGraphProblem {
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt(), k = readInt();
        int s = readInt(), t = readInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 2];
        for (int i = 0; i <= k; i++) {
            aList[i + 1] = new ArrayList<>();
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new c());
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), c = readInt(), d = readInt();
            pq.add(new Pair(c, 0, a, b));
            pq.add(new Pair(d + 1, 1, a, b));

        }
        boolean possible = false;
        int pointer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            count += (possible ? 1 : 0) * (p.x - pointer - 1);
            pointer = p.x;
            if (p.a == 0) {
                aList[p.y].add(p.z);
                if (!possible) {
                    possible = bfs(aList, s, t);
                }
            } else {
                aList[p.y].remove((Object)p.z);
                possible = bfs(aList, s, t);
            }
            if (possible) count++;
        }
        System.out.println(count);
    }
    public static boolean bfs(ArrayList<Integer>[] aList, int s, int t) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        boolean[] vis = new boolean[aList.length];
        vis[s] = true;
        while (!q.isEmpty()) {
            int y = q.poll();
            for (int x : aList[y]) {
                if (!vis[x]) {
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return vis[t];
    }
    static class c implements Comparator<Pair> {
        public int compare(Pair o, Pair p) {
            return o.x < p.x ? -1 : 1;
        }
    }
    public static class Pair {
        int x;
        int a;
        int y;
        int z;
        public Pair (int xx, int aa, int yy, int zz) {
            x = xx; y = yy; z = zz; a = aa;
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
