package USACO;

import java.util.Scanner;

public class StampGrid {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            int n = sc.nextInt();
            boolean[][] vis = new boolean[n][n];
            boolean[][] black = new boolean[n][n];
            sc.nextLine();
            for (int j = 0; j < n; j++) {
                String input = sc.nextLine();
                for (int k = 0; k < n; k++) {
                    if (input.charAt(k) == '*') {
                        black[j][k] = true;
                    }
                }
            }
            int n2 = sc.nextInt();
            boolean[][] stamp = new boolean[n2][n2];
            sc.nextLine();
            for (int j = 0; j < n2; j++) {
                String input = sc.nextLine();
                for (int k = 0; k < n2; k++) {
                    if (input.charAt(k) == '*') {
                        stamp[j][k] = true;
                    }
                }
            }
            for (int z = 0; z < 4; z++) {
                for (int j = 0; j <= n - n2; j++) {
                    for (int k = 0; k <= n - n2; k++) {
                        if (check(j, k, stamp, black)) {
                            for (int a = 0; a < n2; a++) {
                                for (int b = 0; b < n2; b++) {
                                    if (stamp[a][b] && black[a + j][b + k]) {
                                        vis[a + j][b + k] = true;
                                    }
                                }
                            }
                        }
                    }
                }
                rotateMatrix(stamp);
            }
            boolean bool = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!vis[j][k] && black[j][k]) {
                        bool = false; break;
                    }
                }
            }
            if (bool) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean check (int x, int y, boolean[][] stamp, boolean[][] black) {
        for (int i = 0; i < stamp.length; i++) {
            for (int j = 0; j < stamp.length; j++) {
                if (stamp[i][j] && !black[i + x][j + y]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void rotateMatrix(boolean mat[][])
    {
        int N = mat.length;
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                boolean temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
    }
}
