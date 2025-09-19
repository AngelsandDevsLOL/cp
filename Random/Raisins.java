package Random;

import java.util.*;
import java.io.*;

public class Raisins {
    public static int[][][][] dp;
    public static int[][] psa;
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        psa = new int[n + 1][m + 1];
        dp = new int[n + 1][n + 1][m + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                psa[i][j] = readInt() + psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
            }
        }
        System.out.println(meth(1, n, 1, m));
    }
    public static int meth (int x1, int x2, int y1, int y2)  {
        if (x1 == x2 && y1 == y2) return 0;
        if (dp[x1][x2][y1][y2] != 0) return dp[x1][x2][y1][y2];
        dp[x1][x2][y1][y2] = Integer.MAX_VALUE;
        int num = psa[x2][y2] - psa[x1 - 1][y2] - psa[x2][y1 - 1] + psa[x1 - 1][y1 - 1];
        for (int i = x1; i < x2; i++) {
            dp[x1][x2][y1][y2] = Math.min(meth(x1, i, y1, y2) + meth(i + 1, x2, y1, y2) + num, dp[x1][x2][y1][y2]);
        }
        for (int i = y1; i < y2; i++) {
            dp[x1][x2][y1][y2] = Math.min(meth(x1, x2, y1, i) + meth(x1, x2, i + 1, y2) + num, dp[x1][x2][y1][y2]);
        }
        return dp[x1][x2][y1][y2];
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
