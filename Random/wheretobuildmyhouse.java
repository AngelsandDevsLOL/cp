package Random;

import java.util.*;
import java.io.*;

public class wheretobuildmyhouse {
    public static void main (String[] args) throws IOException {
        int length = readInt(), n = readInt();
        TreeSet<Integer> nums = new TreeSet<>();
        HashMap<Integer, Integer> ind = new HashMap<>();
        HashMap<Integer, Integer> ind2 = new HashMap<>();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            int l = readInt(), r = readInt();
            input[i][0] = l; input[i][1] = r;
            nums.add(l); nums.add(r);
        }
        nums.add(0);
        nums.add(length);
        int cur = 0;
        for (int x : nums) {
            ind.put(x, cur);
            ind2.put(cur++, x);
        }
        int[] psa = new int[nums.size() + 1];
        for (int i = 0; i < n; i++) {
            input[i][0] = ind.get(input[i][0]);
            input[i][1] = ind.get(input[i][1]);
            psa[input[i][0]]++;
            psa[input[i][1]]--;
        }
        ind2.put(cur, n + 1);
        int prev = 0;
        int max = 0;
        if (psa[0] != 0) prev = 1;
        for (int i = 1; i < psa.length; i++) {
            psa[i] += psa[i - 1];
            if (psa[i] == 0) {

            } else {
                max = Math.max(max, ind2.get(i) - ind2.get(prev));
                prev = i+1;
            }
        }
        System.out.println(Math.max(max, length - ind2.get(prev)));
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
