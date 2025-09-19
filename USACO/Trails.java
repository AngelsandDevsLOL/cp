package USACO;

import java.util.Arrays;
import java.util.Scanner;

public class Trails {
    public static int[][] dis;
    public static int n;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); int b = sc.nextInt();
        sc.nextLine();
        dis = new int[n][n];
        dis[0][0] = 1;
        boolean[][] barriers = new boolean[n][n];
        for (int i = 0; i < b; i++) {
            String input = sc.nextLine();
            barriers[Integer.parseInt(input.substring(1)) - 1][input.charAt(0) - 'A'] = true;
        }
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        recursion(0, 0, "right", barriers, vis, 1);
        recursion(0, 0, "down", barriers, vis, 1);
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dis[i][j] > count) count = dis[i][j];
            }
        }
        System.out.println(count);
    }
    public static void recursion (int x, int y, String direction, boolean[][] barriers, boolean[][] vis, int count) {
        if (direction.equals("left")) {
            if (y - 1 >= 0 && !barriers[x][y - 1]) {
                left(vis, x, y, barriers, count);
            } else {
                down(vis, x, y, barriers, count);
                up(vis, x, y, barriers, count);
            }
        } else if (direction.equals("right")) {
            if (y + 1 < n && !barriers[x][y + 1]) {
                right(vis, x, y, barriers, count);
            } else {
                down(vis, x, y, barriers, count);
                up(vis, x, y, barriers, count);
            }
        } else if (direction.equals("up")) {
            if (x - 1 >= 0 && !barriers[x - 1][y]) {
                up(vis, x, y, barriers, count);
            } else {
                left(vis, x, y, barriers, count);
                right(vis, x, y, barriers, count);
            }
        } else { // down
            if (x + 1 < n && !barriers[x + 1][y]) {
                down(vis, x, y, barriers, count);
            } else {
                left(vis, x, y, barriers, count);
                right(vis, x, y, barriers, count);
            }
        }
    }
    public static void left (boolean[][] vis, int x, int y, boolean[][] barriers, int count) {
        if (y - 1 >= 0 && !vis[x][y - 1] && !barriers[x][y - 1]) {
            vis[x][y - 1] = true;
            dis[x][y - 1] = Math.max(++count, dis[x][y - 1]);
            recursion(x, y - 1, "left", barriers, vis, count);
            vis[x][y - 1] = false;
        }
    }
    public static void down (boolean[][] vis, int x, int y, boolean[][] barriers, int count) {
        if (x + 1 < n && !vis[x + 1][y] && !barriers[x + 1][y]) {
            vis[x + 1][y] = true;
            dis[x + 1][y] = Math.max(++count, dis[x + 1][y]);
            recursion(x + 1, y, "down", barriers, vis, count);
            vis[x + 1][y] = false;
        }
    }
    public static void right (boolean[][] vis, int x, int y, boolean[][] barriers, int count) {
        if (y + 1 < n && !vis[x][y + 1] && !barriers[x][y + 1]) {
            vis[x][y + 1] = true;
            dis[x][y + 1] = Math.max(++count, dis[x][y + 1]);
            recursion(x, y + 1, "right", barriers, vis, count);
            vis[x][y + 1] = false;
        }
    }
    public static void up (boolean[][] vis, int x, int y, boolean[][] barriers, int count) {
        if (x - 1 >= 0 && !vis[x - 1][y] && !barriers[x - 1][y]) {
            vis[x - 1][y] = true;
            dis[x - 1][y] = Math.max(++count, dis[x - 1][y]);
            recursion(x - 1, y, "up", barriers, vis, count);
            vis[x - 1][y] = false;
        }
    }
}
