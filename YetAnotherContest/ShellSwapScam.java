package YetAnotherContest;

import java.io.DataInputStream;
import java.io.IOException;

public class ShellSwapScam {
    public static void main (String args[]) throws IOException {
        int m = readInt(), n = readInt(), a = readInt(), b = readInt();
        int[][] swaps = new int[n][2];
        int c = 0;
        for (int i = 0; i < n; i++) {
            int x = readInt();
            if (x != -1) {
                swaps[i][0] = x;
                swaps[i][1] = readInt();
            } else {
                c++;
                swaps[i][0] = x;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (swaps[i][0] == -1) break;
            if (swaps[i][0] == b) {
                b = swaps[i][1];
            } else if (swaps[i][1] == b) {
                b = swaps[i][0];
            }
        }
        for (int i = 0; i < n; i++) {
            if (swaps[i][0] == -1) {
                if (c > 1) {
                    c--;
                    swaps[i][0] = a;
                    if (a == 1) {
                        swaps[i][1] = 2;
                        a = 2;
                    } else {
                        swaps[i][1] = 1;
                        a = 1;
                    }
                } else {
                    if (a == b) {
                        int x = 1, y = 2;
                        if (a == 1) {
                            x = m;
                        }
                        if (a == 2) {
                            y = m;
                        }
                        a = x;
                        b = y;
                        swaps[i][0] = a;
                        swaps[i][1] = b;
                    } else {
                        swaps[i][0] = a;
                        swaps[i][1] = b;
                    } break;
                }
            } else {
                if (a == swaps[i][0]) {
                    a = swaps[i][1];
                } else if (a == swaps[i][1]) a = swaps[i][0];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(swaps[i][0] + " " + swaps[i][1]);
        }
    }final private static int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din = new DataInputStream(System.in);
    private static byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;

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
}