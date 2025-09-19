package YetAnotherContest;

import java.util.Scanner;

public class CoprimeGrid {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] ar = new int[n][m];
            int count = 2;
            if (n < 2 || m < 2) {
                System.out.println(-1);
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    for (int k = 0; k < m; k++) {
                        ar[j][k] = count++;
                        if (j == n - 1 && k == m - 1) {
                            ar[j][k] = 1;
                        }
                    }
                } else {
                    for (int k = m - 1; k >= 0; k--) {
                        ar[j][k] = count++;
                        if (j == n - 1 && k == 0) {
                            ar[j][k] = 1;
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    System.out.print(ar[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
    public static boolean check (int x, int y, int n, int m, int[][] ar) {
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }
}
