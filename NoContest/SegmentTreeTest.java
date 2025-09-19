package NoContest;

import java.util.*;
import java.io.*;

public class SegmentTreeTest {
    public static int[] ar;
    public static int[] gcf;
    public static int[] count;
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        ar = new int[(int) Math.pow(2, (int) Math.ceil(Math.log(n) / Math.log(2)) + 1)];
        gcf = new int[ar.length];
        count = new int[ar.length];
        int[] input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input[i] = readInt();
        }
        build(1, n, 1, input);
        for (int i = 0; i < m; i++) {
            String[] x = readLine().split(" ");
            if (x[0].equals("C")) {
                update(1, n, Integer.parseInt(x[1]), 1, Integer.parseInt(x[2]));
            } else if (x[0].equals("G")) {
                System.out.println(findGCF(1, n, Integer.parseInt(x[1]), Integer.parseInt(x[2]), 1));
            } else if (x[0].equals("M")) {
                System.out.println(findMin(1, n, Integer.parseInt(x[1]), Integer.parseInt(x[2]), 1));
            } else {
                System.out.println(findCount(1, n, Integer.parseInt(x[1]), Integer.parseInt(x[2]), 1, findGCF(1, n ,Integer.parseInt(x[1]), Integer.parseInt(x[2]), 1)));
            }
        }
    }
    public static void build (int l, int r, int ind, int[] input) {
        if (l == r) {
            ar[ind] = input[l]; gcf[ind] = input[l]; count[ind] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, ind * 2, input);
        build(mid + 1, r, ind * 2 + 1, input);
        ar[ind] = Math.min(ar[ind * 2], ar[ind * 2 + 1]);
        gcf[ind] = gcf(gcf[ind * 2], gcf[ind * 2 + 1]);
        if (gcf[ind] == gcf[ind * 2]) count[ind] += count[ind * 2];
        if (gcf[ind] == gcf[ind * 2 + 1]) count[ind] += count[ind * 2 + 1];
    }
    public static int gcf (int x, int y) {
        if (x == 0) return y;
        return gcf(y % x, x);
    }
    public static void update (int l, int r, int find, int ind, int num) {
        if (l == r) {
            ar[ind] = num;
            gcf[ind] = num;
            count[ind] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if (mid < find) {
            update(mid + 1, r, find, ind * 2 + 1, num);
        } else {
            update(l, mid, find, ind * 2, num);
        }
        ar[ind] = Math.min(ar[ind * 2], ar[ind * 2 + 1]);
        gcf[ind] = gcf(gcf[ind * 2], gcf[ind * 2 + 1]);
        count[ind] = 0;
        if (gcf[ind] == gcf[ind * 2]) count[ind] += count[ind * 2];
        if (gcf[ind] == gcf[ind * 2 + 1]) count[ind] += count[ind * 2 + 1];
    }
    public static int findGCF (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) return gcf[ind];
        int mid = (l + r) / 2;
        if (ll >= mid + 1) {
            return findGCF(mid + 1, r, ll, rr, ind * 2 + 1);
        } else if (rr <= mid) {
            return findGCF(l, mid, ll, rr, ind * 2);
        }
        return gcf(findGCF(l, mid, ll, mid, ind * 2), findGCF(mid + 1, r, mid + 1, rr, ind * 2 + 1));
    }
    public static int findMin (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) return ar[ind];
        int mid = (l + r) / 2;
        if (rr <= mid) {
            return findMin(l, mid, ll, rr, ind * 2);
        } else if (ll >= mid + 1) {
            return findMin(mid + 1, r, ll, rr, ind * 2 + 1);
        }
        return Math.min(findMin(l, mid, ll, mid, ind * 2), findMin(mid + 1, r, mid + 1, rr, ind * 2 + 1));
    }
    public static int findCount (int l, int r, int ll, int rr, int ind, int val) {
        if (l == ll && r == rr) return gcf[ind] == val ? count[ind] : 0;
        int mid = (l + r) / 2;
        if (rr <= mid) {
            return findCount(l, mid, ll, rr, ind * 2, val);
        } else if (ll >= mid + 1) {
            return findCount(mid + 1, r, ll, rr, ind * 2 + 1, val);
        }
        return (findCount(l, mid, ll, mid, ind * 2, val) + findCount(mid + 1, r, mid + 1, rr, ind * 2 + 1, val));
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
