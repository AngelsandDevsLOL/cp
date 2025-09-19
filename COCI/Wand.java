package COCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Wand {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] paths = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            paths[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            paths[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n+1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : paths[cur]) {
                if (!vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i == 1 && paths[1].isEmpty()) {
                System.out.print(1);
            }
            if (vis[i]) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }
}
