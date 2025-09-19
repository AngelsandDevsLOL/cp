package NoContest;

import java.util.*;
import java.io.*;

public class FastSearcj {
    public static int[] orig;
    public static int[] segTree;
    public static void main (String[] args) throws IOException {
        int n = readInt(), q = readInt();
        orig = new int[n + 1];
        segTree = new int[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2) + 1))];
        for (int i = 0; i < n; i++) {
            orig[i + 1] = readInt();
        }
        build(1, n, 1);
        int prevAns = 0;
        for (int i = 0; i < q; i++) {
            int t = readInt();
            if (t == 1) {
                int p = readInt() ^ prevAns, x = readInt() ^ prevAns;
                update(1, n, p, x, 1);
            } else {
                int l = readInt(), r = readInt(), k = readInt();
                l ^= prevAns; r ^= prevAns; k ^= prevAns;
                System.out.println(prevAns = query(1, n, l, r, k, 1));
            }
        }
    }
    public static void update (int l, int r, int find, int val, int ind) {
        if (l == r) {segTree[ind] = val; return;}
        int mid = (l + r) / 2;
        if (find > mid) {
            update(mid + 1, r, find, val, ind * 2 + 1);
        } else {
            update(l, mid, find, val, ind * 2);
        }
        segTree[ind] = Math.min(segTree[ind * 2], segTree[ind * 2 + 1]);
    }
    public static void build (int l, int r, int ind) {
        if (l == r) {segTree[ind] = orig[l]; return;}
        int mid = (l + r) / 2;
        build(mid + 1, r, ind * 2 + 1);
        build(l, mid, ind * 2);
        segTree[ind] = Math.min(segTree[ind * 2], segTree[ind * 2 + 1]);
    }
    public static int query (int l, int r, int ll, int rr, int find, int ind) {
        if (segTree[ind] >= find || rr < l || ll > rr || ll > r) return Integer.MAX_VALUE;
        if (l == r) return l;
        int mid = (l + r) / 2;
        if (ll > mid) {
            if (segTree[ind * 2 + 1] < find) {
                return query(mid + 1, r, ll, rr, find, ind * 2 + 1);
            }
            return Integer.MAX_VALUE;
        } else if (rr < mid) {
            if (segTree[ind * 2] < find) {
                return query(l, mid, ll, rr, find, ind * 2);
            }
            return Integer.MAX_VALUE;
        } else {
            //if (segTree[ind * 2] > find && segTree[ind * 2 + 1] > find) return Integer.MAX_VALUE;
            //else if (segTree[ind * 2] > find) return query(mid + 1, r, mid + 1, rr, find, ind * 2 + 1);
            //else if (segTree[ind * 2 + 1] > find) return query(l, mid, ll, mid, find, ind * 2);
            return Math.min(query(l, mid, ll, mid, find, ind * 2), query(mid + 1, r, mid + 1, rr, find, ind * 2 + 1));
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
