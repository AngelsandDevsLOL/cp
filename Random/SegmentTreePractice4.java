package Random;

import java.util.*;
import java.io.*;

public class SegmentTreePractice4 {
    public static int[] ar;
    public static int[] segTree;
    public static void main (String[] args) throws IOException {
        int n = readInt(), q = readInt();
        ar = new int[n + 1];
        segTree = new int[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)];
        HashMap<Integer, Pair> hMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int a = readInt();
            ar[i] = a;
        }
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        for (int i = 1; i <= q; i++) {
            pq.add(new Pair2(readInt(), readInt(), i));
        }
        int[] ans = new int[q + 1];
        int pointer = 1;
        while (!pq.isEmpty()) {
            Pair2 p = pq.poll();
            for (; pointer <= p.y; pointer++) {
                if (hMap.containsKey(ar[pointer])) {
                    Pair pair = hMap.get(ar[pointer]);
                    if (pair.y == 0) {
                        pair.y = pointer;
                        update(1, n, pointer, 1, 1);
                        update(1, n, pair.x, -1, 1);
                    } else {
                        update(1, n, pair.x, 0, 1);
                        update(1, n, pair.y, -1, 1);
                        pair.x = pair.y;
                        pair.y = pointer;
                        update(1, n, pointer, 1, 1);
                    }
                } else {
                    hMap.put(ar[pointer], new Pair(pointer, 0));
                    update(1, n, pointer, 1, 1);
                }
            }
            ans[p.ind] = (query(1, n, p.x, p.y, 1));
        }
        for (int i = 1; i <= q; i++) {
            System.out.println(ans[i]);
        }
    }
    public static void update (int l, int r, int find, int val, int ind) {
        if (l == r) {
            segTree[ind] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (find >= mid + 1) {
            update(mid + 1, r, find, val, ind * 2 + 1);
        } else if (find <= mid) {
            update(l, mid, find, val, ind * 2);
        }
        segTree[ind] = segTree[ind * 2] + segTree[ind * 2 + 1];
    }
    public static int query (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) {
            return segTree[ind];
        }
        int mid = (l + r) / 2;
        if (ll > mid) {
            return query(mid + 1, r, ll, rr, ind * 2 + 1);
        } else if (rr <= mid) {
            return query(l, mid, ll, rr, ind * 2);
        }
            int x = query(l, mid, ll, mid, ind * 2);
            int y = query(mid + 1, r, mid + 1, rr, ind * 2 + 1);
            return x + y;
    }
    public static class Pair {
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx;
            y = yy;
        }
    }
    public static class Pair2 implements Comparable<Pair2> {
        int x;
        int y;
        int ind;
        public Pair2 (int xx, int yy, int indd) {
            x = xx;
            y = yy;
            ind = indd;
        }

        @Override
        public int compareTo(Pair2 o) {
            if (y > o.y) return 1;
            if (y == o.y) {
                if (x > o.x) return 1;
            }
            return -1;
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
