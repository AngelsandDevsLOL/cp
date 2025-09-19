package Random;

import java.util.*;
import java.io.*;

public class
DynamicRangeMinimumTest {
    public static int[] ar;
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        int height = (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
        ar = new int[(int)Math.pow(2, height)];
        Arrays.fill(ar, Integer.MAX_VALUE);
        int[] input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input[i] = readInt();
        }
        build(1, n, 1, input);
        for (int i = 0; i < m; i++) {
            String[] in = readLine().split(" ");
            if (in[0].equals("Q")) {
                System.out.println(query(1, n, Integer.parseInt(in[1]) + 1, Integer.parseInt(in[2]) + 1, 1));
            } else {
                update(1, n, Integer.parseInt(in[1]) + 1, 1, Integer.parseInt(in[2]));
            }
        }
    }
    public static int build (int l, int r, int ind, int[] input) {
        if (l == r) {ar[ind] = input[l]; return ar[ind];}
        int left = build(l, (l + r) / 2, ind * 2, input);
        int right = build((l + r) / 2 + 1, r, ind * 2 + 1, input);
        ar[ind] = Math.min(left, right);
        return ar[ind];
    }
    public static void update (int l, int r, int num, int ind, int update) {
        if (l != r) {
            int mid = (l + r) / 2;
            if (num > mid) { // right
                update(mid + 1, r , num, 2 * ind + 1, update);
            } else { // left
                update(l, mid, num, 2 * ind, update);
            }
            ar[ind] = Math.min(ar[ind * 2], ar[ind * 2 + 1]);
        } else {
            ar[ind] = update;
        }
    }
    public static int query (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) return ar[ind];
        if (l == r) return ar[ind];
        if (rr <= (l + r) / 2) {
            return query(l, (l + r) / 2, ll, rr, ind * 2);
        } else if (ll >= (l + r) / 2 + 1) {
            return query((l + r) / 2 + 1, r, ll, rr, ind * 2 + 1);
        }
        return Math.min(query(l, (l + r) / 2, ll, (l + r) / 2, ind * 2), query((l + r) / 2 + 1, r, (l + r) / 2 + 1, rr, ind * 2 + 1));
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
