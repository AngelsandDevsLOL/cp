package Random;

import java.util.*;
import java.io.*;

public class Postman {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        for (int i = 0; i < n; i++) {
            int input = readInt();
        }
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i]= new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = readInt(), y = readInt();
            if (x == y || graph[x].contains(y)) continue;
            graph[x].add(y);
            graph[y].add(x);
        }
        ArrayList<Integer>[] copy = Arrays.copyOf(graph, n + 1);
        Stack<Integer> s = new Stack<>();
        int cur = 1;
        Stack<Integer> ans = new Stack<>();
        while (cur != -1) {
            if (graph[cur].size() == 0) {
                ans.add(cur);
                if (!s.isEmpty()) {
                    cur = s.pop();
                } else {break;}
            } else {
                int x = graph[cur].get(0);
                graph[cur].remove(0);
                graph[x].remove((Object) cur);
                s.add(cur);
                cur = x;
            }
        }
        int[] dis = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        vis[cur] = true;
        int goal = ans.firstElement();
        if (goal != cur) {
            dfs(dis, vis, q, copy, goal, ans);
        }
        System.out.println(ans.size() + dis[goal] - 1);
        print(ans);
        print(s);
        System.out.println();
    }
    public static void print(Stack<Integer>s) {
        if (s.isEmpty()) return;
        System.out.print(s.pop() + " ");
        print(s);
    }
    public static boolean dfs (int[] dis, boolean[] vis, Queue<Integer> q, ArrayList<Integer>[] copy, int goal, Stack<Integer> ans) {
        int x = q.poll();
        for (int num : copy[x]) {
            if (!vis[num]) {
                dis[num] = dis[x]++;
                vis[num] = true;
                if (num == goal) {
                    s.add(goal);
                    return true;
                }
                q.add(num);
                if (dfs(dis, vis, q, copy, goal, ans)) {
                    s.add(goal);
                    return true;
                }
            }
        }
        return false;
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

}