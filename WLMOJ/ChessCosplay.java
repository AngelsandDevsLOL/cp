package WLMOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChessCosplay {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 0, x2 = 0, y2 = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'H') {
                    x = i; y = j;
                } else if (input.charAt(j) == 'S') {
                    x2 = i; y2 = j;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(x2);
        q.add(y2);
        int[][] dis = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        vis[x2][y2] = true;
        int[][] ar = {{1, 2},{-1, 2},{-1, -2},{1, -2},{2, 1},{2, -1},{-2, 1},{-2, -1}};
        while (!q.isEmpty()) {
            int x1 = q.poll();
            int y1 = q.poll();
            for (int i = 0; i < 8; i++) {
                if (check(x1 + ar[i][0], y1 + ar[i][1], n) && !vis[x1 + ar[i][0]][y1 + ar[i][1]]) {
                    vis[x1 + ar[i][0]][y1 + ar[i][1]] = true;
                    q.add(x1 + ar[i][0]);
                    q.add(y1 + ar[i][1]);
                    dis[x1 + ar[i][0]][y1 + ar[i][1]] = dis[x1][y1] + 1;
                }
            }
        }
        System.out.println(dis[x][y] * 3 + Math.abs(y - y2) + Math.abs(x - x2));
    }
    public static boolean check (int x, int y, int n) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    }
}
