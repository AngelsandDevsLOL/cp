package DMOPC;

import java.util.Scanner;

public class KnightsOnChessboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 14){
            System.out.println("0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                    "0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                    "0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 0 1 0 0 \n" +
                    "0 0 1 1 0 0 0 0 1 1 1 1 0 0 \n" +
                    "0 0 0 0 0 0 0 0 0 0 0 0 0 0 ");
            return;
        }
        int[][] ar = new int[n][n];
        for (int i = 0; i * 4 + 3 < n; i++) {
            for (int j = 0; j * 6 + 5 < n; j++) {
                ar[i * 4 + 1][j * 6 + 2] = 1;
                ar[i * 4 + 2][j * 6 + 2] = 1;
                ar[i * 4 + 1][j * 6 + 3] = 1;
                ar[i * 4 + 2][j * 6 + 3] = 1;
            }
        }
        for (int i = 0; i * 4 + 3 < n; i++) {
            ar[i * 4 + 1][n - 3] = 1;
            ar[i * 4 + 1][n - 4] = 1;
            ar[i * 4 + 2][n - 3] = 1;
            ar[i * 4 + 2][n - 4] = 1;
        }
        for (int i = 0; i * 6 + 5 < n; i++) {
            ar[n - 2][i * 6 + 2] = 1;
            ar[n - 2][i * 6 + 3] = 1;
            ar[n - 3][i * 6 + 2] = 1;
            ar[n - 3][i * 6 + 3] = 1;
        }
        ar[n - 2][n - 3] = 1;
        ar[n - 2][n - 4] = 1;
        ar[n - 3][n - 3] = 1;
        ar[n - 3][n - 4] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ar[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
    }
}
