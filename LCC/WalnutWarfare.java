package LCC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WalnutWarfare {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            aList[u].add(v);
            aList[v].add(u);
        }
        int[] squirrel = new int[m];
        for (int i = 0; i < m; i++) {
            squirrel[i] = scanner.nextInt();
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        q.add(1);
        vis[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : aList[cur]) {
                if (!vis[i]) {
                    q.add(i);
                    vis[i] = true;
                    dis[i] = dis[cur] + 1;
                }
            }
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dis[squirrel[i]] < smallest) smallest = dis[squirrel[i]];
        }
        int count = 0;
        for (int i = 2; i < dis.length; i++) {
            if (dis[i] < smallest && vis[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
