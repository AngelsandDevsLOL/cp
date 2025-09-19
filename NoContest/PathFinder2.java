package NoContest;

import java.util.*;
import java.io.*;

public class PathFinder2 {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        long m = readInt();
        int k = readInt();
        HashSet<Long> ar = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int r = readInt() - 1, c = readInt() - 1;
            ar.add((long) r * m + c);
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}};
        HashSet<Long> reached = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (long x : ar) { // go through every obstacle cell - 10^5
            int yy = (int) (x % m);
            int xx = (int) (x / m);
            if (reached.contains(x)) {
                continue;
            } else {
                reached.add(x);
            }
            boolean[] trapped = new boolean[4];
            if (xx == 0) trapped[0] = true;
            else if (xx == n - 1) trapped[1] = true;
            if (yy == 0) trapped[2] = true;
            else if (yy == m - 1) trapped[3] = true;
            q.add(xx);
            q.add(yy);
            while (!q.isEmpty()) {
                int curX = q.poll(), curY = q.poll();
                for (int i = 0; i < 8; i++) {
                    int newX = curX + directions[i][0];
                    int newY = curY + directions[i][1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && ar.contains(newX * m + newY)) {
                        if (reached.contains(newX * m + newY)) { continue;
                        } else {
                            reached.add(newX * m + newY);
                        }
                        q.add(newX);
                        q.add(newY);
                        if (newX == 0) trapped[0] = true;
                        else if (newX == n - 1) trapped[1] = true;
                        if (newY == 0) trapped[2] = true;
                        else if (newY == m - 1) trapped[3] = true;
                    }
                }
            }
            if ((trapped[0] && trapped[1]) || (trapped[2] && trapped[3]) || (trapped[0] && trapped[2]) || (trapped[1] && trapped[3])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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