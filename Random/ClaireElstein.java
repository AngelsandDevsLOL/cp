package Random;

import java.util.*;
import java.io.*;

public class ClaireElstein {
    public static long[][] dp;
    public static HashMap<Integer, Long>[] hMap;
    public static long mod = (long) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        hMap = new HashMap[n + 1];
        HashSet<Integer> hSet = new HashSet<>();
        dp = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            hMap[i] = new HashMap<>();
            hSet.add(i);
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            if (hMap[a].containsKey(b)) hMap[a].put(b, hMap[a].get(b) + 1);
            else hMap[a].put(b, 1L);
            if (hSet.contains(b)) hSet.remove(b);
        }
        long temp = 0;
        for (int x : hSet) { // indegree = 0
            ans(x);
            temp += (dp[x][0] - dp[x][1] + mod) % mod;
            temp %= mod;
        }
        System.out.println(temp);
    }

    public static void ans(int node) {
        if (dp[node][0] != 0) return;
        if (hMap[node].isEmpty()) {
            dp[node][0] = 1;
            dp[node][1] = 1;
            return;
        }
        for (int x : hMap[node].keySet()) {
            ans(x);
            dp[node][0] += (hMap[node].get(x) * dp[x][0]) % mod;
            dp[node][1] += (hMap[node].get(x) * dp[x][1]) % mod;
            dp[node][0] %= mod;
            dp[node][1] %= mod;
        }
        dp[node][0] += dp[node][1];
        dp[node][0] %= mod;
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