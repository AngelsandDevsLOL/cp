package CCC.Senior;

import java.util.Scanner;

public class SuperPlumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        while (x != 0 && y != 0) {
            int[][] ar = new int[x][y];
            int[][] dis = new int[x][y];
            boolean[][] vis = new boolean[x][y];
            sc.nextLine();
            for (int i = 0; i < x; i++) {
                String input = sc.nextLine();
                for (int j = 0; j < y; j++) {
                    if (input.charAt(j) == '*') {
                        ar[i][j] = -1;
                    } else if (input.charAt(j) != '.') {
                        ar[i][j] = input.charAt(j) - '0';
                    }
                }
            }
            recursion(vis, x - 1, 0, ar);
            dis[x - 1][0] = ar[x - 1][0];
            for (int i = x - 2; i >= 0; i--) {
                if (!vis[i][0]) break;
                dis[i][0] = dis[i + 1][0] + ar[i][0];
            }
            for (int i = 0; i < y - 1; i++) {
                for (int j = x - 1; j >= 0; j--) {
                    // cry
                    //j, i
                    if (!vis[j][i]) continue;
                    int sum = dis[j][i];
                    if (!vis[j][i + 1]) continue;
                    sum += ar[j][i + 1];
                    dis[j][i + 1] = Math.max(sum, dis[j][i + 1]);
                    for (int k = j + 1; k < x; k++) { // down
                        if (!vis[k][i + 1]) break;
                        sum += ar[k][i + 1];
                        dis[k][i + 1] = Math.max(sum, dis[k][i + 1]);
                    }
                    sum = dis[j][i] + ar[j][i + 1];
                    for (int k = j - 1; k >= 0; k--) { // up
                        if (!vis[k][i + 1]) break;
                        sum += ar[k][i + 1];
                        dis[k][i + 1] = Math.max(sum, dis[k][i + 1]);
                    }
                }
            }
            System.out.println(dis[x - 1][y - 1]);
            x = sc.nextInt(); y = sc.nextInt();
        }
    }
    public static boolean check (int x, int y, int n, int m) {
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }
    public static void recursion (boolean[][] vis, int x, int y, int[][] ar) {
        vis[x][y] = true;
        if (check(x - 1, y, vis.length, vis[0].length) && !vis[x - 1][y] && ar[x - 1][y] != -1) {
            recursion(vis, x - 1, y, ar);
        }
        if (check(x + 1, y, vis.length, vis[0].length) && !vis[x + 1][y] && ar[x + 1][y] != -1) {
            recursion(vis, x + 1, y, ar);
        }
        if (check(x, y + 1, vis.length, vis[0].length) && !vis[x][y + 1] && ar[x][y + 1] != -1) {
            recursion(vis, x, y + 1, ar);
        }
    }
}