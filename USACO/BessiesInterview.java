package USACO;

import java.util.*;
import java.io.*;

public class BessiesInterview {
    public static int[] dsu;
    public static void main (String[] args) throws IOException {
        int n = readInt(), k = readInt();
        TreeMap<Long, ArrayList<Integer>> tMap = new TreeMap<>();
        for (int i = 1; i <= k; i++) {
            int input = readInt();
            if (tMap.containsKey((long)input)) {
                tMap.get((long)input).add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                tMap.put((long)input, aList);
            }
        }
        dsu = new int[k + 1];
        for (int i = k + 1; i <= n; i++) {
            int input = readInt();
            long num = tMap.firstKey();
            ArrayList<Integer> farmers = tMap.get(num);
            int par1 = parent(farmers.get(0));
            if (farmers.size() == 1) {
                tMap.remove(num);
            } else {
                tMap.get(num).remove(0);
            }
            for (int j = 0; j < farmers.size(); j++) {
                int par2 = parent(farmers.get(j));
                if (par2 != par1) {
                    dsu[parent(farmers.get(j))] = par1;
                }
            }
            long newNum = input + num;
            if (tMap.containsKey(newNum)) {
                tMap.get(newNum).add(farmers.get(0));
            } else {
                ArrayList<Integer> f = new ArrayList<>();
                f.add(farmers.get(0));
                tMap.put(newNum, f);
            }
        }
        long num = tMap.firstKey();
        System.out.println(num);
        ArrayList<Integer> farmer = tMap.get(num);
        int par1 = parent(farmer.get(0));
        for (int j = 1; j < farmer.size(); j++) {
            int par2 = parent(farmer.get(j));
            if (par2 != par1) {
                dsu[parent(farmer.get(j))] = par1;
            }
        }
        for (int i = 1; i <= k; i++) {
            if (parent(i) == par1) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }
    public static int parent (int x) {
        if (dsu[x] == 0) return x;
        return dsu[x] = parent(dsu[x]);
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
