package USACO;

import java.util.*;

public class BarnTree {
    public static int[] ar;
    public static int hay;
    public static ArrayList<Integer>[] edges;
    public static Stack<Integer> stack;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ar = new int[n + 1];
        stack = new Stack<>();
        int sum = 0;
        int max = 0;
        int ind = 0;
        for (int i = 1; i <= n; i++) {
            ar[i] = sc.nextInt();
            sum += ar[i];
            if (ar[i] > max) {
                max = ar[i];
                ind = i;
            }
        }
        hay = sum / n;
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            edges[x].add(y);
            edges[y].add(x);
        }
        boolean[] vis = new boolean[n + 1];
        vis[ind] = true;
        dfs(ind, vis);
        System.out.println(stack.size() / 3);
        while (!stack.isEmpty()) {
            int weight = stack.pop();
            int e1 = stack.pop();
            int e2 = stack.pop();
            System.out.println(e2+ " " + e1 + " " + weight);
        }
    }
    public static int dfs (int start, boolean[] vis) {
        int count = ar[start] - hay;
        for (int x : edges[start]) {
            if (vis[x]) continue;
            vis[x] = true;
            int num = dfs(x, vis);
            if (num < 0) {
                stack.add(start);
                stack.add(x);
                stack.add(-num);
            } else if (num > 0) {
                stack.add(x);
                stack.add(start);
                stack.add(num);
            }
            count += num;
        }
        return count;
    }
}
