package COCI;

import java.util.*;
import java.io.*;

public class Vrsta {
    public static long[] segTree;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[][] ar = new int[n][2];
        TreeSet<Integer> tSet = new TreeSet<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = readInt(), a = readInt();
            ar[i][0] = v; ar[i][1] = a;
            tSet.add(v);
        }
        HashMap<Integer, Integer> ind = new HashMap<>();
        int count = 0;
        for (int x : tSet) {
            hMap.put(x, ++count);
            ind.put(count, x);
        }
        segTree = new long[(int)Math.pow(2, (int)Math.ceil(Math.log(hMap.size()) / Math.log(2)) + 1)];
        for (int i = 0; i < n; i++) {
            ar[i][0] = hMap.get(ar[i][0]);
            update(1, hMap.size(), ar[i][0], ar[i][1], 1);
            System.out.println(ind.get(query(1, hMap.size(), 0, (segTree[1] + 1) / 2, 1)));
        }

    }
    public static void update (int l, int r, int find, int val, int ind) {
        if (l == r) {
            segTree[ind] += val;
            return;
        }
        int mid = (l + r) / 2;
        if (find > mid) {
            update(mid + 1, r, find, val, ind * 2 + 1);
        } else {
            update(l, mid, find, val, ind * 2);
        }
        segTree[ind] = segTree[ind * 2] + segTree[ind * 2 + 1];
    }
    public static int query (int l, int r, long ll, long find, int ind) {
        if (l == r) return l;
        long midVal = ll + segTree[ind * 2];
        int midInd = (l + r) / 2;
        if (find > midVal) {
            return query(midInd + 1, r, midVal, find, ind * 2 + 1);
        } else {
            return query(l, midInd, ll, find, ind * 2);
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
