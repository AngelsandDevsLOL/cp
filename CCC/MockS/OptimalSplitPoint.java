package CCC.MockS;

import java.util.*;
import java.io.*;

public class OptimalSplitPoint {
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[] input = new int[n];
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        TreeMap<Integer, TreeSet<Integer>> tMap = new TreeMap<>();
        long sumR = 0;
        input[0] = readInt();
        TreeSet<Integer> tSet = new TreeSet<>(); tSet.add(0);
        tMap.put(input[0], tSet);
        left.put(input[0], 1);
        long sumL = input[0];
        input[1] = readInt();
        TreeSet<Integer> tSet2 = new TreeSet<>(); tSet2.add(1);
        tMap.put(input[1], tSet2);
        for (int i = 2; i < n; i++) {
            input[i] = readInt();
            if (right.containsKey(input[i])) right.put(input[i], right.get(input[i]) + 1);
            else right.put(input[i], 1);
            if (tMap.containsKey(input[i])) {
                tMap.get(input[i]).add(i);
            } else {
                TreeSet<Integer> tSet3 = new TreeSet<>(); tSet3.add(i);
                tMap.put(input[i], tSet3);
            }
            sumR += input[i];
        }
        long min = Long.MAX_VALUE;
        int l = 0, r = 0;
        for (int i = 1; i < n - 1; i++) { // split point
            if (sumR > sumL) {
                if (sumR - sumL == 1 && min> 1) {
                    min = 1;
                    l = i;
                    r = -1;
                    continue;
                }
                int x = (int) Math.min((sumR - sumL) / 2, 1000001);
                long closest = Long.MAX_VALUE;
                if (right.ceilingKey(x) != null) {
                    closest = right.ceilingKey(x);
                }
                if (right.floorKey(x) != null) {
                    if (closest - (x) > (x) - right.floorKey(x)) {
                        closest = right.floorKey(x);
                    }
                }
                if (Math.abs(sumR - sumL - 2 * closest) < min) {
                    min = Math.abs(sumR - sumL - 2 * closest);
                    l = i;
                    r = tMap.get((int)closest).ceiling(i + 1);
                }
                if (min == 0) {
                    System.out.println((l + 1) + " " + (r + 1));
                    return;
                }
            } else if (sumR == sumL) {
                System.out.println((i + 1) + " " + -1);
                return;
            } else { // sumL > sumR
                if (sumL - sumR == 1 && min > 1) {
                    min = 1;
                    l = i;
                    r = -1;
                    continue;
                }
                int x = (int) Math.min((sumL - sumR) / 2, 1000001);
                long closest = Long.MAX_VALUE;
                if (left.ceilingKey(x) != null) {
                    closest = left.ceilingKey(x);
                }
                if (left.floorKey(x) != null) {
                    if (closest - (x) > (x) - left.floorKey(x)) {
                        closest = left.floorKey(x);
                    }
                }
                if (Math.abs(sumL - sumR - 2 * closest) < min) {
                    min = Math.abs(sumL - sumR - 2 * closest);
                    l = i;
                    r = tMap.get((int)closest).floor(i - 1);
                }
                if (min == 0) {
                    System.out.println((l + 1) + " " + (r + 1));
                    return;
                }
            }
            sumL += input[i];
            sumR -= input[i + 1];
            if (left.containsKey(input[i])) left.put(input[i], left.get(input[i]) + 1);
            else left.put(input[i], 1);
            if (right.get(input[i + 1]) == 1) right.remove(input[i + 1]);
            else right.put(input[i + 1], right.get(input[i + 1]) - 1);
        }
        System.out.println((l + 1) + " " + (r + 1));
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
