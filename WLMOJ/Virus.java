package WLMOJ;

import java.util.*;
import java.io.*;

public class Virus {
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt(), pk = readInt();
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = readInt();
            aList.add(a);
            if (i != 0) {
                sum.add(aList.get(i - 1) + a);
            }
        }
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = readInt(), y = readInt();
            hMap.put(x, y);
        }
        for (int i = 0; i < pk; i++) {
            TreeMap<Integer, ArrayList<Integer>> tMap = new TreeMap<>();
            for (int j = sum.size() - 1; j >= 0; j--) {
                if (hMap.containsKey(sum.get(j))) {
                    if (tMap.containsKey(-j)) {
                        tMap.get(-j).add(hMap.get(sum.get(j)));
                    } else {
                        tMap.put(-j, new ArrayList<Integer>());
                        tMap.get(-j).add(hMap.get(sum.get(j)));
                    }
                }
            }
            for (int x : tMap.keySet()) {
                sum.remove(-x);
                for (int y : tMap.get(x)) {
                    sum.add(-x, y + aList.get(-x + 1));
                    sum.add(-x, y + aList.get(-x));
                    aList.add(-x + 1, y);
                }
            }
        }
        int s = 0;
        for (int x : aList) {
            s += x;
            s %= 1000000007;
        }
        System.out.println(s);
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
