package DMOPC;

import java.util.Scanner;

public class LeleiAndDragonScales {
    static int w, h, n;
    static int[][] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt(); h = sc.nextInt(); n = sc.nextInt();
        ar = new int[h + 2][w + 2];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                ar[i][j] = sc.nextInt();
                ar[i][j] += ar[i][j - 1] + ar[i - 1][j] - ar[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                for (int k = 1; j + k - 1 <= h; k++) { // height
                    ans = Math.max(ans, check(i, j, i + n / k - 1, j + k - 1));
                }
            }
        }
        System.out.println(ans);
    }
    public static int check(int x, int y, int a, int b) {
        if (a <= h && b <= w) {
            return ar[a][b] - ar[x - 1][b] - ar[a][y - 1] + ar[x - 1][y - 1];
        } return 0;
    }
}
