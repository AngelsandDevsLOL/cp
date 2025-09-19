package CCC.Senior;

import java.util.*;
import java.io.*;

public class Tourism2
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static long[] memo;
    public static int[][] sparse;
    public static int n;
    public static void main(String[] args) throws IOException{
        n = readInt();
        int k = readInt();
        memo = new long[n + 2];
        sparse = new int[n][(int) Math.ceil(Math.log(n) / Math.log(2)) + 1];
        for (int i = 1; i <= n; i++) {
            int a = readInt();
            sparse[i - 1][0] = a;
        }
        for (int i = 1; i < sparse[0].length; i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                sparse[j][i] = Math.max(sparse[j][i - 1], sparse[j + (1 << (i - 1))][i - 1]);
            }
        }
        System.out.println(recurs((int) Math.ceil(n * 1.0 / k), k, n));
    }
    public static long recurs (int daysLeft, int k, int attractionsLeft) {
        if (attractionsLeft == 0) return 0;
        if (memo[attractionsLeft] != 0) return memo[attractionsLeft];

        long ans = 0; // as long as daysLeft * k <= attractionsLeft, then yay !
        // (daysLeft - 1) * k >= attractionsLeft - i
        // i >= attractionsLeft - (daysLeft - 1) * k;
        for (int i = attractionsLeft - (daysLeft - 1) * k; i <= k && i <= attractionsLeft; i++) {
            ans = Math.max(ans, find(n - attractionsLeft + 1, n - attractionsLeft + i) + recurs(daysLeft - 1, k, attractionsLeft - i));
        }
        return memo[attractionsLeft] = ans;
    }
    public static int find (int l, int r) {
        int dif = r - l + 1;
        int exp = (int) (Math.log(dif) / Math.log(2));
        if (dif == Math.pow(2, exp)) return sparse[l - 1][exp];
        return Math.max(find(l, r - (int) Math.pow(2, exp)), sparse[r - (int) Math.pow(2, exp)][exp]);
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