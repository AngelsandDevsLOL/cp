package CCO;

import java.util.*;
import java.io.*;

public class RogerSolvesAClassicRgeTreeProblem {
    public static void main (String[] args) throws IOException {
        int n = readInt(), q = readInt();
        int[][] min = new int[n][(int) (Math.log(n) / Math.log(2)) + 2];
        int[][] max = new int[n][(int) (Math.log(n) / Math.log(2)) + 2];
        for (int i = 0; i < n; i++) {
            int x = readInt();
            min[i][0] = x;
            max[i][0] = x;
        }
        for (int i = 1; i <= Math.log(n)/Math.log(2); i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                min[j][i] = Math.min(min[j][i - 1], min[j + (1 << i - 1)][i - 1]);
                max[j][i] = Math.max(max[j][i - 1], max[j + (1 << i - 1)][i - 1]);
            }
        }
        for (int i = 0; i < q; i++) {
            int x = readInt(), y = readInt();
            int v = (int) (Math.log(y - x + 1) / Math.log(2));
            int num1 = max[x - 1][v];
            int num2 = max[(int) (y - Math.pow(2, v))][v];
            int num3 = min[x - 1][v];
            int num4 = min[(int) (y - Math.pow(2, v))][v];
            System.out.println(Math.max(num1, num2) - Math.min(num3, num4));
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
