package Random;

import java.util.*;
import java.io.*;

public class JobAnger {
    public static int[] seg;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        PriorityQueue<Object> q = new PriorityQueue<>();
        TreeMap<Integer, Integer> x = new TreeMap<>();
        TreeMap<Integer, Integer> y = new TreeMap<>();
        int[][] ar = new int[n][4];
        for (int i = 0; i < n; i++) {
            int x1 = readInt(), y1 = readInt();
            int x2 = readInt(), y2 = readInt();
            ar[i][0] = x1; ar[i][1] = y1; ar[i][2] = x2;  ar[i][3] = y2;
            x.put(x1, 0);
            x.put(x2, 0);
            y.put(y1, 0);
            y.put(y2, 0);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> m : x.entrySet()) {
            m.setValue(count++);
        }
        count = 0;
        for (Map.Entry<Integer, Integer> m : y.entrySet()) {
            m.setValue(count++);
        }
        for (int i = 0; i < n; i++) {
            int x1 = x.get(ar[i][0]), x2 = x.get(ar[i][2]), y1 = y.get(ar[i][1]), y2 = y.get(ar[i][3]);
            if (x1 == x2) { // vertical line
                q.add(new Object(x1, 1, y1, y2));
            } else { // horizontal line
                q.add(new Object(x1, 0, y1, 1)); // start
                q.add(new Object(x2, 2, y1, -1)); // end
            }
        }
        seg = new int[(int)1e9];
        long ans = 0;
        while (!q.isEmpty()) {
            Object o = q.poll();
            if (o.type != 1) {
                update(0, y.size() - 1, o.a, o.b, 1);
            } else {
                ans += query(0, y.size() - 1, o.a, o.b, 1);
            }
        }
        System.out.println(ans);
    }
    public static void update (int l, int r, int find, int val, int ind) {
        if (l == r) {
            seg[ind] += val;
            return;
        }
        int mid = (l + r) / 2;
        if (find <= mid) {
            update(l, mid, find, val, ind * 2);
        } else {
            update(mid + 1, r, find, val, ind * 2 + 1);
        }
        seg[ind] = seg[ind * 2] + seg[ind * 2 + 1];
    }
    public static int query (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) return seg[ind];
        int mid = (l + r) / 2;
        if (ll > mid) {
            return query(mid + 1, r, ll, rr, ind * 2 + 1);
        } else if (rr <= mid) {
            return query(l, mid, ll, rr, ind * 2);
        }
        return query(l, mid, ll, mid, ind * 2) + query(mid + 1, r, mid + 1, rr, ind * 2 + 1);
    }
    public static class Object implements Comparable<Object>{
        int x;
        int type;
        int a;
        int b;
        public Object (int xx, int ttype, int aa, int bb) {
            x = xx; type = ttype; a = aa; b = bb;
        }

        @Override
        public int compareTo(Object o) {
            if (x != o.x) {
                return Integer.compare(x, o.x);
            }
            return Integer.compare(type, o.type);
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
