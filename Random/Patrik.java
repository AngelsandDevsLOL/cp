package Random;

import java.io.*;
import java.util.*;

public class Patrik {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = readInt();
        Stack<Integer> left = new Stack<Integer>(); // goes from left to right
        Stack<Integer> right = new Stack<Integer>(); // goes from right to left
        ArrayList<Integer> input = new ArrayList<>();
        int[] ar = new int[n];
        int c = 0;
        int last = -1;
        long count = 0;
        for (int i = 0; i < n; i++) {
            int in = readInt();
            if (last != in) {
                input.add(in);
                last = in;
                c++;
            } else {
                ar[c - 1]++;
            }
        }
        for (int i = 0; i < n; i++) {
            count += (((long) ar[i]) * (ar[i] + 1)) / 2;
        }
        for (int i = 0; i < input.size(); i++) {
            int in = input.get(i);
            while (!left.isEmpty() && left.peek() < in) {
                left.pop();
                count += (left.pop() + 1);
            }
            if (!left.isEmpty() && left.peek() == in) {
                left.pop();
                count += left.peek() + 1;
                left.push(left.pop() + 1);
                left.push(in);
            } else {
                left.push(ar[i]);
                left.push(in);
            }
        }
        for (int i = input.size()-1; i >= 0; i--) {
            int in = input.get(i);
            while (!right.isEmpty() && right.peek() < in) {
                right.pop();
                count += (right.pop() + 1);
            }
            if (!right.isEmpty() && right.peek() == in) {
                right.pop();
                right.push(right.pop() + 1);
                right.push(in);
            } else {
                right.push(ar[i]);
                right.push(in);
            }
        }
        System.out.println(count);
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