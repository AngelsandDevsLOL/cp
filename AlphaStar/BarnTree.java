package AlphaStar;

import java.util.*;
import java.io.*;

public class BarnTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        long[][] hay = new long[n][2];
        ArrayList<Integer>[] aList = new ArrayList[n];
        long sum = 0;
        int max = 0;
        int ind = n - 1;
        for (int i = 0; i < n; i++) {
            int h = readInt();
            hay[i][0] = h;
            if (h > max) {max = h;}
            sum += h;
            aList[i] = new ArrayList<>();
        }
        sum /= n;
        for (int i = 0; i < n - 1; i++) {
            int a = readInt() - 1, b = readInt() - 1;
            aList[a].add(b);
            aList[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            if (aList[i].size() == 1) q.add(i);
        }
        Queue<Long> ans = new LinkedList<>();
        Stack<Long> ans2 = new Stack<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            if (hay[x][1] == aList[x].size() - 1) {
                hay[x][1]++;
                hay[x][0] -= sum;
                for (int next : aList[x]) {
                    if (hay[next][1] <= aList[next].size() - 1) {
                        if (next != ind) {
                            hay[next][0] += hay[x][0];
                            q.add(next);
                        }
                        hay[next][1]++;
                        if (hay[x][0] > 0) {
                            ans.add((long) x);
                            ans.add((long) next);
                            ans.add(hay[x][0]);
                        } else if (hay[x][0] < 0) {
                            ans2.add(-hay[x][0]);
                            ans2.add((long) x);
                            ans2.add((long) next);
                        }
                    }
                }
            }
        }
        System.out.println((ans.size() / 3 + ans2.size() / 3));
        while (!ans.isEmpty()) {
            System.out.println((ans.poll() + 1) + " " + (ans.poll() + 1) + " " + ans.poll());
        }
        while (!ans2.isEmpty()) {
            System.out.println((ans2.pop() + 1) + " " + (ans2.pop() + 1) + " " + ans2.pop());
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
