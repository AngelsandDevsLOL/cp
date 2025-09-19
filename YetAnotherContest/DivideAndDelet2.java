package YetAnotherContest;

import java.util.*;
import java.io.*;

public class DivideAndDelet2 {
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[] input = new int[n];
        long ans = 0;

        int[] sieve = sieve();
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            input[i] = readInt();
            if (input[i] == 1) { tSet.add(-i); continue;}
            int largestPrime = sieve[input[i]];
            if (tSet.lower(-(i - largestPrime + 1)) == null) continue;
            int num = tSet.lower(-(i - largestPrime + 1));
            TreeSet<Integer> temp = new TreeSet<>();
            temp.addAll(tSet);
            for (int x : temp) {
                ans += i + x;
                tSet.remove(x);
                if (x == num) {
                    break;
                }
            }
        }
        for (int x : tSet) {
            ans += n + x;
        }
        System.out.println(ans);
    }
    public static int[] sieve () {
        int[] notPrime = new int[(int) 1e6 + 1];
        for (int i = 2; i < notPrime.length; i++) {
            if (notPrime[i] == 0) {
                for (int j = i + i; j < notPrime.length; j += i) {
                    notPrime[j] = i;
                }
                notPrime[i] = i;
            }
        }
        return notPrime;
    }final private static int BUFFER_SIZE = 1 << 16;
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