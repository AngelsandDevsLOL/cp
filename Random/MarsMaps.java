package Random;

import java.util.*;
import java.io.*;

public class MarsMaps {
    public static int[] seg;
    //public static int[] lazy;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        seg = new int[(int)Math.pow(2, Math.ceil(Math.log(3 * 1e4) / Math.log(2)) + 1)];
        //lazy = new int[seg.length];
        PriorityQueue<Obj> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x1 = readInt(), y1 = readInt() + 1, x2 = readInt(), y2 = readInt();
            pq.add(new Obj(x1, y1, y2, 1));
            pq.add(new Obj(x2, y1, y2, -1));
        }
        int curX = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            Obj o = pq.poll();
            ans += (o.x - curX) * seg[1];
            update(1, (int) (3 * 1e4), o.y1, o.y2, o.val, 1);
            curX = o.x;
        }
        System.out.println(ans);
    }
    public static void update (int l, int r, int ll, int rr, int val, int ind) {
        /*if (lazy[ind] != 0) {
            seg[ind] += lazy[ind] * (r - l + 1);
            if (l != r) {
                lazy[ind * 2] += lazy[ind];
                lazy[ind * 2 + 1] += lazy[ind];
            }
        }*/
        if (l == r) {
            seg[ind] += val;
            /*if (l != r) {
                lazy[ind * 2] += val;
                lazy[ind * 2 + 1] += val;
            }*/
            return;
        }
        int mid = (l + r) / 2;
        if (mid < ll) {
            update(mid + 1, r, ll, rr, val, ind * 2 + 1);
        } else if (mid >= rr) {
            update(l, mid, ll, rr, val, ind * 2);
        } else {
            update(l, mid, ll, mid, val, ind * 2);
            update(mid + 1, r, mid + 1, rr, val, ind * 2 + 1);
        }
        seg[ind] = 0;
        if (l == mid) {
            seg[ind] += seg[ind * 2] >= 1 ? 1 : 0;
        } else {
            seg[ind] += seg[ind * 2];
        }
        if (mid + 1 == r) {
            seg[ind] += seg[ind * 2 + 1] >= 1 ? 1 : 0;
        } else {
            seg[ind] += seg[ind * 2 + 1];
        }
    }
    public static class Obj implements Comparable<Obj>{
        int x;
        int y1;
        int y2;
        int val;
        public Obj (int xx, int y11, int y22, int vall) {
            x = xx;
            y1 = y11;
            y2 = y22;
            val = vall;
        }

        @Override
        public int compareTo(Obj o) {
            return Integer.compare(x, o.x);
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
