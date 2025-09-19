package USACO;

import java.util.*;
import java.io.*;

public class MultiplayerMoo {
    public static int[][] input, ar;
    public static int[] size, country;
    public static HashMap<Integer, HashSet<Integer>>[] hMap;
    public static int ans;
    public static HashSet<Integer> untouched;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        input = new int[n][n];
        hMap = new HashMap[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = readInt();
                hMap[i * n + j + 1] = new HashMap<>();
            }
        }
        int count = 0;
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ar = new int[n][n];
        untouched = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] == 0) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    ar[i][j] = ++count;
                    untouched.add(count);
                    while (!q.isEmpty()) {
                        int x = q.poll(), y = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = x + direction[k][0], newY = y + direction[k][1];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                                if (ar[newX][newY] == 0) {
                                    if (input[newX][newY] == input[i][j]) {
                                        ar[newX][newY] = count;
                                        q.add(newX);
                                        q.add(newY);
                                    }
                                } else {
                                    HashMap<Integer, HashSet<Integer>> temp1 = hMap[ar[newX][newY]];
                                    if (temp1.containsKey(input[i][j])) temp1.get(input[i][j]).add(count);
                                    else {
                                        HashSet<Integer> hSet = new HashSet<>();
                                        hSet.add(count);
                                        temp1.put(input[i][j], hSet);
                                    }
                                    HashMap<Integer, HashSet<Integer>> temp2 = hMap[count];
                                    if (temp2.containsKey(input[newX][newY]))
                                        temp2.get(input[newX][newY]).add(ar[newX][newY]);
                                    else {
                                        HashSet<Integer> hSet = new HashSet<>();
                                        hSet.add(ar[newX][newY]);
                                        temp2.put(input[newX][newY], hSet);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        size = new int[count + 1];
        country = new int[count + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = ar[i][j];
                size[num]++;
                country[num] = input[i][j];
            }
        }
        for (int i = 1; i < count; i++) {
            HashMap<Integer, HashSet<Integer>> temp = hMap[i];
            if (!untouched.contains(i)) continue;
            for (int key : temp.keySet()) {
                ans = Math.max(ans, recursion(i, country[i], key, new boolean[count + 1], i));
            }
            untouched.remove(i);
        }
        Arrays.sort(size);
        System.out.println(size[count]);
        System.out.println(ans);
    }

    public static int recursion(int cur, int x, int y, boolean[] vis, int first) {
        int ret = size[cur];
        vis[cur] = true;
        for (int next : hMap[cur].get(y)) {
            if (!untouched.contains(next)) return -1;
            if (!vis[next]) {
                int num = recursion(next, y, x, vis, first);
                if (num == -1) return -1;
                ret += num;
            }
        }
        if (cur != first) hMap[cur].remove(y);
        return ret;
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