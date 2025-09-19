package NoContest;

import java.io.*;
import java.util.*;

public class SleighRide {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        ArrayList<Integer>[] dist = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
            dist[i] = new ArrayList<>();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();
            sum = sum + c;
            aList[a].add(b);
            aList[b].add(a);
            dist[a].add(c);
            dist[b].add(c);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] dis = new int[n + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            ArrayList<Integer> people = aList[cur];
            ArrayList<Integer> distance = dist[cur];
            for (int i = 0; i < people.size(); i++) {
                if (dis[people.get(i)] > dis[cur] + distance.get(i) || (people.get(i) != 0 && dis[people.get(i)] == 0)) {
                    dis[people.get(i)] = dis[cur] + distance.get(i);
                    q.add(people.get(i));
                }
            }
        }
        Arrays.sort(dis);
        System.out.println(2 * sum - dis[dis.length-1]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}