package CCC;

import java.util.Scanner;

public class HarvestWaterloo {
    public static int count = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] ar = new int[r][c];
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == '*') ar[i][j] = -1;
                else if (input.charAt(j) == 'L') ar[i][j] = 10;
                else if (input.charAt(j) == 'M') ar[i][j] = 5;
                else if (input.charAt(j) == 'S') ar[i][j] = 1;
            }
        }
        int x = sc.nextInt(), y = sc.nextInt();
        boolean[][] vis = new boolean[r][c];
        vis[x][y] = true;
        count += ar[x][y];
        dfs(x, y, vis, ar);
        System.out.println(count);
    }
    public static void dfs (int x, int y, boolean[][] vis, int[][] ar) {
        int[][] arrr = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            if (check(x + arrr[i][0], y + arrr[i][1], vis.length, vis[0].length) && ar[x + arrr[i][0]][y + arrr[i][1]] != -1 && !vis[x + arrr[i][0]][y + arrr[i][1]]) {
                count += ar[x + arrr[i][0]][y + arrr[i][1]];
                vis[x + arrr[i][0]][y + arrr[i][1]] = true;
                dfs(x + arrr[i][0], y + arrr[i][1], vis, ar);
            }
        }
    }
    public static boolean check (int x, int y, int a, int b) {
        if (x >= 0 && y >= 0 && x < a && y < b) return true;
        return false;
    }
}
