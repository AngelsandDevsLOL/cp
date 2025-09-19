package CCCHK;

import java.util.Scanner;

public class SymmetricCross {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        boolean[][] ar = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int input = sc.nextInt();
                ar[i][j] = input == 1;
            }
        }
        int ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int max = Math.min(Math.min(i, j), Math.min(r - i - 1, c - j - 1));
                if (max <= ans) continue;
                int k;
                for (k = 1; k <= max; k++) {
                    if (ar[i][j + k] == ar[i][j - k] && ar[i][j + k] == ar[i + k][j] && ar[i - k][j] == ar[i][j + k]) {
                        // yay!
                    } else {
                        break;
                    }
                }
                if (k - 1 > ans) {
                    ans = k - 1;
                    x = i + 1; y = j + 1;
                }
            }
        }
        System.out.println(ans + " " + x + " " + y);
    }
}
