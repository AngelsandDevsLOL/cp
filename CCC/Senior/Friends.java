package CCC.Senior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Friends {
    static boolean bool = false;
    static int[] x;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> input = new HashMap<>(); // input, var name
        ArrayList<Integer>[] ar = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new ArrayList<>();
        }
        x = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (input.containsKey(x)) {
                x = input.get(x);
            } else {
                input.put(x, count);
                x = count;
                count++;
            }
            if (input.containsKey(y)) {
                y = input.get(y);
            } else {
                input.put(y, count);
                y = count;
                count++;
            }
            ar[x].add(y);
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        while (x != 0 && y != 0) {
            boolean[] vis = new boolean[n+1];
            int[] dis = new int[n+1];
            x = input.get(x);
            y = input.get(y);
            vis[x] = true;
            dfs(ar, vis, dis, x);
            if (!vis[y]) {
                System.out.println("No");
            } else {
                System.out.println("Yes " + (dis[y] -1));
            }
            x = scanner.nextInt();
            y = scanner.nextInt();
        }

    }
    static void dfs(ArrayList<Integer>[] ar, boolean[] vis, int[] dis, int cur) {
        for (int i : ar[cur]) {
            if (!vis[i]) {
                vis[i] = true;
                dis[i] = dis[cur] + 1;
                dfs(ar, vis, dis, i);
            }
        }
    }
}