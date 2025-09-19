package Random;

import java.util.*;
import java.io.*;

public class ParallelUniverse {
    public static long[] ar;
    public static long[] input;
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        input = new long[n + 1];
        ar = new long[(int)Math.pow(2, (int)Math.ceil(Math.log(n) / Math.log(2)) + 1)];
        for (int i = 1; i <= n; i++) {
            long x = sc.nextLong();
            input[i] = x;
        }
        build(1, n, 1);
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String[] in = sc.nextLine().split(" ");
            if (in[0].equals("Q")) {
                System.out.println(query(1, n, Integer.parseInt(in[1]), Integer.parseInt(in[2]), 1) & Long.parseLong(in[3]));
            } else {
                update(1, n, Integer.parseInt(in[1]), 1, Long.parseLong(in[2]));
            }
        }
    }
    public static long build (int l, int r, int ind) {
        if (l == r) {ar[ind] = input[l]; return ar[ind];}
        long left = build(l, (l + r) / 2, ind * 2);
        long right = build((l + r) / 2 + 1, r, ind * 2 + 1);
        ar[ind] = (left & right);
        return ar[ind];
    }
    public static void update (int l, int r, int num, int ind, long update) {
        if (l != r) {
            int mid = (l + r) / 2;
            if (num > mid) { // right
                update(mid + 1, r , num, 2 * ind + 1, update);
            } else { // left
                update(l, mid, num, 2 * ind, update);
            }
            ar[ind] = (ar[ind * 2] & ar[ind * 2 + 1]);
        } else {
            ar[ind] = update;
        }
    }
    public static long query (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) {
            return ar[ind];
        }
        int mid = (l + r) / 2;
        if (ll >= mid + 1) {
            return query(mid + 1, r, ll, rr, ind * 2 + 1);
        } else if (rr <= mid) {
            return query(l, mid, ll, rr, ind * 2);
        } else {
            long x = query(l, mid, ll, mid, ind * 2);
            long y = query(mid + 1, r, mid + 1, rr, ind * 2 + 1);
            return x & y;
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
