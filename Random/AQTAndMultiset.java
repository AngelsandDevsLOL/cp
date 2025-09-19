package Random;

import java.io.*;
import java.util.*;

public class AQTAndMultiset {
    public static void main (String[] args) throws IOException {
        int n = readInt();
        long[] ar = new long[2 *n + 1];
        long x = 0;
        //ArrayList<Long> aList = new ArrayList<>();
        HashMap<Long, Long> hMap = new HashMap<>();
        for (int i = 0; i < 2*n + 1; i++) {
            ar[i] = readLong();
            x ^= ar[i];
        }
        for (int i = 0; i < 2*n + 1; i++) {
            long input = readLong();
            //aList.add(input);
            if (hMap.containsKey(input)) {
                hMap.put(input, hMap.get(input) + 1);
            } else {
                hMap.put(input, 1L);
            }
            x ^= input;
        }
        boolean bool = true;
        for (int i = 0; i < 2*n + 1; i++) {
            //if (aList.contains(ar[i] ^ x)) {
              //  aList.remove((Object) (ar[i] ^ x));
            if (!hMap.containsKey(ar[i] ^ x)) {
                bool = false;
                break;
            } else {
                if (hMap.get(ar[i] ^ x) == 1) {
                    hMap.remove(ar[i] ^ x);
                } else {
                    hMap.put(ar[i] ^ x, hMap.get(ar[i] ^ x) - 1);
                }
            }
        }
        if (bool) {
            System.out.println(x);
        } else {
            System.out.println(-1);
        }
    }

    final private static int BUFFER_SIZE = 1 << 16;
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
}
