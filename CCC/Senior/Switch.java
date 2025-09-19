package CCC.Senior;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Switch {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        boolean[] vis = new boolean[1 << k];
        int mask = 0;
        for (int i = 0; i < k; i++) {
            mask <<= 1;
            mask |= sc.nextInt();
        }
        vis[mask] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(mask);
        q.add(0);
        while (!q.isEmpty()) {
            int x = q.poll();
            int dis = q.poll();
            if (x == 0) {
                System.out.println(dis);
                return;
            }
            for (int i = 0; i < k; i++) {
                if ((x | (1 << i)) != x) { // 0 at i
                    int newMask = solve(x | (1 << i), k);
                    if (!vis[newMask]) {
                        vis[newMask] = true;
                        q.add(newMask);
                        q.add(dis + 1);
                    }
                }
            }
        }
    }
    public static int solve (int x, int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if ((x | (1 << i)) == x) { // 1
                count++;
            } else {
                if (count >= 4) {
                    x ^= ((1 << count) - 1) << (i - count);
                }
                count = 0;
            }
        }
        return x;
    }
}
