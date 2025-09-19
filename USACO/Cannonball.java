package USACO;

import java.util.Scanner;

public class Cannonball {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cur = sc.nextInt() - 1;
        int v = 1;
        int direction = 1; // right
        boolean[][] type = new boolean[n][2];
        int[][] store = new int[n][2]; // left's previous power, right's prev. power
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            type[i][0] = sc.nextInt() == 1;
            num[i] = sc.nextInt();
        }
        int count = 0;
        while (cur >= 0 && cur < n && store[cur][direction] < v) {
            store[cur][direction] = v;
            if (type[cur][0]) {// target
                if (!type[cur][1]) {// workable
                    if (v >= num[cur]) {
                        count++;
                        type[cur][1] = true;
                    }
                }
                if (direction == 1) cur += v;
                else cur -= v;
            } else {
                if (direction == 1) {
                    direction = 0;
                    v += num[cur];
                    cur -= v;
                } else {
                    direction = 1;
                    v += num[cur];
                    cur += v;
                }
            }
        }
        System.out.println(count);
    }
}
