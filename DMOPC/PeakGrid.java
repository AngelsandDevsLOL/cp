package DMOPC;

import java.util.Scanner;

public class PeakGrid {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] ar = new int[n][n];
        int i;
        for (i = 0; i < k; i++) {
            ar[i][i] = n* n - i;
        }
        for (int j = i; j < n; j++) {
            ar[i - 1][j] = n * n - j;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int l = 0; l < n; l++) {
                if (ar[j][l] == 0) {
                    ar[j][l] = ++count;
                }
                System.out.print(ar[j][l] + " ");
            }
            System.out.println();
        }
    }
}
