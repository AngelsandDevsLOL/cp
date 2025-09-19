package DMOPC;

import java.util.*;
import java.io.*;

public class LeleiAndContest {
    public static int[] orig;
    public static long[] ar;
    public static long[] lazy;
    public static int m;
    public static void main (String[] args) throws IOException {
        m = readInt();
        int n = readInt(), q = readInt();
        orig = new int[n + 1];
        ar = new long[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)];
        lazy = new long[ar.length];
        for (int i = 1; i <= n; i++) {
            orig[i] = readInt();
        }
        build(1, n, 1);
        for (int i = 0; i < q; i++) {
            int type = readInt();
            if (type == 1){
                update(1, n, readInt(), readInt(), readInt(), 1);
            } else {
                System.out.println(query(1, n, readInt(), readInt(), 1) % m);
            }
        }
    }
    public static void build (int l, int r, int ind) {
        if (l == r) {
            ar[ind] = orig[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, ind * 2);
        build(mid + 1, r, ind * 2 + 1);
        ar[ind] = ar[ind * 2] + ar[ind * 2 + 1];
    }
    /*public static void update (int l, int r, int ll, int rr, int val, int ind) {
        if (l == r) {ar[ind] += val; return;}
        if (l == ll && r == rr) {
            lazy[ind] += val;
            ar[ind] += (r - l + 1) * lazy[ind];
            int mid = (l + r) / 2;
            if (l == mid) ar[ind * 2] += lazy[ind];
            else lazy[ind * 2] += lazy[ind];

            if (r == mid + 1) ar[ind * 2 + 1] += lazy[ind];
            else lazy[ind * 2 + 1] += lazy[ind];
            lazy[ind] = 0;
            return;
        }
        if (lazy[ind] != 0) {
            ar[ind] += (r - l + 1) * lazy[ind];
            int mid = (l + r) / 2;
            if (l == mid) ar[ind * 2] += lazy[ind];
            else lazy[ind * 2] += lazy[ind];

            if (r == mid + 1) ar[ind * 2 + 1] += lazy[ind];
            else lazy[ind * 2 + 1] += lazy[ind];
            lazy[ind] = 0;
        }
        int mid = (l + r) / 2;
        if (ll >= mid + 1) {
            update(mid + 1, r , ll, rr, val, ind * 2 + 1);
        } else if (rr <= mid) {
            update(l, mid, ll, rr, val, ind * 2);
        } else {
            update(mid + 1, r , mid + 1, rr, val, ind * 2 + 1);
            update(l, mid, ll, mid, val, ind * 2);
        }
        ar[ind] = ar[ind * 2] + ar[ind * 2 + 1];
    }*/
    public static void update(int l, int r, int x, int y, int val, int cur){
        if(l == x && r == y){
            ar[cur] = (ar[cur] + (long)(r - l + 1) * val % m) %m;
            lazy[cur] = (lazy[cur] + val) %m;
            return;
        }
        if(lazy[cur] != 0)push_down(l, r, cur);
        int mid = (l+r)/2;
        if(y <= mid){
            update(l, mid, x, y, val, 2*cur);
        }
        else if(x > mid){
            update(mid+1, r, x, y, val, 2*cur+1);
        }
        else{
            update(l, mid, x, mid, val, 2*cur);
            update(mid+1, r, mid+1, y, val, 2*cur+1);
        }
        ar[cur] = (ar[2*cur] + ar[2*cur+1] )%m;
    }
    public static long query (int l, int r, int ll, int rr, int ind) {
        if (l == r) return ar[ind];
        if (lazy[ind] != 0) {
            long val = lazy[ind];
            ar[ind] += (r - l + 1) * val;
            lazy[ind] = 0;
            int mid = (l + r) / 2;
            if (l == mid) ar[ind * 2] += val;
            else lazy[ind * 2] += val;

            if (r == mid + 1) ar[ind * 2 + 1] += val;
            else lazy[ind * 2 + 1] += val;
        }
        if (l == ll && r == rr) {
            return ar[ind];
        }
        int mid = (l + r) / 2;
        if (ll >= mid + 1) {
            return query(mid + 1, r , ll, rr, ind * 2 + 1);
        } else if (rr <= mid) {
            return query(l, mid, ll, rr, ind * 2);
        }
        long x = query(mid + 1, r , mid + 1, rr, ind * 2 + 1);
        long y = query(l, mid, ll, mid, ind * 2);
        return x + y;
    }
    public static void push_down(int l, int r, int cur){
        long val = lazy[cur];
        int mid = (l+r)/2, lc = 2*cur, rc = 2*cur + 1;
        ar[lc] = (ar[lc] + (long)(mid - l + 1) * val % m) %m; lazy[lc] = (lazy[lc] + val)%m;
        ar[rc] = (ar[rc] + (long)(r - mid) * val % m) %m; lazy[rc] = (lazy[rc] + val)%m;
        lazy[cur]  = 0;

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
