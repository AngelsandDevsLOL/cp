package Random;

import java.util.Scanner;

public class Grid1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[h][w];
        ar[0][0] = 1;
        boolean[][] vis = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < w; j++) {
                if (input.charAt(j) == '#') {
                    vis[i][j] = true;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (vis[i][j]) continue;
                if (check(vis, i - 1, j)) {
                    ar[i][j] += ar[i - 1][j];
                }
                if (check(vis, i, j - 1)) {
                    ar[i][j] += ar[i][j - 1];
                }
                ar[i][j] %= 1000000007;
            }
        }
        System.out.println(ar[h - 1][w - 1]);
    }
    public static boolean check (boolean[][] ar, int x, int y) {
        if (x >= 0 && y >= 0 && x < ar.length && y < ar[0].length && !ar[x][y]) return true;
        return false;
    }
}
