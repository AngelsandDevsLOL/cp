package WC;

import java.util.*;
import java.io.*;

public class ContestSites2 {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), k = readInt();
        int[] people = new int[n + 1];
        ArrayList<Integer>[] aList = new ArrayList[n + 1]; // a reversed
        for (int i = 1; i <= n; i++) {
            int x = readInt();
            people[i] = x;
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt(), d = readInt();
            aList[b].add(a);
            aList[b].add(d);
        }
        long[] dis1 = new long[n + 1];
        Arrays.fill(dis1, -1);
        dis1[1] = 0;
        // dfs(dis1, 1, aList);
        long[] dis2 = new long[n + 1];
        Arrays.fill(dis2, -1);
        dis2[2] = 0;
        // dfs(dis2, 2, aList);
        bfs(dis1, 1, aList);
        bfs(dis2, 2, aList);
        TreeMap<Long, Long> tMap = new TreeMap<>();
        long ans = 0;
        for (int i = 2; i <= n; i++) {
            if (people[i] == 0) continue;
            if (dis1[i] == -1 && dis2[i] == -1) {
                System.out.println(-1);
                return;
            }
            if (dis1[i] == -1 && dis2[i] != -1) {
                if (k >= people[i]) {
                    k -= people[i];
                    ans += people[i] * dis2[i];
                } else { // not enough spots for ppl sucks to suck
                    System.out.println(-1);
                    return;
                }
            } else if (dis1[i] != -1 && (dis2[i] == -1 || dis1[i] <= dis2[i])) {
                ans += people[i] * dis1[i];
            } else {
                // add into tMap
                // dis2[i] < dis1[i]
                long dif = -dis1[i] + dis2[i]; // negative, we want to get the max (or extreme min) of this!
                if (tMap.containsKey(dif)) tMap.put(dif, tMap.get(dif) + people[i]);
                else tMap.put(dif, (long) people[i]);
                ans += dis1[i] * people[i];
            }
        }
        for (long num : tMap.keySet()) {
            if (k <= 0) break;
            long pep = tMap.get(num);
            ans += num * Math.min(pep, k);
            k -= pep;
        }
        System.out.println(ans);
    }

    public static void dfs(long[] dis, int node, ArrayList<Integer>[] aList) {
        for (int i = 0; i < aList[node].size(); i += 2) {
            int next = aList[node].get(i);
            int distance = aList[node].get(i + 1);
            if (dis[next] > dis[node] + distance || dis[next] == -1) {
                dis[next] = dis[node] + distance;
                dfs(dis, next, aList);
            }
        }
    }
    public static void bfs (long[] dis, int node, ArrayList<Integer>[] aList) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(node, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.dis > dis[p.node] && dis[p.node] != -1) continue;
            for (int i = 0; i < aList[p.node].size(); i+=2) {
                int next = aList[p.node].get(i);
                long distance = aList[p.node].get(i + 1);
                if (dis[next] == -1 || dis[next] > dis[p.node] + distance) {
                    dis[next] = dis[p.node] + distance;
                    pq.add(new Pair(next, dis[next]));
                }
            }
        }
    }
    static class Pair implements Comparable{
        int node;
        long dis;
        public Pair (int nodee, long diss) {
            dis = diss; node = nodee;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(dis, ((Pair)o).dis);
        }
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
    }}