package NoContest;

import java.util.*;
import java.io.*;

public class GoodStrategy {
    public static int[][] easiest;
    public static int[][] hardest;
    public static int[][] orig;
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt();
        easiest = new int[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)][2];
        hardest = new int[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)][2];
        orig = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            orig[i][0] = 0; orig[i][1] = i;
        }
        build(1, n, 1);
        for (int i = 0; i < m; i++) {
            int x = readInt();
            int y = readInt();
            if (x == 1) {
                update(1, n, y, 1, (int) 1e7);
            } else {
                update(1, n, y, 1, 1);
            }
            if (easiest[1][0] < -1e6) {
                System.out.println("Make noise");
            } else {
                System.out.println(easiest[1][1] + " " + hardest[1][1]);
            }
        }
    }
    public static void build (int l, int r, int ind) {
        if (l == r) {
            easiest[ind][0] = orig[l][0];
            easiest[ind][1] = orig[l][1];
            hardest[ind][0] = orig[l][0];
            hardest[ind][1] = orig[l][1];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, ind * 2);
        build(mid + 1, r, ind * 2 + 1);
        if (easiest[ind * 2][0] > easiest[ind * 2 + 1][0]) {
            easiest[ind][0] = easiest[ind * 2][0];
            easiest[ind][1] = easiest[ind * 2][1];
        } else if (easiest[ind * 2][0] < easiest[ind * 2 + 1][0]) {
            easiest[ind][0] = easiest[ind * 2 + 1][0];
            easiest[ind][1] = easiest[ind * 2 + 1][1];
        } else { // equal
            easiest[ind][0] = easiest[ind * 2][0];
            easiest[ind][1] = easiest[ind * 2][1];
        }
        if (hardest[ind * 2][0] < hardest[ind * 2 + 1][0]) {
            hardest[ind][0] = hardest[ind * 2][0];
            hardest[ind][1] = hardest[ind * 2][1];
        } else if (hardest[ind * 2][0] > hardest[ind * 2 + 1][0]) {
            hardest[ind][0] = hardest[ind * 2 + 1][0];
            hardest[ind][1] = hardest[ind * 2 + 1][1];
        } else { // equal
            hardest[ind][0] = hardest[ind * 2 + 1][0];
            hardest[ind][1] = hardest[ind * 2 + 1][1];
        }
    }
    public static void update (int l, int r, int f, int ind, int val) {
        if (l == r) {
            if (val == 1e7) {
                hardest[ind][0] = val;
                easiest[ind][0] = -val;
                return;
            }
            hardest[ind][0] += val;
            easiest[ind][0] += val;
            return;
        }
        int mid = (l + r) / 2;
        if (f <= mid) {
            update(l, mid, f, ind * 2, val);
        } else {
            update(mid + 1, r, f, ind * 2 + 1, val);
        }
        if (easiest[ind * 2][0] > easiest[ind * 2 + 1][0]) {
            easiest[ind][0] = easiest[ind * 2][0];
            easiest[ind][1] = easiest[ind * 2][1];
        } else if (easiest[ind * 2][0] < easiest[ind * 2 + 1][0]) {
            easiest[ind][0] = easiest[ind * 2 + 1][0];
            easiest[ind][1] = easiest[ind * 2 + 1][1];
        } else { // equal
            easiest[ind][0] = easiest[ind * 2][0];
            easiest[ind][1] = easiest[ind * 2][1];
        }
        if (hardest[ind * 2][0] < hardest[ind * 2 + 1][0]) {
            hardest[ind][0] = hardest[ind * 2][0];
            hardest[ind][1] = hardest[ind * 2][1];
        } else if (hardest[ind * 2][0] > hardest[ind * 2 + 1][0]) {
            hardest[ind][0] = hardest[ind * 2 + 1][0];
            hardest[ind][1] = hardest[ind * 2 + 1][1];
        } else { // equal
            hardest[ind][0] = hardest[ind * 2 + 1][0];
            hardest[ind][1] = hardest[ind * 2 + 1][1];
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
